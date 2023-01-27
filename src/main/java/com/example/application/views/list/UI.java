package com.example.application.views.list;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@PageTitle("Bank Of Holmer")
@Route(value = "")
public class UI extends VerticalLayout {
    private CheckingAccount currCheckingAccount;
    private LocalDateTime time;
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:s");

    private Image logo = new Image("images/Bank-Of-Holmer.png", "main logo");
    private Image logo2 = new Image("images/Bank-Of-Holmer.png", "2nd logo");

    private Button loginButton = new Button("Login");
    private TextField loginUsernameField = new TextField("Username");
    private PasswordField loginPasswordField = new PasswordField("Password");

    private Button signUpButton = new Button("Sign Up");
    private TextField signUpFirstName = new TextField("First name");
    private TextField signUpLastName = new TextField("Last name");
    private TextField signUpUsername = new TextField("Username");
    private PasswordField signUpPasswordField = new PasswordField("Password");
    private PasswordField signUpConfirmPasswordField = new PasswordField("Confirm password");
    private FormLayout signUpForm = new FormLayout(signUpFirstName, signUpLastName, signUpUsername, signUpPasswordField,
            signUpConfirmPasswordField);
    private HorizontalLayout signUpFormAsHLayout = new HorizontalLayout(signUpForm);
    private Button backToLoginFields = new Button("Back");
    private boolean creatingAcc = false;
    private Checkbox highSchoolCheckingAccountCheckBox = new Checkbox("HighSchool Checking Account");
    private HorizontalLayout loginFields = new HorizontalLayout(loginUsernameField, loginPasswordField);
    private VerticalLayout loginSignUpButtons = new VerticalLayout(loginButton, signUpButton);

    private TextField transactionTime0 = new TextField("Time");
    private TextField transactionTime1 = new TextField();
    private TextField transactionTime2 = new TextField();
    private TextField transactionTime3 = new TextField();
    private TextField transactionTime4 = new TextField();
    private TextField transactionTime5 = new TextField();
    private TextField transactionTime6 = new TextField();
    private TextField transactionTime7 = new TextField();
    private TextField transactionTime8 = new TextField();
    private TextField transactionTime9 = new TextField();

    private TextField receiverUsername0 = new TextField("User");
    private TextField receiverUsername1 = new TextField();
    private TextField receiverUsername2 = new TextField();
    private TextField receiverUsername3 = new TextField();
    private TextField receiverUsername4 = new TextField();
    private TextField receiverUsername5 = new TextField();
    private TextField receiverUsername6 = new TextField();
    private TextField receiverUsername7 = new TextField();
    private TextField receiverUsername8 = new TextField();
    private TextField receiverUsername9 = new TextField();

    private TextField receiverLastName0 = new TextField("First Name");
    private TextField receiverLastName1 = new TextField();
    private TextField receiverLastName2 = new TextField();
    private TextField receiverLastName3 = new TextField();
    private TextField receiverLastName4 = new TextField();
    private TextField receiverLastName5 = new TextField();
    private TextField receiverLastName6 = new TextField();
    private TextField receiverLastName7 = new TextField();
    private TextField receiverLastName8 = new TextField();
    private TextField receiverLastName9 = new TextField();

    private TextField transactionAmount0 = new TextField("Amount");
    private TextField transactionAmount1 = new TextField();
    private TextField transactionAmount2 = new TextField();
    private TextField transactionAmount3 = new TextField();
    private TextField transactionAmount4 = new TextField();
    private TextField transactionAmount5 = new TextField();
    private TextField transactionAmount6 = new TextField();
    private TextField transactionAmount7 = new TextField();
    private TextField transactionAmount8 = new TextField();
    private TextField transactionAmount9 = new TextField();

