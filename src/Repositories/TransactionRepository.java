package Repositories;

import Repositories.interfaces.IItemRepository;
import data.interfaces.IDBManager;
import entities.Customer;
import data.DBManager;
import entities.Item;
import entities.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class TransactionRepository {
    private final IDBManager dbManager;

    public TransactionRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    public ArrayList<Transaction> Return(Boolean returned) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from transaction \n" +
                    "where returned=true;");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Transaction> transactions = new ArrayList<>();
            while (resultSet.next()) {
                Transaction transaction = new Transaction(resultSet.getInt("transaction_id"),
                        resultSet.getDate("transaction_date"),
                        resultSet.getBoolean("returned"),
                        resultSet.getDouble("amount"));
                transactions.add(transaction);
            }
            return transactions;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

