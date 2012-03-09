package com.pgu.restlet;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;

public class EntityServerResource extends ServerResource {

    public static void main(final String[] args) throws Exception {

        final Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8182);

        final Application application = new Application(component.getContext().createChildContext()) {

            @Override
            public Restlet createInboundRoot() {
                final Router router = new Router(getContext());

                // http://localhost:8182/entities/

                router.attach("/entities/{id}", EntityServerResource.class);
                router.attach("/entities/", EntitiesServerResource.class);
                // router.attach("/users/{user}/orders", EntitiesResource.class);
                // router.attach("/users/{user}/orders/{order}", OrderResource.class);
                return router;
            }

        };
        application.setStatusService(new PguStatusService());

        // PguResource.class
        component.getDefaultHost().attach(application);
        component.start();

    }

    @Get
    public String retrieve() {
        final Integer id = Integer.parseInt(getRequestAttributes().get("id").toString());

        System.out.println(">>> get the entity: " + id);

        if (0 == id) {
            throw new IllegalArgumentException();

        } else if (1 == id) {
            throw new NotFoundException();

        } else {
            return "alright :-)";
        }
    }

}
