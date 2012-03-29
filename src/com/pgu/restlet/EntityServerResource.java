package com.pgu.restlet;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class EntityServerResource extends ServerResource {

    @Get
    public String retrieve() {
        final Integer id = Integer.parseInt(getRequestAttributes().get("id").toString());

        System.out.println(">>> get the entity: " + id);

        if (0 == id) {
            System.out.println(">>> illegal arg exception ");
            throw new IllegalArgumentException();

        } else if (1 == id) {
            System.out.println(">>> not found exception ");
            throw new NotFoundException();

        } else {
            System.out.println(">>> else... ");
            return "alright :-)";
        }
    }

}
