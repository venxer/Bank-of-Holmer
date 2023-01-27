package com.example.application.views.list;

import java.util.*;

public class CheckingAccount {
    private double balance;
    private String[][] tenRecentTransactionLog = new String[10][4]; // Time, Reciever Username, reciver firstname,
                                                                    // ammount
    private String accountUsername;
    private ArrayList<String> transactionLogTime = new ArrayList<>();
    private ArrayList<String> transactionLogUsername = new ArrayList<>();
    private ArrayList<String> transactionLogLastName = new ArrayList<>();
    private ArrayList<String> transactionLogAmount = new ArrayList<>();
    private static ArrayList<CheckingAccount> allCheckingAccounts = new ArrayList<>();

    public CheckingAccount(double balance, Account acc) {
        this.balance = balance;
        accountUsername = acc.getUsername();
    }

    public CheckingAccount() {
        System.out.println("Log: Nothing in this Checking Account");
    }

    public static void saveCheckingAccount(CheckingAccount checkingAcc) {
        allCheckingAccounts.add(checkingAcc);
    }

    public static CheckingAccount getCheckingAccountFromUserName(String username) // returns account based on username
    {
        return allCheckingAccounts.get(Account.arrayListIndex(Account.getUsernameList(), username));
    }

    public void logTransaction(String time, String username, String LastName, double amount) {
        replaceNull(tenRecentTransactionLog);
        transactionLogTime.add(0, time);
        transactionLogUsername.add(0, username);
        transactionLogLastName.add(0, LastName);
        transactionLogAmount.add(0, Double.toString(amount));
        for (int row = 0; row < tenRecentTransactionLog.length; row++) {
            printArr(tenRecentTransactionLog);
            for (int col = 0; col < tenRecentTransactionLog[row].length; col++) {
                if (row < transactionLogTime.size()) {
                    if (col == 0) {
                        tenRecentTransactionLog[row][col] = transactionLogTime.get(row);
                        // printArr(tenRecentTransactionLog);
                    }
                    if (col == 1) {
                        tenRecentTransactionLog[row][col] = transactionLogUsername.get(row);
                        // printArr(tenRecentTransactionLog);
                    }
                    if (col == 2) {
                        tenRecentTransactionLog[row][col] = transactionLogLastName.get(row);
                        // printArr(tenRecentTransactionLog);
                    }
                    if (col == 3) {
                        tenRecentTransactionLog[row][col] = transactionLogAmount.get(row);
                        // printArr(tenRecentTransactionLog);
                    }
                }
            }
        }
        System.out.println("Log: TransactionArr: ");
        printArr(tenRecentTransactionLog);
        System.out.println("Log: Total Transaction for this account: " + transactionLogAmount.size());
    }

