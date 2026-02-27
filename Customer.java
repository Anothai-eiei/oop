import java.util.ArrayList;
public class Customer{
    private String firstName;
    private String lastName;
    private ArrayList<Account> acct;
    private int numOfAccount;
    public Customer(){
        this("", "");
        this.acct = new ArrayList();
    }
    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = new ArrayList(); 
    }
    public void addAccount(Account acct){
        this.acct.add(acct);
        this.numOfAccount++;
    }
    public int getNumOfAccount(){
        return this.acct.size();
    }
    public Account getAccount(int index){
        return this.acct.get(index);
    }
    @Override
    public String toString(){
        return "The " + this.firstName + " " + this.lastName + " has " + this.getNumOfAccount() + " Accounts.";
    }
}