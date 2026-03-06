
public class CheckingAccount extends Account{

    private double credit;

    public CheckingAccount(){

        this(0, "" , 0);
    }
    public CheckingAccount(double balance, String name, double credit){

        super(balance, name);
        this.credit = credit;

    }

    public void setCredit(double credit){

        if ( credit > 0 ){

            this.credit = credit;

        }else {

            System.out.println("Input number must be a positive integer.");

        }


    }

    public double getCredit(){

        return this.credit;

    }

    @Override
    public void withdraw(double a) throws WithdrawException{

       if ( a > 0 ){

            if ( this.balance - a > 0 ){

                this.balance -= a;
                System.out.println(a + " baht is withdrawn from " + this.name + " and your credit balance is " + this.credit + ".");

            }else if ( this.balance - a < 0 && ((this.balance - a) + this.credit >= 0) ){
                
                double diff = a - this.balance;
                this.balance = 0;
                this.credit -= diff ;
                System.out.println(a + " baht is withdrawn from " + this.name + " and your credit balance is " + this.credit + ".");

            }else{
                
//                System.out.println("Not enough money!");
                throw new WithdrawException("Account " + this.getName() + " has not enough money.");

            }

       }else {

           System.out.println("Input number must be a positive integer.");

       }

    }

    public void withdraw(String a) throws WithdrawException{

        double s = Double.parseDouble(a);
        this.withdraw(s);

    }

    @Override
    public String toString(){

        return "The " + this.name + " account has " + this.balance + " baht and " + this.credit +" credits.";

    }


}

