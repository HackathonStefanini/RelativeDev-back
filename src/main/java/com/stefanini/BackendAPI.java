package com.stefanini;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped()
@ApplicationPath("api")
public class BackendAPI extends Application {
}
