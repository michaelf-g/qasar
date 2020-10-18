package com.test;

import com.client.api.IQasarBankApi;
import com.client.config.QasarApiConfig;
import com.client.entities.Account;
import com.client.order.AccountOrder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

/**
 * Simple JUnit in memory test for API call
 *
 * @author michaelf
 */
public class QasarApiTest
{
    static Account account = null;
    static AccountOrder order = null;

    @BeforeClass
    public static void init()
    {
        account = new Account("custId-9876", 0D, Account.AccountType.Current.ordinal(), new Date());
        order = new AccountOrder("ref123", AccountOrder.AccountOrderStatus.Pending.ordinal(),
                Account.AccountType.Current.ordinal(), account.getCustomerId(), 45.50D);
    }

    @Test
    public void testAccountCreationViaApi() throws Exception
    {
        IQasarBankApi api = new QasarApiConfig().getApiClient();
        api.createNewAccount(order);
    }

    @Test
    public void testAccountInfoRetrievalViaApi() throws Exception
    {
        IQasarBankApi api = new QasarApiConfig().getApiClient();
        api.getUserInformation(account.getCustomerId());
    }
}