    private HorizontalLayout line0TransactionLog = new HorizontalLayout(transactionTime0, receiverUsername0,
            receiverLastName0, transactionAmount0);
    private HorizontalLayout line1TransactionLog = new HorizontalLayout(transactionTime1, receiverUsername1,
            receiverLastName1, transactionAmount1);
    private HorizontalLayout line2TransactionLog = new HorizontalLayout(transactionTime2, receiverUsername2,
            receiverLastName2, transactionAmount2);
    private HorizontalLayout line3TransactionLog = new HorizontalLayout(transactionTime3, receiverUsername3,
            receiverLastName3, transactionAmount3);
    private HorizontalLayout line4TransactionLog = new HorizontalLayout(transactionTime4, receiverUsername4,
            receiverLastName4, transactionAmount4);
    private HorizontalLayout line5TransactionLog = new HorizontalLayout(transactionTime5, receiverUsername5,
            receiverLastName5, transactionAmount5);
    private HorizontalLayout line6TransactionLog = new HorizontalLayout(transactionTime6, receiverUsername6,
            receiverLastName6, transactionAmount6);
    private HorizontalLayout line7TransactionLog = new HorizontalLayout(transactionTime7, receiverUsername7,
            receiverLastName7, transactionAmount7);
    private HorizontalLayout line8TransactionLog = new HorizontalLayout(transactionTime8, receiverUsername8,
            receiverLastName8, transactionAmount8);
    private HorizontalLayout line9TransactionLog = new HorizontalLayout(transactionTime9, receiverUsername9,
            receiverLastName9, transactionAmount9);
    private VerticalLayout transactionLogs = new VerticalLayout(line0TransactionLog,
            line1TransactionLog,
            line2TransactionLog,
            line3TransactionLog,
            line4TransactionLog,
            line5TransactionLog,
            line6TransactionLog,
            line7TransactionLog,
            line8TransactionLog,
            line9TransactionLog);

    private H2 greetUser = new H2();
    private Paragraph userBalText = new Paragraph();
    private VerticalLayout userBalance = new VerticalLayout(logo2, greetUser, userBalText);

    private Dialog sendMoneyDialog = new Dialog();
    private Button sendMoneyDialogButton;
    private H2 sendMoneyDialogHeadline = new H2("Send Money");
    private Button sendMoneyDialogCancelButton = new Button("Cancel", e -> sendMoneyDialog.close());
    private Button sendMoneyDialogSendButton = new Button("Send", e -> sendMoneyDialog.close());
    private HorizontalLayout sendMoneyDialogButtons = new HorizontalLayout(sendMoneyDialogCancelButton,
            sendMoneyDialogSendButton);
    private TextField sendMoneyDialogUsernameField = new TextField("Username:");
    private TextField sendMoneyDialogLastNameField = new TextField("Last Name:");
    private TextField sendMoneyDialogAmountField = new TextField("Amount:");
    private VerticalLayout sendMoneyDialogLayout = new VerticalLayout(sendMoneyDialogHeadline,
            sendMoneyDialogUsernameField, sendMoneyDialogLastNameField, sendMoneyDialogAmountField,
            sendMoneyDialogButtons);

    private Button accountSettingsButton = new Button("Settings");
    private Button backToDash = new Button("Back");
    private HorizontalLayout sendAndSettingLayout;

    private ListBox<String> sortOrder = new ListBox<>();
    private H2 sortTransactionH2 = new H2("Sort Transaction");
    private VerticalLayout sortTransactions = new VerticalLayout(sortTransactionH2, sortOrder);

    private Dialog changePasswordDialog = new Dialog();
    private Button changePasswordDialogButton;
    private H2 changePasswordDialogHeadline = new H2("Change Password");
    private Button changePasswordDialogConfirmButton = new Button("Confirm Changes", e -> changePasswordDialog.close());
    private Button changePasswordDialogCancelButton = new Button("Cancel", e -> changePasswordDialog.close());
    private HorizontalLayout changePasswordDialogButtons = new HorizontalLayout(changePasswordDialogCancelButton,
            changePasswordDialogConfirmButton);
    private PasswordField changePasswordCurrent = new PasswordField("Current Password");
    private PasswordField changePasswordNew = new PasswordField("New Password");
    private PasswordField changePasswordConfirmNew = new PasswordField("Confirm New Password");
    private VerticalLayout changePasswordDialogLayout = new VerticalLayout(changePasswordDialogHeadline,
            changePasswordCurrent, changePasswordNew, changePasswordConfirmNew, changePasswordDialogButtons);

