package com.pgu.restlet;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class EntitiesServerResource extends ServerResource {

    @Get
    public String retrieve() {
        System.out.println(">>> list of entities");

        throw new BusinessException();
        // return "ok dude";
    }

    @Post
    public String addItem(final IsChild child) {
        System.out.println("addItem: " + child);
        return "99";
    }
}
