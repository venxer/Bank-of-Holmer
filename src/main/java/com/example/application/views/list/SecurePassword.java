package com.example.application.views.list;
import java.util.*;

public class SecurePassword
{  
  private String password;
  public SecurePassword(String password)
  {
    this.password = password;
  }
  public void setPassword(String newPassword)
  {
    password = newPassword;
  }
  public boolean isSecure()
  {
    return (isLongEnough() && containsUppercase() && containsLowercase() && containsDigit() && containsSpecialSymbol());
  }
  public ArrayList<String> status()
  {
    ArrayList<String> status = new ArrayList<>();
    if (isSecure())
    {
        status.add("Password is secure");
    }
    else
    {
        if (!isLongEnough()) //not long enough
        {
            status.add("password must be at least 8 characters");
        }
        if (!containsUppercase()) // not have upper
        {
            status.add("password must contain at least one uppercase letter");
        }
        if (!containsLowercase()) // not have lower
        {
            status.add("password must contain at least one lowercase letter");
        }
        if (!containsDigit()) // not have digits
        {
            status.add("password must contain at least one digit");
        }
        if (!containsSpecialSymbol()) // not have special
        {
            status.add("password must contain a special symbol: ! @ # $ % ^ & * ? .");
        }
    }
    return status;
  }
  private boolean isLongEnough()
  {
    return (password.length() >= 8);
  }
  private boolean containsUppercase()
  {
    String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    return checkString(upperCaseLetters);
  }
  private boolean containsLowercase()
  {
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    return checkString(lowerCaseLetters);
  }
  private boolean containsDigit()
  {
    String digits = "1234567890";
    return checkString(digits);
  }
  private boolean containsSpecialSymbol()
  {
    String special = "!@#$%^&*.";
    return checkString(special);
  }
  private boolean checkString(String characterString)
  {
    int total = 0;
    for (int i = 0; i < password.length(); i++)
    {
        String passwordCharacter = password.substring(i, i + 1);
        for (int p = 0; p < characterString.length(); p++)
        {
            String characterStringCharacter = characterString.substring(p, p + 1);
            if (passwordCharacter.equals(characterStringCharacter))
            {
                total++;
            }
        }
    }
    return (total > 0);
  }
}