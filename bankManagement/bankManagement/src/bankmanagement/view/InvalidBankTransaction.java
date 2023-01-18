
package bankmanagement.view;

public class InvalidBankTransaction extends Exception {

    String erroMessage;

    //constructor
    public InvalidBankTransaction(String erro) {
        this.erroMessage = erro;
    }
   
    //method
    public String getErro() {
        return erroMessage;
    }
}