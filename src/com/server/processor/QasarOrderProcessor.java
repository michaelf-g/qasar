package com.server.processor;

import com.server.entity.QasarAccount;
import com.server.orders.QasarAccountOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is responsible for processing all Qasar account orders asynchronously that have been approved
 * Opens a new account based on the order logged
 * Allows for retries
 *
 * @author michaelf
 */
public class QasarOrderProcessor implements Runnable
{
    @Override
    public void run()
    {
        List<QasarAccountOrder> ordersToProcess = loadAllApprovedOrdersFromDatabase();

        for (QasarAccountOrder toProcess : ordersToProcess)
        {
            createAccountBasedOnOrder(toProcess);
        }
    }

    private List<QasarAccountOrder> loadAllApprovedOrdersFromDatabase()
    {
        return new ArrayList<>();
    }

    private QasarAccount createAccountBasedOnOrder(QasarAccountOrder newAccountOrder)
    {
        return new QasarAccount(newAccountOrder.getCustomerId(), newAccountOrder.getInitialCredit(), newAccountOrder.getOrderTypeId(), new Date());
        //Save to db at this point
    }
}
