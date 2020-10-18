package com.client.api;

import com.client.config.QasarApiConfig;
import com.client.entities.UserInfo;
import com.client.order.AccountOrder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import javax.ws.rs.core.MediaType;
import java.net.URI;

/**
 * Qasar Bank API implementation allows
 *
 * 1. Requesting a new account from Qasar Bank
 * 2. Get user information from a Qasar user, together with bank account and transactions if any
 *
 * @author michaelf
 */
public class QasarBankRestApiClient implements IQasarBankApi
{
    private static Client client;
    private static QasarApiConfig config;

    public QasarBankRestApiClient()
    {}

    static
    {
        config = new QasarApiConfig();
        client = Client.create();
        client.setFollowRedirects(false);
        client.addFilter(new HTTPBasicAuthFilter(config.getApiUsername(), config.getApiPassword()));
        //client.addFilter(new LoggingFilter()); //For testing
    }

    @Override
    public AccountOrder createNewAccount(AccountOrder accountOrder) throws Exception {
        WebResource resource = getWebResource();

        ClientResponse response = resource.path("account").path("create").path(accountOrder.getCustomerId()).type(MediaType.APPLICATION_XML_TYPE).post(ClientResponse.class, accountOrder);

        if (response.getStatus() == ClientResponse.Status.CREATED.getStatusCode() || response.getStatus() == ClientResponse.Status.OK.getStatusCode()
                || response.getStatus() == ClientResponse.Status.SEE_OTHER.getStatusCode() || response.getStatus() == ClientResponse.Status.FOUND.getStatusCode())
        {
            URI orderLocation = response.getLocation();
            if (orderLocation != null)
            {
                resource = QasarBankRestApiClient.client.resource(orderLocation);
                return resource.accept(MediaType.APPLICATION_XML_TYPE).get(AccountOrder.class);
            }
        }
        else
            throw new Exception("Failed to create the new account order. Response code: "+response.getStatus()+", Message: "+response.getEntity(String.class));

        return null;
    }

    @Override
    public UserInfo getUserInformation(String customerId) {
        WebResource resource = getWebResource();
        return resource.path("user").path(customerId).accept(MediaType.APPLICATION_JSON_TYPE).get(UserInfo.class);
    }

    private WebResource getWebResource()
    {
        return QasarBankRestApiClient.client.resource(config.getApiBaseUrl());
    }
}
