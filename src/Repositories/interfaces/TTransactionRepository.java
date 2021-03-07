package Repositories.interfaces;

import entities.Item;
import entities.Transaction;

import java.util.ArrayList;

public interface TTransactionRepository {
    public ArrayList<Transaction> TransactionRepository(Boolean returned );
}
