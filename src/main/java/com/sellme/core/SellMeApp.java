/**
 * 
 */
package com.sellme.core;

import com.sellme.resource.LoginResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Swapnil Singh
 *
 */
public class SellMeApp extends Application<SellMeConfiguration> {

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
    public void run(SellMeConfiguration arg0, Environment environmanet)
            throws Exception {
        //final LoginResource loginResource = new LoginResource();
        environmanet.jersey().register(LoginResource.class);
    }

}
