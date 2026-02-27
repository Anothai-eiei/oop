public class Bank {
    
    private Account[] acct;
    private int numAcct;
    
    public Bank(){
        this.acct = new Account[10];
    }
    public void addAccount(Account ac){
        this.acct[this.getNumAccount()] = ac;
        this.numAcct++;
    }    
    public int getNumAccount() {
        return this.numAcct;
    }
    public Account getAccount(int index) {
        return this.acct[index];
    }
}