    private Dialog changeUsernameDialog = new Dialog();
    private Button changeUsernameDialogButton;
    private H2 changeUsernameDialogHeadline = new H2("Change Username");
    private Button changeUsernameDialogConfirmButton = new Button("Confirm Changes", e -> changeUsernameDialog.close());
    private Button changeUsernameDialogCancelButton = new Button("Cancel", e -> changeUsernameDialog.close());
    private HorizontalLayout changeUsernameDialogButtons = new HorizontalLayout(changeUsernameDialogCancelButton,
            changeUsernameDialogConfirmButton);
    private TextField changeUsernameDialogCurrent = new TextField("Current Username");
    private TextField changeUsernameDialogNew = new TextField("New Username");
    private TextField changeUsernameDialogConfirmNew = new TextField("Confirm New Username");
    private VerticalLayout changeUsernameDialogLayout = new VerticalLayout(changeUsernameDialogHeadline,
            changeUsernameDialogCurrent, changeUsernameDialogNew, changeUsernameDialogConfirmNew,
            changeUsernameDialogButtons);

    private HorizontalLayout changeButtons;

    private Button logoutButton = new Button("Logout");

    public UI() {
        String V1 = "Time: Most Recent (Default)";
        String V2 = "Amount: Least to Greatest";
        String V3 = "Amount: Greatest to Least";
        sortOrder.setItems(V1, V2, V3);
        sortOrder.setValue(V1);

        loginButton.addClickListener(click -> {
            System.out.println("Log: Login Clicked");
            if (!loginUsernameField.getValue().equals("")) // if feild is not empty
            {
                if (Account.correctLogin(loginUsernameField.getValue(), loginPasswordField.getValue())) // if correct
                                                                                                        // login
                {
                    currCheckingAccount = CheckingAccount.getCheckingAccountFromUserName(loginUsernameField.getValue());
                    System.out.println("Log: Logging in");
                    Notification.show(Account.welcomeUser(loginUsernameField.getValue()));
                    System.out.println("Log: Current Account Info: \n     " + currCheckingAccount);
                    System.out.println(Account.getUsernameList());
                    loginUsernameField.clear();
                    loginPasswordField.clear();
                    hideLoginPage();
                    showUserDash();
                    updateTransactionLog(currCheckingAccount.getTenRecentTransactionLog());
                    greetUser.setText("Hello, " + Account.getFirstNameList().get(Account
                            .arrayListIndex(Account.getUsernameList(), currCheckingAccount.getAccountUsername())));
                    userBalText
                            .setText("Current Balance: $" + Account.twoDecimalPlace(currCheckingAccount.getBalance()));
                    sortOrder.setValue(V1);
                } else // if feild incorrect
                {
                    System.out.println("Log: Incorrect Username/Password");
                    Notification.show("Incorrect Password or Username");
                }
            } else {
                System.out.println("Log: Empty Fields");
                Notification.show("Type something");
            }
        });

        signUpButton.addClickListener(click -> {
            System.out.println("Log: SignUp Clicked");
            System.out.println(CheckingAccount.getAllCheckingAccounts());
            System.out.println(Account.getUsernameList());
            System.out.println(Account.getPasswordList());
            if (creatingAcc) {
                System.out.println("Log: Creating Account");
                if (!signUpPasswordField.getValue().equals(signUpConfirmPasswordField.getValue())) {
                    System.out.println("Log: Passwords Do Not Match");
                    Notification.show("Passwords Do Not Match");
                } else {
                    System.out.println("Log: Registering Account");
                    SecurePassword pass = new SecurePassword(signUpPasswordField.getValue());
                    if (signUpFirstName.getValue().equals("") || signUpLastName.getValue().equals("")
                            || signUpUsername.getValue().equals("") || signUpPasswordField.getValue().equals("")
                            || signUpConfirmPasswordField.getValue().equals("")) {
                        Notification.show("Please Fill Out all Fields");
                    } else {
                        if (pass.isSecure())
                        // if(true)
                        {
                            System.out.println("Log: Secure Password");
                            if (!Account.accExist(signUpUsername.getValue())) // if username + pass does not exist
                            {
                                Account acc = new Account(signUpFirstName.getValue(),
                                        signUpLastName.getValue(),
                                        signUpUsername.getValue(),
                                        signUpPasswordField.getValue());
                                System.out.println("Log: Account Created");
                                if (highSchoolCheckingAccountCheckBox.getValue()) // if checked
                                {
                                    HighSchoolCheckingAccount hsCheckingAccount = new HighSchoolCheckingAccount(100,
                                            acc);
                                    HighSchoolCheckingAccount.saveCheckingAccount(hsCheckingAccount);
                                    System.out.println("Log: HighSchool Checking Account Created");
                                } else {
                                    CheckingAccount regCheckingAccount = new CheckingAccount(100, acc);
                                    CheckingAccount.saveCheckingAccount(regCheckingAccount);
                                    System.out.println("Log: Checking Account Created");
                                }
                                Notification.show("Account Created!");
                                signUpFirstName.clear();
                                signUpLastName.clear();
                                signUpUsername.clear();
                                signUpPasswordField.clear();
                                signUpConfirmPasswordField.clear();
                                highSchoolCheckingAccountCheckBox.setValue(false);
                                System.out.println("Log: Cleared Fields");
                            } else {
                                Notification.show("Try a New Username");
                                System.out.println("Log: Username already Exists");
                            }
                        } else {
                            for (String x : pass.status()) {
                                Notification.show(x);
                                System.out.println("Log: Password not Secure");
                            }
                        }
                    }
                }
            } else {
                hideLoginFields();
                showSignUpFields();
                signUpFirstName.clear();
                signUpLastName.clear();
                signUpUsername.clear();
                signUpPasswordField.clear();
                signUpConfirmPasswordField.clear();
            }
        });

        backToLoginFields.addClickListener(click -> {
            hideSignUpFields();
            showLoginFields();
            System.out.println("Log: Back");
        });

        logoutButton.addClickListener(click -> {
            hideUserDash();
            showLoginFields();
            showLoginPage();
            System.out.println("Log: Log Out");
        });

        sendMoneyDialogSendButton.addClickListener(click -> {
            if (sendMoneyDialogUsernameField.getValue().equals("") || sendMoneyDialogLastNameField.getValue().equals("")
                    || sendMoneyDialogAmountField.getValue().equals("")) {
                sendMoneyDialog.close();
            } else {
                String recipientExistResult = HighSchoolCheckingAccount.recipientExist(
                        sendMoneyDialogUsernameField.getValue(), sendMoneyDialogLastNameField.getValue());
                if (recipientExistResult.equals("Recipient Exist")) {
                    double amount = Double.parseDouble(sendMoneyDialogAmountField.getValue());
                    if (amount < currCheckingAccount.getBalance()) {
                        int usernameIndex = Account.arrayListIndex(Account.getUsernameList(),
                                sendMoneyDialogUsernameField.getValue());
                        String toSendResult = currCheckingAccount.toSend(amount,
                                CheckingAccount.getAllCheckingAccounts().get(usernameIndex));
                        if (toSendResult.equals("Cannot Send Above Limit")) {
                            System.out.print("Log: Cannot Send Above Limit");
                            Notification.show("Cannot Send Above Limit");
                        } else if (toSendResult.equals("Cannot Send Negative Amount")) {
                            System.out.print("Log: Cannot Send Negative Amount");
                            Notification.show("Cannot Send Negative Amount");
                        } else {
                            time = LocalDateTime.now();
                            String timeAsString = dateFormat.format(time);
                            System.out.println("Log: Transaction Time: " + timeAsString);
                            userBalText.setText(
                                    "Current Balance: $" + Account.twoDecimalPlace(currCheckingAccount.getBalance()));
                            Notification.show("Sent!");
                            currCheckingAccount.logTransaction(timeAsString, sendMoneyDialogUsernameField.getValue(),
                                    sendMoneyDialogLastNameField.getValue(), amount * -1); // sender log
                            int recieverIndex = Account.arrayListIndex(Account.getUsernameList(),
                                    sendMoneyDialogUsernameField.getValue());
                            ArrayList<CheckingAccount> allCA = CheckingAccount.getAllCheckingAccounts();
                            CheckingAccount reveiverAcc = allCA.get(recieverIndex);
                            int currentIndex = Account.arrayListIndex(Account.getUsernameList(),
                                    currCheckingAccount.getAccountUsername());
                            reveiverAcc.logTransaction(timeAsString, currCheckingAccount.getAccountUsername(),
                                    Account.getLastNameList().get(currentIndex), amount); // reciver log
                            updateTransactionLog(currCheckingAccount.getTenRecentTransactionLog()); // update sender log

                        }
                    } else {
                        Notification.show("Cannot Send More Than Current Balance");

                    }
                } else {
                    System.out.println("Error");
                    Notification.show(recipientExistResult);
                }
            }
        });

        sendMoneyDialogButton = new Button("Send Money");
        sendMoneyDialogButton.addClickListener(click -> {
            sendMoneyDialog.open();
            sendMoneyDialogUsernameField.setValue("");
            sendMoneyDialogLastNameField.setValue("");
            sendMoneyDialogAmountField.setValue("");
        });
        sendMoneyDialog.add(sendMoneyDialogLayout);
        sendMoneyDialogLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        logo.setWidth("400px");
        logo2.setWidth("400px");
        add(logo);

        signUpForm.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("500px", 2));
        signUpForm.setWidth("100%");
        signUpForm.setColspan(signUpUsername, 2); // Stretch the username field over 2 columns
        add(backToLoginFields);
        backToLoginFields.setVisible(false);
        add(backToDash);
        backToDash.setVisible(false);

