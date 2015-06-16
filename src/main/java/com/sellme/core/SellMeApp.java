package com.sellme.core;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import org.skife.jdbi.v2.DBI;
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
    	bootstrap.addBundle(new SwaggerBundle<SellMeConfiguration>() {
			@Override
			protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
					SellMeConfiguration sellMeConfiguration) {
				return sellMeConfiguration.swaggerBundleConfiguration;
			}

		});
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
        initlizeServices();
        LOGGER.info("Initializing Resources.");
        environment.jersey().register(new LoginResource());
        environment.jersey().register(new UserResource(userService));
    }


    private void initlizeServices() {
        this.userService = new UserService(userDAO);
    }

    /**
     * The following method will initialize all the DAOs
     */
    private void initlizeDAO() {
        this.userDAO = jdbi.onDemand(UserDAO.class);
    }
}
