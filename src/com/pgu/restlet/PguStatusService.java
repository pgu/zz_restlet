package com.pgu.restlet;

import java.util.logging.Level;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.resource.Resource;
import org.restlet.service.StatusService;

public class PguStatusService extends StatusService {

    @Override
    public Status getStatus(final Throwable throwable, final Resource resource) {
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

        if (throwable != null) {
            final Throwable cause = throwable.getCause();

            if (cause instanceof BusinessException) {
                System.out.println("**** " + Status.CLIENT_ERROR_BAD_REQUEST.getCode());
                return Status.CLIENT_ERROR_BAD_REQUEST;

            }
            if (cause instanceof NotFoundException) {
                System.out.println("**** " + Status.CLIENT_ERROR_NOT_FOUND.getCode());
                return Status.CLIENT_ERROR_NOT_FOUND;

            }
        }

        return super.getStatus(throwable, arg1, arg2);
    }

}
