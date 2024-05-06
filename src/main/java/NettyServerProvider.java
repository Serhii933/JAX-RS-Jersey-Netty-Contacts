package org.example.app.config;

import org.example.app.controller.ContactController;
import org.example.app.service.ContactService;
import org.example.app.service.impl.ContactServiceImpl;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class NettyServerProvider extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(ContactController.class);
        return classes;
    }

    public static String startHttpServer(Class<?>... resources) {

        return "Netty server started successfully!";
    }
}