    public static String[][] replaceNull(String[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == null) {
                    arr[row][col] = "";
                }
            }
        }
        return arr;
    }

    public static void printArr(String[][] arr) {
        for (String[] x : arr) {
            for (String y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static String recipientExist(String username, String lastName) {
        if (Account.accExist(username)) // checks if recipient with username exists
        {
            System.out.println("Log: Found Recipient");
            if (Account.arrayListIndex(Account.getUsernameList(), username) == Account
                    .arrayListIndex(Account.getLastNameList(), lastName)) // correct Last name
            {
                System.out.println("Log: Correct Recipient Last Name");
                return "Recipient Exist";
            }
            System.out.println("Log: Incorrect Recipient Last Name");
            return "Incorrect Name";
        }
        System.out.println("Log: No recipient Found");
        return "Cannot Find Recipient";
    }

    public String toSend(double toSend, CheckingAccount recipient) {
        if (toSend < 0) {
            return "Cannot Send Negative Amount";
        }
        balance = Account.twoDecimalPlace(balance - toSend); // subtracts from sender balance
        recipient.setBalance(recipient.getBalance() + toSend); // add to recipient Account (set recipi to current +
                                                               // toSend)
        System.out.println("Log: Sent to: " + recipient.getAccountUsername() + " - $" + toSend);
        return "Sent";
    }

    public String[][] sortByTime(String[][] arr) {
        String[][] copy = arr;
        String[] time;
        if (transactionLogAmount.size() < 10) {
            time = new String[transactionLogAmount.size()];
        } else {
            time = new String[10];
        }
        for (int row = 0; row < copy.length && row < time.length; row++) {
            time[row] = copy[row][3];
        }
        for (int i = 0; i < time.length - 1; i++) {
            int minIndex = i;
            for (int y = i + 1; y < time.length; y++) {
                if (time[y].compareToIgnoreCase(time[minIndex]) < 0) {
                    minIndex = y;
                }
            }
            if (i != minIndex) {
                String temp = time[minIndex];
                time[minIndex] = time[i];
                time[i] = temp;
                copy = swapRow(copy, minIndex, i);
            }
        }
        System.out.println(Arrays.toString(copy));
        return copy;
    }

    public String[][] sortByTransactionAmountLeastToGreatest(String[][] arr) {
        String[][] copy = arr;
        String[] transactions;
        if (transactionLogAmount.size() < 10) {
            transactions = new String[transactionLogAmount.size()];
        } else {
            transactions = new String[10];
        }

        for (int row = 0; row < copy.length && row < transactions.length; row++) {
            transactions[row] = copy[row][3];
        }
        for (int i = 0; i < transactions.length - 1; i++) {
            int minIndex = i;
            for (int y = i + 1; y < transactions.length; y++) {
                if (Double.parseDouble(transactions[y]) < Double.parseDouble(transactions[minIndex])) {
                    minIndex = y;
                }
            }
            if (i != minIndex) {
                String temp = transactions[minIndex];
                transactions[minIndex] = transactions[i];
                transactions[i] = temp;
                copy = swapRow(copy, minIndex, i);
            }
        }
        System.out.println(Arrays.toString(copy));
        return copy;
    }

    public String[][] sortByTransactionAmountGreatestToLeast(String[][] arr) {
        String[][] copy = arr;
        String[] transactions;
        int count = 0;
        if (transactionLogAmount.size() < 10) {
            transactions = new String[transactionLogAmount.size()];
        } else {
            transactions = new String[10];
        }

        for (int row = 0; row < copy.length && row < transactions.length; row++) {
            transactions[row] = copy[row][3];
        }
        for (int i = 0; i < transactions.length - 1; i++) {
            int minIndex = i;
            for (int y = i + 1; y < transactions.length; y++) {
                if (Double.parseDouble(transactions[y]) > Double.parseDouble(transactions[minIndex])) {
                    minIndex = y;
                }
            }
            if (i != minIndex) {
                String temp = transactions[minIndex];
                transactions[minIndex] = transactions[i];
                transactions[i] = temp;
                count++;
                copy = swapRow(copy, minIndex, i);
            }
        }
        System.out.println(Arrays.toString(copy));
        System.out.println("Log: " + count);
        return copy;
    }

    private String[][] swapRow(String[][] arr, int row1, int row2) // swaps row1 and row2
    {
        String[][] copy = arr;
        String[] temp = new String[copy[0].length];
        for (int x = 0; x < temp.length; x++) // puts values from row1 in temp
        {
            temp[x] = copy[row1][x];
        }
        for (int x = 0; x < temp.length; x++) // sets values from row2 into row1
        {
            copy[row1][x] = copy[row2][x];
        }
        for (int x = 0; x < temp.length; x++) // puts values from temp into row 2
        {
            copy[row2][x] = temp[x];
        }
        System.out.println("Swapped");
        return copy;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double set) {
        balance = set;
    }

    public String getAccountUsername() {
        return accountUsername;
    }

    public String[][] getTenRecentTransactionLog() {
        return tenRecentTransactionLog;
    }

    public void setTenRecentTransactionLog(String[][] arr) {
        tenRecentTransactionLog = arr;
    }

    public void setUsername(String newUsername) {
        accountUsername = newUsername;
    }

    public static ArrayList<CheckingAccount> getAllCheckingAccounts() {
        return allCheckingAccounts;
    }

    public String toString() {
        return "Reg Checking: - Username: " + accountUsername + " - Balance: " + Double.toString(balance);
    }

    public boolean equals(CheckingAccount acc) {
        return ((accountUsername == acc.accountUsername) && (balance == acc.balance));
    }
}