        add(sortTransactions);
        sortTransactions.setAlignItems(FlexComponent.Alignment.CENTER);
        sortTransactions.setVisible(false);

        accountSettingsButton.addClickListener(click -> {
            hideUserDash();
            showSettings();
        });

        backToDash.addClickListener(click -> {
            System.out.println("Log: Back");
            // CheckingAccount.printArr(currCheckingAccount.getTenRecentTransactionLog());
            // System.out.println("------");
            // String[][] temp = currCheckingAccount.getTenRecentTransactionLog();
            String[][] copy = currCheckingAccount.getTenRecentTransactionLog();
            if (sortOrder.getValue().equals(V2)) {
                System.out.println("Log: |" + sortOrder.getValue() + "| Selected");

                String[][] sortedV2 = currCheckingAccount.sortByTransactionAmountLeastToGreatest(copy);
                CheckingAccount.printArr(sortedV2);
                updateTransactionLog(sortedV2);
                System.out.println("Log: Sorted");
            } else if (sortOrder.getValue().equals(V3)) {
                System.out.println("Log: |" + sortOrder.getValue() + "| Selected");
                String[][] sortedV3 = currCheckingAccount.sortByTransactionAmountGreatestToLeast(copy);
                CheckingAccount.printArr(sortedV3);
                updateTransactionLog(sortedV3);
                System.out.println("Log: Sorted");
            } else if (sortOrder.getValue().equals(V1)) {
                System.out.println("Log: |" + sortOrder.getValue() + "| Selected");
                String[][] sortedV1 = currCheckingAccount.sortByTime(copy);
                CheckingAccount.printArr(sortedV1);
                updateTransactionLog(sortedV1);
                System.out.println("Log: Sorted");
            }
            showUserDash();
            hideSettings();
        });

