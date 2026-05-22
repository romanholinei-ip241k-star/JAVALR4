package com.lab;

import com.lab.resources.ProductResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class JAVALR4Application extends Application<JAVALR4Configuration> {

    public static void main(String[] args) throws Exception {
        new JAVALR4Application().run(args);
    }

    @Override
    public void run(JAVALR4Configuration configuration, Environment environment) {
        // Реєструємо наш контролер
        environment.jersey().register(new ProductResource());
    }
}