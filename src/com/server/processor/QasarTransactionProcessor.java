package com.server.processor;

import com.server.entity.QasarAccount;
import com.server.entity.QasarTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will process any pending transaction in the queue
 *
 * @author michaelf
 */
public class QasarTransactionProcessor implements Runnable
{

    @Override
    public void run()
    {
        List<QasarTransaction> pendingTransactions = loadAllpendingQasarTransactionForProcessing();

        for (QasarTransaction pendingTransaction : pendingTransactions)
        {
            processTransaction(pendingTransaction);
            pendingTransaction.markAsComplete();
        }

    }

    private List<QasarTransaction> loadAllpendingQasarTransactionForProcessing()
    {
        return new ArrayList<>();
    }

    private void processTransaction(QasarTransaction pendingTransaction)
    {
        QasarAccount qasarAccount = loadQasarAccountForCustomerIdInTransaction();
        qasarAccount.updateBalance(pendingTransaction.getAmount());
    }

    private QasarAccount loadQasarAccountForCustomerIdInTransaction()
    {
        return new QasarAccount();
        //load qasar account whose customer id is the same as the trasaction customer id
    }
}
