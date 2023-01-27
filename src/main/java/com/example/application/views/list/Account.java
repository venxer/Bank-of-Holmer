package com.example.application.views.list;
import java.util.*;

public class Account 
{
    private String firstName;
    private String lastName;    
    private String username;
    private String password;
    private static ArrayList<String> firstNameList = new ArrayList<>();
    private static ArrayList<String> lastNameList = new ArrayList<>();
    private static ArrayList<String> usernameList = new ArrayList<>();
    private static ArrayList<String> passwordList = new ArrayList<>();
    
    public Account(String firstName, String lastName, String username, String password)
    {
        this.firstName = firstName;
            boolean resultAdd = firstNameList.add(firstName);
        this.lastName = lastName;
            lastNameList.add(lastName);
        this.username = username;
            usernameList.add(username);
        this.password = password;
            passwordList.add(password);
        System.out.println("Log: firstName - " + firstName);
        System.out.println("Log: lastName - " + lastName);
        System.out.println("Log: username - " + username);
        System.out.println("Log: password - " + password);
        System.out.println("Log: Account added status: " + resultAdd);
    }

    public static boolean accExist(String username) //true if exist
    {
        return arrayListIndex(usernameList, username) != -1;
    }
    
    public static int arrayListIndex(ArrayList<String> arr, String target)
    {
        for(int x = 0; x < arr.size(); x++)
        {
            if(arr.get(x).equals(target))
            {
                return x;
            }
        }
        return -1;
    }

    public static boolean correctLogin(String username, String password) //checks if login info is correct
    {
        int usernameIndex = arrayListIndex(usernameList, username);
        if(usernameIndex == -1)
        {
            return false;
        }
        return (passwordList.get(usernameIndex).equals(password));
    }

    public static String welcomeUser(String username)
    {
        return "Welcome " + firstNameList.get(arrayListIndex(usernameList, username));
    } 

    public static double twoDecimalPlace(double num)
    {
        return Math.round(num*100)/100;
    }

    public static ArrayList<String> getFirstNameList()
    {
        return firstNameList;
    }

    public static ArrayList<String> getLastNameList()
    {
        return lastNameList;
    }

    public static ArrayList<String> getUsernameList()
    {
        return usernameList;
    }

    public static ArrayList<String> getPasswordList()
    {
        return passwordList;
    }

    public static void setPassword(int pos, String newPass)
    {
        passwordList.set(pos, newPass);
    }
    
    public String getfirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getUsername()
    {
        return username;
    }

    public static String setUsernameList(int pos, String newUsername)
    {
        return usernameList.set(pos, newUsername);
    }
}