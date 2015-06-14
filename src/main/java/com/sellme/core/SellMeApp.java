/**
 * 
 */
package com.sellme.core;

import javax.sql.DataSource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.spring.DBIFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sellme.dao.UserDAO;
import com.sellme.resource.LoginResource;
import com.sellme.resource.UserResource;
import com.sellme.service.UserService;

/**
 * @author Swapnil Singh
 *
 */
public class SellMeApp extends Application<SellMeConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SellMeApp.class);
    private final DBIFactory dbiFactory = new DBIFactory();
    private DBI jdbi;
    private UserDAO userDAO;
    private UserService userService;
    /**
     * The following method is an entry point for the SellMeApp.
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new SellMeApp().run(args);
    }

    /*
     * (non-Javadoc)
     * 
     * @see io.dropwizard.Application#initialize(io.dropwizard.setup.Bootstrap)
     */
    @Override
    public void initialize(Bootstrap<SellMeConfiguration> bootstrap) {
        // nothing to do yet
    }

    /*
     * (non-Javadoc)
     * 
     * @see io.dropwizard.Application#run(io.dropwizard.Configuration,
     * io.dropwizard.setup.Environment)
     */
    @Override
    public void run(SellMeConfiguration sellMeConfiguration, Environment environment)
            throws Exception {
        // Initializing Database Connection
        this.jdbi = this.dbiFactory.build(environment, sellMeConfiguration.getDatabase(), "mysql");
        initlizeDAO();
        initlizeServices(sellMeConfiguration);
        LOGGER.info("Initializing Resources.");
        environment.jersey().register(new LoginResource());
        environment.jersey().register(new UserResource(userService));
    }

    /**
     * The following method initializes all the Services.
     * @param sellMeConfiguration
     */
    private void initlizeServices(SellMeConfiguration sellMeConfiguration) {
        this.userService = new UserService(userDAO, sellMeConfiguration);
    }

    /**
     * The following method will initialize all the DAOs 
     */
    private void initlizeDAO() {
        this.userDAO = jdbi.onDemand(UserDAO.class);
    }
}
