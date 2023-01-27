package com.example.application.views.list;

public class HighSchoolCheckingAccount extends CheckingAccount
{
    private int limit = 100;
    private int[] sort = {2, 3, 5, 8, 1, 7, 4, 0};

    public HighSchoolCheckingAccount(double balance, Account acc)
    {
        super(balance, acc);
        insertionSort(sort);
        selectionSort(sort);
    }
    public HighSchoolCheckingAccount()
    {
        System.out.println("Log: Nothing in this HighSchool Checking Account");
    }
    
    public String toSend(double toSend, CheckingAccount recipient)
    {
        if(toSend < 0)
        {
            return "Cannot Send Negative Amount";
        }
        if(toSend <= limit)
        {
            super.setBalance(Account.twoDecimalPlace(super.getBalance() - toSend));
            recipient.setBalance(recipient.getBalance() + toSend); //add to recipient Account (set recipi to current + toSend)
            System.out.println("Log: Sent to: " + recipient.getAccountUsername() + " - $" + toSend);
            return "Sent";
        }
        else
        {
            return "Cannot Send Above Limit";
        }
    }

    public String toString()
    {
        return "HS Checking: - Username: " + super.getAccountUsername() + " - Balance: " + Double.toString(super.getBalance());
    }

    public static void insertionSort(int[] arr)
    {
        int count = 0;
        for(int i = 1; i < arr.length; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Ins Count: " + count);
    }

    public static void selectionSort(int[] arr)
    {
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            if(i != minIndex)
            {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println("Sel Count: " + count);
    }
}                   