        add(signUpFormAsHLayout);
        add(loginFields);
        add(highSchoolCheckingAccountCheckBox);
        add(loginSignUpButtons);
        loginSignUpButtons.setAlignItems(FlexComponent.Alignment.CENTER);
        signUpForm.setVisible(false);
        highSchoolCheckingAccountCheckBox.setVisible(false);

        add(userBalance);
        userBalance.setAlignItems(FlexComponent.Alignment.CENTER);
        userBalance.setPadding(false);
        userBalance.setSpacing(false);
        userBalance.setVisible(false);

        changePasswordDialogButton = new Button("Change Password");
        changeUsernameDialogButton = new Button("Change Username");

        changeButtons = new HorizontalLayout(changeUsernameDialogButton, changePasswordDialogButton);
        add(changeButtons);

        changeUsernameDialogButton.addClickListener(click -> {
            changeUsernameDialog.open();
            changeUsernameDialogCurrent.setValue("");
            changeUsernameDialogNew.setValue("");
            changeUsernameDialogConfirmNew.setValue("");
        });
        changeUsernameDialog.add(changeUsernameDialogLayout);
        changeUsernameDialogLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        changePasswordDialogButton.addClickListener(click -> {
            changePasswordDialog.open();
            changePasswordCurrent.setValue("");
            changePasswordNew.setValue("");
            changePasswordConfirmNew.setValue("");
        });
        changePasswordDialog.add(changePasswordDialogLayout);
        changePasswordDialogLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        changeButtons.setVisible(false);

