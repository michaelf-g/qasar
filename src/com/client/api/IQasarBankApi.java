package com.client.api;

import com.client.entities.UserInfo;
import com.client.order.AccountOrder;

/**
 * Qasar Bank interface
 *
 * @author michaelf
 */
public interface IQasarBankApi
{
    AccountOrder createNewAccount(AccountOrder accountOrder) throws Exception;

    UserInfo getUserInformation(String customerId) throws Exception;
}
