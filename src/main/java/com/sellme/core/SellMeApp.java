/**
 * 
 */
package com.sellme.core;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Swapnil Singh
 *
 */
public class SellMeApp extends Application<SellMeConfiguration>{

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        new SellMeApp().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<SellMeConfiguration> bootstrap) {
        // nothing to do yet
    }

    /* (non-Javadoc)
     * @see io.dropwizard.Application#run(io.dropwizard.Configuration, io.dropwizard.setup.Environment)
     */
    @Override
    public void run(SellMeConfiguration arg0, Environment arg1)
            throws Exception {
        // TODO Auto-generated method stub
        
    }

}