        changeUsernameDialogConfirmButton.addClickListener(click -> {
            if (changeUsernameDialogCurrent.getValue().equals("") || changeUsernameDialogNew.getValue().equals("")
                    || changeUsernameDialogConfirmNew.getValue().equals("")) {
                changeUsernameDialog.close();
            } else {
                if (changeUsernameDialogCurrent.getValue().equals(currCheckingAccount.getAccountUsername())) // if
                                                                                                             // correct
                                                                                                             // username
                {
                    System.out.println("Log: Correct Current Username");
                    if (!Account.accExist(changeUsernameDialogNew.getValue())) // if username does not exist
                    {
                        if (changeUsernameDialogNew.getValue().equals(changeUsernameDialogConfirmNew.getValue())) {
                            System.out.println("Log: Username Match");
                            int currentIndex = Account.arrayListIndex(Account.getUsernameList(),
                                    changeUsernameDialogCurrent.getValue());
                            String replaced = Account.setUsernameList(currentIndex, changeUsernameDialogNew.getValue());
                            currCheckingAccount.setUsername(changeUsernameDialogNew.getValue());
                            Notification.show("Replaced: " + replaced);
                            changeUsernameDialog.close();
                        } else {
                            System.out.println("Log: Usernames Do Not Match");
                            Notification.show("Usernames Do Not Match");
                        }
                    } else {
                        Notification.show("Try a New Username");
                        System.out.println("Log: Username already Exists");
                    }
                } else {
                    Notification.show("Incorrect Current Username");
                }
            }
        });

        changePasswordDialogConfirmButton.addClickListener(click -> {
            if (changePasswordCurrent.getValue().equals("") || changePasswordNew.getValue().equals("")
                    || changePasswordConfirmNew.getValue().equals("")) {
                changePasswordDialog.close();
            } else {
                System.out.println("Log: Correct Current Password");
                int currentIndex = Account.arrayListIndex(Account.getUsernameList(),
                        currCheckingAccount.getAccountUsername());
                if (changePasswordCurrent.getValue().equals(Account.getPasswordList().get(currentIndex))) // if password
                                                                                                          // match
                                                                                                          // current
                {
                    if (changePasswordNew.getValue().equals(changePasswordConfirmNew.getValue())) // if new ==
                                                                                                  // confirmednew
                    {
                        SecurePassword changePass = new SecurePassword(changePasswordNew.getValue());
                        if (changePass.isSecure()) // if secure pass
                        {
                            System.out.println("Log: Secure Password");
                            Account.setPassword(currentIndex, changePasswordNew.getValue());
                            Notification.show("Successfully Changed");
                        } else {
                            for (String x : changePass.status()) {
                                Notification.show(x);
                                System.out.println("Log: Password not Secure");
                            }
                        }
                    } else {
                        System.out.println("Log: Password Do Not Match");
                        Notification.show("Password Do Not Match");
                    }
                } else {
                    System.out.println("Log: Password Does Not Match Current Password");
                    Notification.show("Password Does Not Match Current Password");
                }
            }
        });

        sendAndSettingLayout = new HorizontalLayout(sendMoneyDialogButton, accountSettingsButton);
        add(sendAndSettingLayout);
        sendMoneyDialogButton.setVisible(false);
        accountSettingsButton.setVisible(false);

