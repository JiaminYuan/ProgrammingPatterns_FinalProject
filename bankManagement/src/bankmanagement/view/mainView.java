package bankmanagement.view;

import bankmanagement.model.accountsModel;
import bankmanagement.model.transactionsModel;
import bankmanagement.model.clientsModel;
import java.util.Scanner;
import bankmanagement.dbhelper.ConnectionGenerator;
import java.util.Locale;
import java.util.ResourceBundle;
import bankmanagement.I18N.I18N;

public class mainView {

    public static void main(String args[]) throws Exception {
        Locale currentLocale;
        ResourceBundle messages;
        //currentLocale = new Locale("fr", "FR");
        currentLocale = new Locale("en", "EN");
        messages = ResourceBundle.getBundle("bankmanagement.I18NProperties.MessagesBundle", currentLocale);

        System.out.println(messages.getString("MainClientMenu")); //test

        ConnectionGenerator connection = new ConnectionGenerator();
        connection.getConnection();

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        boolean stop = true;
        int option;
        boolean validate = false;
        accountsModel selectedAccount;

        // account object 
        accountsModel account = new accountsModel();
        clientsModel client = new clientsModel();
        transactionsModel transaction = new transactionsModel();

        do {
            Login log = new Login();
            flag = log.verify();

        } while (!flag);

        if (flag) {
            do {
                System.out.println("");
                System.out.println(messages.getString("OptionMenu"));
                System.out.println(messages.getString("ViewBalance"));
                System.out.println(messages.getString("CreateClient"));
                System.out.println(messages.getString("CreateAccount"));
                System.out.println(messages.getString("Deposit"));
                System.out.println(messages.getString("Withdraw"));
                System.out.println(messages.getString("Transfer"));
                System.out.println(messages.getString("ViewAccountTable"));
                System.out.println(messages.getString("DeactivateAccount"));
                System.out.println(messages.getString("ModifyClient"));
                System.out.println(messages.getString("Exit"));
                /* System.out.println("\nChoose one of the options below"
                        + "\n1- View Balance"
                        + "\n2- Create New Client"
                        + "\n3- Create New Account"
                        + "\n4- Deposit"
                        + "\n5- Withdraw"
                        + "\n6- Create New Transaction Between Accounts"
                        + "\n7- View Accounts Table"
                        + "\n8- Deactivate Account"
                        + "\n9- Modify existing client information"
                        + "\n10- Exit");*/
                option = sc.nextInt();
                accountsModel newacc = null;
                switch (option) {
                    case 1:
                        //System.out.println("Please Select From the Following Accounts:");
                        System.out.println("");
                        System.out.println(messages.getString("SelectFromFollowingAccount"));
                        account.displayAllAccounts();
                        int scAccount = sc.nextInt();
                        //System.out.println("Your Balance is: " + account.getBalance(scAccount));
                        System.out.println(messages.getString("YourBalanceIs"));
                        System.out.print(account.getBalance(scAccount));
                        break;
                    case 2:
                        //System.out.println("\nCreate A New Client:");
                        System.out.println("");
                        System.out.println(messages.getString("CreateANewClient"));
                        client.createClient(connection.getConnection());
                        break;
                    case 3:
                        //System.out.println("\nCreate A New Account:");
                        System.out.println("");
                        System.out.println(messages.getString("CreateANewAccount"));
                        //System.out.println("Select From the Existing Clients");
                        System.out.println(messages.getString("SelectExistingClient"));
                        client.displayAllClients();
                        account.createAccount(connection.getConnection());
                        break;
                    case 4: {
                        //System.out.println("\nSelect from existing accounts: ");
                        System.out.println("");
                        System.out.println(messages.getString("SelectFromFollowingAccount"));
                        account.displayAllAccounts();
                        //System.out.println("Enter Account number to Deposit: ");
                        System.out.println(messages.getString("EnterDeposit"));
                        int accNum = sc.nextInt();
                        transaction.verifyAccountNum(accNum);
                        accountsModel dAmount = new accountsModel();
                        //System.out.println("Amount to Deposit:");
                        System.out.println(messages.getString("AmountDeposit"));
                        int depamt = dAmount.userInput();
                        int newBal = account.getBalance(accNum) + depamt;
                        transaction.deposit(newBal, accNum);
                        break;
                    }
                    case 5: {
                        System.out.println("");
                        //System.out.println("\nSelect from existing accounts: ");
                        System.out.println(messages.getString("SelectFromFollowingAccount"));
                        account.displayAllAccounts();
                        //System.out.println("Enter Account number to Withdraw: ");
                        System.out.println(messages.getString("EnterWithdraw"));
                        int accNum = sc.nextInt();
                        transaction.verifyAccountNum(accNum);
                        accountsModel wAmount = new accountsModel();
                        //System.out.println("Amount to Withdraw:");
                        System.out.println(messages.getString("AmountWithdraw"));
                        int withamt = wAmount.userInput();
                        int newBal = account.getBalance(accNum) - withamt;
                        if (newBal >= 0) {
                            transaction.withdraw(newBal, accNum);
                        } else {
                            //System.out.println("Balance can't be negative");
                            System.out.println(messages.getString("NegativeBalance"));
                        }
                        break;
                    }
                    case 6:
                        System.out.println("");
                        //System.out.println("\nSelect from existing accounts: ");
                        System.out.println(messages.getString("SelectFromFollowingAccount"));
                        account.viewAccountsTable();
                        transaction.createTransaction(connection.getConnection());
                        break;
                    case 7:
                        System.out.println("");
                        //System.out.println("View Accounts Table");
                        System.out.println(messages.getString("ViewAccountsTable"));
                        account.viewAccountsTable();
                        break;
                    case 8:
                        System.out.println("");
                        //System.out.println("\nDeactivate Account");
                        System.out.println(messages.getString("DeactivateAccounts"));
                        account.deactivateAccount();
                        break;
                    case 9:
                        System.out.println("");
                        //System.out.println("\nSelect from existing clients id: ");
                        System.out.println(messages.getString("SelectExistingClients"));
                        client.displayAllClients();
                        // System.out.println("Enter Client id to modify: ");
                        System.out.println(messages.getString("ModifyClientId"));
                        int clientId = sc.nextInt();
                        account.verifyClientId(clientId);
                        //System.out.println("Enter new first name: ");
                        System.out.println(messages.getString("ModifyFirstName"));
                        String fname = sc.next();
                        // System.out.println("Enter new last name: ");
                        System.out.println(messages.getString("ModifyLastName"));

                        String lname = sc.next();
                        //System.out.println("Enter new identification: ");
                        System.out.println(messages.getString("ModifyIden"));
                        String identification = sc.next();
                        // System.out.println("Enter new address: ");
                        System.out.println(messages.getString("ModifyAddress"));
                        String address = sc.next();
                        client.updateClientInfo(fname, lname, identification, address, clientId);
                        break;
                    case 10:
                        System.out.println("");
                        //System.out.println("Thank You. Visit Again!");
                        System.out.println(messages.getString("Visit"));
                        System.exit(0);
                    default:
                        break;
                }

            } while (stop == true);

        }
    }
}
