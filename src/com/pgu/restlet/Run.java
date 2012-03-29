package com.pgu.restlet;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class Run {

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

        component.getDefaultHost().attach(application);
        component.start();

    }

}