        transactionTime0.setReadOnly(true);
        transactionTime1.setReadOnly(true);
        transactionTime2.setReadOnly(true);
        transactionTime3.setReadOnly(true);
        transactionTime4.setReadOnly(true);
        transactionTime5.setReadOnly(true);
        transactionTime6.setReadOnly(true);
        transactionTime7.setReadOnly(true);
        transactionTime8.setReadOnly(true);
        transactionTime9.setReadOnly(true);
        receiverUsername0.setReadOnly(true);
        receiverUsername1.setReadOnly(true);
        receiverUsername2.setReadOnly(true);
        receiverUsername3.setReadOnly(true);
        receiverUsername4.setReadOnly(true);
        receiverUsername5.setReadOnly(true);
        receiverUsername6.setReadOnly(true);
        receiverUsername7.setReadOnly(true);
        receiverUsername8.setReadOnly(true);
        receiverUsername9.setReadOnly(true);
        receiverLastName0.setReadOnly(true);
        receiverLastName1.setReadOnly(true);
        receiverLastName2.setReadOnly(true);
        receiverLastName3.setReadOnly(true);
        receiverLastName4.setReadOnly(true);
        receiverLastName5.setReadOnly(true);
        receiverLastName6.setReadOnly(true);
        receiverLastName7.setReadOnly(true);
        receiverLastName8.setReadOnly(true);
        receiverLastName9.setReadOnly(true);
        transactionAmount0.setReadOnly(true);
        transactionAmount1.setReadOnly(true);
        transactionAmount2.setReadOnly(true);
        transactionAmount3.setReadOnly(true);
        transactionAmount4.setReadOnly(true);
        transactionAmount5.setReadOnly(true);
        transactionAmount6.setReadOnly(true);
        transactionAmount7.setReadOnly(true);
        transactionAmount8.setReadOnly(true);
        transactionAmount9.setReadOnly(true);
        add(transactionLogs);
        transactionLogs.setAlignItems(FlexComponent.Alignment.CENTER);
        transactionLogs.setVisible(false);

