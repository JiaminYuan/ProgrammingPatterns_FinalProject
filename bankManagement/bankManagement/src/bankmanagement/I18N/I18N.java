package bankmanagement.I18N;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18N {

    public static void main(String[] args) {

        Locale currentLocale;
        ResourceBundle messages;
        currentLocale = new Locale("en", "US");
        //currentLocale = new Locale("fr", "FR");
        messages = ResourceBundle.getBundle("com.i18n.MessagesBundle", currentLocale);
        System.out.println(messages.getString("MainClientMenu"));
        System.out.println(messages.getString("MainAccountMenu"));
        System.out.println(messages.getString("GoBackMenu"));

        //Login
        System.out.println(messages.getString("LoginWelcome"));
        System.out.println(messages.getString("Banner"));
        System.out.println(messages.getString("User"));
        System.out.println(messages.getString("Password"));
        System.out.println(messages.getString("SuccessLogin"));
        System.out.println(messages.getString("FailLogin"));

        //SQL exception
        System.out.println(messages.getString("SQLException"));
        System.out.println(messages.getString("SQLExceptionRollback"));
        System.out.println(messages.getString("SQLExceptionClientCreation"));

        //Menu
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

        //Case1
        System.out.println(messages.getString("SelectFromFollowingAccount"));
        System.out.println(messages.getString("YourBalanceIs"));
        //Case2
        System.out.println(messages.getString("CreateANewClient"));
        //clientsModel createClient method
        System.out.println(messages.getString("EnterClientId"));
        System.out.println(messages.getString("EnterFName"));
        System.out.println(messages.getString("EnterLName"));
        System.out.println(messages.getString("EnterIden"));
        System.out.println(messages.getString("EnterAddress"));
        System.out.println(messages.getString("SuccessfulClientCreation"));
        //Case3
        System.out.println(messages.getString("CreateANewAccount"));
        System.out.println(messages.getString("SelectExistingClient"));
        //acccountsModel createAccount method
        System.out.println(messages.getString("EnterClientIdForAccount"));
        System.out.println(messages.getString("EnterAccountNumber"));
        System.out.println(messages.getString("EnterAccountType"));
        System.out.println(messages.getString("AccountTypeInvalid"));
        System.out.println(messages.getString("EnterBalance"));
        System.out.println(messages.getString("NegativeBalance"));
        System.out.println(messages.getString("SuccessfulAccountCreation"));
        // accountsModel verifyClientId() method
        System.out.println(messages.getString("AccountVerifySuccess"));
        System.out.println(messages.getString("AccountVerifyNoClient"));
        //Case4
        System.out.println(messages.getString("EnterDeposit"));
        System.out.println(messages.getString("AmountDeposit"));
        // transactionsModel verifyAccountNum() method
        System.out.println(messages.getString("TransactionVerifySuccess"));
        System.out.println(messages.getString("TransactionVerifyNoAccount"));
        // transactionsModel deposit() method
        System.out.println(messages.getString("TransactionSuccessfulDeposit"));
        System.out.println(messages.getString("TransactionTotalDepositBalance"));
        //Case5
        System.out.println(messages.getString("EnterWithdraw"));
        System.out.println(messages.getString("AmountWithdraw"));
        // transactionsModel withdraw() method
        System.out.println(messages.getString("TransactionSuccessfulWithdraw"));
        System.out.println(messages.getString("TransactionTotalWithdrawBalance"));
        //Case6
        //transactionsModel createTransaction() method
        System.out.println(messages.getString("TransactionFromAccountNumber"));
        System.out.println(messages.getString("TransactionToAccountNumber"));
        System.out.println(messages.getString("TransactionEnterId"));
        System.out.println(messages.getString("TransactionEnterDetail"));
        System.out.println(messages.getString("TransactionAmount"));
        System.out.println(messages.getString("NegativeAmount"));
        System.out.println(messages.getString("TransactionSuccessfulCreation"));
        //Case7
        System.out.println(messages.getString("ViewAccountsTable"));
        //Case8
        System.out.println(messages.getString("DeactivateAccounts"));
        // accountsModel deactivateAccount() 
         System.out.println(messages.getString("DeactivateAccountsSuccess"));
        //Case9
        System.out.println(messages.getString("SelectExistingClients"));
        System.out.println(messages.getString("ModifyClientId"));
        System.out.println(messages.getString("ModifyFirstName"));
        System.out.println(messages.getString("ModifyLastName"));
        System.out.println(messages.getString("ModifyIden"));
        System.out.println(messages.getString("ModifyAddress"));
        // clientsModel updateClientInfo() method
        System.out.println(messages.getString("ClientInfoSuccess"));
        //Case10
        System.out.println(messages.getString("Visit"));
        // accountsModel userInput()
        System.out.println(messages.getString("UserInputInvalidAmount"));
    }
}
