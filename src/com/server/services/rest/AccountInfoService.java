package com.server.services.rest;

import com.server.entity.QasarAccount;
import com.server.entity.QasarTransaction;
import com.server.entity.QasarUserProfile;
import com.server.resources.UserInformation;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Outputs user information to client via API
 *
 * @author michaelf
 */
public class AccountInfoService
{
    @Context
    private SecurityContext securityContext;
    @Context
    private UriInfo pathInfo;

    public AccountInfoService(SecurityContext securityContext, UriInfo pathInfo)
    {
        this.securityContext = securityContext;
        this.pathInfo = pathInfo;
    }

    @GET
    @Path("user/{customerId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public UserInformation getSite(@PathParam("customerId") String customerId)
    {
        QasarUserProfile userProfile = loadQasarUserProfileForCustomerId(customerId);
        QasarAccount account = loadQasarAccountForCustomerId(customerId);
        List<QasarTransaction> transactions = loadQasarTransactionsForCustomerId(customerId);

        if (userProfile != null && account != null && transactions != null)
        {
            try
            {
                return new UserInformation(userProfile.getId(), userProfile.getName(), userProfile.getSurname(), account, transactions);
            }
            catch (Exception e)
            {
                throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
            }
        }
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    private List<QasarTransaction> loadQasarTransactionsForCustomerId(String customerId)
    {
        return new ArrayList<>();
        //load all the tx
    }

    private QasarAccount loadQasarAccountForCustomerId(String customerId)
    {
        return new QasarAccount();
        //load from db
    }

    private QasarUserProfile loadQasarUserProfileForCustomerId(String customerId)
    {
        return new QasarUserProfile();
        //load from db
    }


}