        add(logoutButton);
        logoutButton.setVisible(false);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }

    private void hideLoginFields() {
        loginFields.setVisible(false);
        loginButton.setVisible(false);
    }

    private void showLoginFields() {
        loginFields.setVisible(true);
        loginButton.setVisible(true);
    }

    private void hideSignUpFields() {
        signUpForm.setVisible(false);
        backToLoginFields.setVisible(false);
        highSchoolCheckingAccountCheckBox.setVisible(false);
        highSchoolCheckingAccountCheckBox.setValue(false);
        creatingAcc = false;
    }

    private void showSignUpFields() {
        signUpForm.setVisible(true);
        backToLoginFields.setVisible(true);
        highSchoolCheckingAccountCheckBox.setVisible(true);
        loginUsernameField.clear();
        loginPasswordField.clear();
        creatingAcc = true;
    }

    public void hideLoginPage() {
        loginFields.setVisible(false);
        loginSignUpButtons.setVisible(false);
    }

    public void showLoginPage() {
        loginFields.setVisible(true);
        loginSignUpButtons.setVisible(true);
    }

    public void showUserDash() {
        logo.setVisible(false);
        transactionLogs.setVisible(true);
        logoutButton.setVisible(true);
        userBalance.setVisible(true);
        sendMoneyDialogButton.setVisible(true);
        accountSettingsButton.setVisible(true);
    }

    public void hideUserDash() {
        logo.setVisible(true);
        transactionLogs.setVisible(false);
        logoutButton.setVisible(false);
        userBalance.setVisible(false);
        sendMoneyDialogButton.setVisible(false);
        accountSettingsButton.setVisible(false);
    }

    public void showSettings() {
        backToDash.setVisible(true);
        sortTransactions.setVisible(true);
        changeButtons.setVisible(true);
    }

    public void hideSettings() {
        backToDash.setVisible(false);
        sortTransactions.setVisible(false);
        changeButtons.setVisible(false);
    }

    public void updateTransactionLog(String[][] arr) {
        arr = CheckingAccount.replaceNull(arr);
        for (int col = 0; col < arr[0].length; col++) {
            for (int row = 0; row < arr.length; row++) {
                if (col == 0) {
                    if (row == 0) {
                        transactionTime0.setValue(arr[row][col]);
                    }
                    if (row == 1) {
                        transactionTime1.setValue(arr[row][col]);
                    }
                    if (row == 2) {
                        transactionTime2.setValue(arr[row][col]);
                    }
                    if (row == 3) {
                        transactionTime3.setValue(arr[row][col]);
                    }
                    if (row == 4) {
                        transactionTime4.setValue(arr[row][col]);
                    }
                    if (row == 5) {
                        transactionTime5.setValue(arr[row][col]);
                    }
                    if (row == 6) {
                        transactionTime6.setValue(arr[row][col]);
                    }
                    if (row == 7) {
                        transactionTime7.setValue(arr[row][col]);
                    }
                    if (row == 8) {
                        transactionTime8.setValue(arr[row][col]);
                    }
                    if (row == 9) {
                        transactionTime9.setValue(arr[row][col]);
                    }
                }
                if (col == 1) {
                    if (row == 0) {
                        receiverUsername0.setValue(arr[row][col]);
                    }
                    if (row == 1) {
                        receiverUsername1.setValue(arr[row][col]);
                    }
                    if (row == 2) {
                        receiverUsername2.setValue(arr[row][col]);
                    }
                    if (row == 3) {
                        receiverUsername3.setValue(arr[row][col]);
                    }
                    if (row == 4) {
                        receiverUsername4.setValue(arr[row][col]);
                    }
                    if (row == 5) {
                        receiverUsername5.setValue(arr[row][col]);
                    }
                    if (row == 6) {
                        receiverUsername6.setValue(arr[row][col]);
                    }
                    if (row == 7) {
                        receiverUsername7.setValue(arr[row][col]);
                    }
                    if (row == 8) {
                        receiverUsername8.setValue(arr[row][col]);
                    }
                    if (row == 9) {
                        receiverUsername9.setValue(arr[row][col]);
                    }
                }
                if (col == 2) {
                    if (row == 0) {
                        receiverLastName0.setValue(arr[row][col]);
                    }
                    if (row == 1) {
                        receiverLastName1.setValue(arr[row][col]);
                    }
                    if (row == 2) {
                        receiverLastName2.setValue(arr[row][col]);
                    }
                    if (row == 3) {
                        receiverLastName3.setValue(arr[row][col]);
                    }
                    if (row == 4) {
                        receiverLastName4.setValue(arr[row][col]);
                    }
                    if (row == 5) {
                        receiverLastName5.setValue(arr[row][col]);
                    }
                    if (row == 6) {
                        receiverLastName6.setValue(arr[row][col]);
                    }
                    if (row == 7) {
                        receiverLastName7.setValue(arr[row][col]);
                    }
                    if (row == 8) {
                        receiverLastName8.setValue(arr[row][col]);
                    }
                    if (row == 9) {
                        receiverLastName9.setValue(arr[row][col]);
                    }
                }
                if (col == 3) {
                    if (row == 0) {
                        transactionAmount0.setValue(arr[row][col]);
                    }
                    if (row == 1) {
                        transactionAmount1.setValue(arr[row][col]);
                    }
                    if (row == 2) {
                        transactionAmount2.setValue(arr[row][col]);
                    }
                    if (row == 3) {
                        transactionAmount3.setValue(arr[row][col]);
                    }
                    if (row == 4) {
                        transactionAmount4.setValue(arr[row][col]);
                    }
                    if (row == 5) {
                        transactionAmount5.setValue(arr[row][col]);
                    }
                    if (row == 6) {
                        transactionAmount6.setValue(arr[row][col]);
                    }
                    if (row == 7) {
                        transactionAmount7.setValue(arr[row][col]);
                    }
                    if (row == 8) {
                        transactionAmount8.setValue(arr[row][col]);
                    }
                    if (row == 9) {
                        transactionAmount9.setValue(arr[row][col]);
                    }
                }
            }
        }
    }
}