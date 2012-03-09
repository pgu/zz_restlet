package com.pgu.restlet;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class EntitiesServerResource extends ServerResource {

    @Get
    public String retrieve() {
        System.out.println(">>> list of entities");

        throw new BusinessException();
        // return "ok dude";
    }

}
