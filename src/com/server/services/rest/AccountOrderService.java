package com.server.services.rest;

import com.client.order.AccountOrder;
import com.server.entity.QasarTransaction;
import com.server.entity.QasarUserProfile;
import com.server.orders.QasarAccountOrder;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;
import java.net.URI;

/**
 * Accepts an Account Order object from client using API containing all the info (customerId and initialCredit) required for a new account to be created
 *
 * @author michaelf
 */
public class AccountOrderService
{
    @Context
    private SecurityContext securityContext;
    @Context
    private UriInfo pathInfo;

    public AccountOrderService(SecurityContext securityContext, UriInfo pathInfo)
    {
        this.securityContext = securityContext;
        this.pathInfo = pathInfo;
    }

    @POST
    @Path("account/create")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response newAccountOrder(JAXBElement<AccountOrder> clientOrder)
    {
        Response response = null;
        AccountOrder newAccountOrder = clientOrder.getValue();

        //Ensure we have user in the system whose account we can connect to
        QasarUserProfile existingUser = loadQasarUserForCustomerId(newAccountOrder);

        if(existingUser != null)
        {
            try {
                //At this point we would look for an existing order for this customer in the db so we don't duplicate it
                QasarAccountOrder qasarAccountOrder = loadOrderByCustomerId(newAccountOrder);

                if (qasarAccountOrder == null)
                {
                    if (newAccountOrder.getCustomerId().isEmpty())
                        return Response.status(Response.Status.BAD_REQUEST).entity("Customer Id required").type(MediaType.TEXT_PLAIN_TYPE).build();
                    else
                    {
                        createQasarAccountOrderBasedOnClientOrder(newAccountOrder);         //create account order for processing later

                        if(newAccountOrder.getInitialCredit() != 0D)
                            createPendingTransaction(newAccountOrder.getInitialCredit());   //create pending tx for processing later
                    }

                    UriBuilder pathBuilder = pathInfo.getAbsolutePathBuilder();
                    URI uri = pathBuilder.build();
                    pathBuilder.replacePath(uri.getPath().replace("/account/create", ""));
                    pathBuilder.path(newAccountOrder.getCustomerId());
                    response = Response.created(pathBuilder.build()).build();
                }
                else
                {
                    UriBuilder pathBuilder = pathInfo.getAbsolutePathBuilder();
                    URI uri = pathBuilder.build();
                    pathBuilder.replacePath(uri.getPath().replace("/account/create", ""));
                    pathBuilder.path(qasarAccountOrder.getOrderReference());
                    response = Response.seeOther(pathBuilder.build()).status(302).build();
                }

            } catch (Exception e) {
                response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).type(MediaType.TEXT_PLAIN_TYPE).build();
            }
        }
        else
            response = Response.status(Response.Status.NOT_FOUND).build(); //no user found, can not create new account for user that does nto exist

        return response;
    }

    private QasarTransaction createPendingTransaction(double initialCredit)
    {
        return new QasarTransaction();
        //save to db as pending for processing later
    }

    private QasarUserProfile loadQasarUserForCustomerId(AccountOrder newAccountOrder)
    {
        return new QasarUserProfile();
        //load a Qasar User with customer Id from db
    }

    private QasarAccountOrder createQasarAccountOrderBasedOnClientOrder(AccountOrder newAccountOrder)
    {
        return new QasarAccountOrder(newAccountOrder);
        //save to db
    }

    private QasarAccountOrder loadOrderByCustomerId(AccountOrder newAccountOrder)
    {
        return new QasarAccountOrder();
        //load existing pending order for customerId if any
    }
}
