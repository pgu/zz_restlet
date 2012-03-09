package com.pgu.restlet;

import java.util.logging.Level;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.resource.UniformResource;
import org.restlet.service.StatusService;

public class PguStatusService extends StatusService {

    @Override
    public Status getStatus(final Throwable throwable, final UniformResource resource) {
        System.out.println("*** get status ");
        if (throwable instanceof BusinessException) {
            resource.getLogger().log(Level.WARNING,
                    BusinessException.class.getSimpleName() + ": " + throwable.getMessage(), throwable);

        } else if (throwable instanceof NotFoundException) {
            resource.getLogger().log(Level.WARNING,
                    NotFoundException.class.getSimpleName() + ": " + throwable.getMessage(), throwable);

        }
        return super.getStatus(throwable, resource);
    }

    @Override
    public Status getStatus(final Throwable throwable, final Request arg1, final Response arg2) {
        System.out.println("**** get status ");

        if (throwable instanceof BusinessException) {
            return Status.CLIENT_ERROR_BAD_REQUEST;

        }
        if (throwable instanceof NotFoundException) {
            return Status.CLIENT_ERROR_NOT_FOUND;

        }
        return super.getStatus(throwable, arg1, arg2);
    }

}
