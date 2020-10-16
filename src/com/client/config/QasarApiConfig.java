package com.client.config;

import com.client.api.IQasarBankApi;
import com.client.api.QasarBankRestApiClient;

/**
 * Centralized configuration class containing credential info used to auth on Qasar bank
 * Assumption - http basic auth containing username and password
 *
 * @author michaelf
 */
public class QasarApiConfig
{
    public String getApiUsername()
    {
        return "apiusername";
    }

    public String getApiPassword()
    {
        return "apipassword";
    }

    public String getApiBaseUrl()
    {
        return "http://1.2.3.4/";
    }

    public IQasarBankApi getApiClient () throws Exception
    {
        return QasarBankRestApiClient.class.getConstructor().newInstance();
    }
}
