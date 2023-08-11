package Task4; 
import java.util.Scanner;
class Balance {
	public  void displayBalance(double currentBalance)
    {
        System.out.println("Avaliable Balance : " + currentBalance);
        System.out.println();
    }
}//End of Balance class

class Checkpin {
	 public boolean pinverification(int pinNumber) {
		 return switch(pinNumber) {
		 case 1111:yield true;
		 case 2222:yield true;
		 case 3333:yield true;
		 case 4444:yield true;
		 case 5555:yield true;
		 case 6666:yield true;
		 case 7777:yield true;
		 case 8888:yield true;
		 case 9999:yield true;
		 default: yield false;
		 };
	 }
	}//end of Checkpin class

 class Deposit {
	public void process(long amount, double currentBalance) {
		System.out.println("Withdrawn Operation:");
        System.out.println("Withdrawing Amount : "
                           + amount);
        currentBalance=currentBalance+amount;
       new Balance().displayBalance(currentBalance);
        
       System.out.println("Your Money has been successfully deposited");
	}
}//end of Deposit Class\

 class Withdraw {
	public  void process(long amount,double currentBalance) {
		if(currentBalance > amount) {
			currentBalance=currentBalance-amount;
			
			System.out.println("Please collect your money and collect the card");
		new Balance().displayBalance(currentBalance);
		}else {
			System.out.println("Insuffcient funds...");
		}
	}

}//end of Withdraw class

public class ATMInterface {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double currentBalance=20000;
		 int count=0;//to store no of incorrect pin attempts 
		 
		 loopbreak: //name for breaking the loop
		 while(true) {
			 System.out.println("Enter the pinNo:");
			 int pinNo = s.nextInt();
			 if(pinNo>=1111 && pinNo<=9999) {
				 Checkpin cpn = new Checkpin();
				 boolean k = cpn.pinverification(pinNo);
				 if(k) {
					 System.out.println("****Choice****");
					 System.out.println("\t1.WithDraw"+ "\n\t2.Deposit" +"\n\t3.Check Balance");
					 System.out.println("Enter the Choice:");
					 int choice = s.nextInt();
					 switch(choice) {
					 case 1:
						 try {
							 
							 System.out.println("Enter the Amount to WithDraw:");
							  int amountforWithdrawl = s.nextInt();
								 if(amountforWithdrawl>=100 && amountforWithdrawl%100==0) {
								 Withdraw wd = new Withdraw();
								 wd.process(amountforWithdrawl,currentBalance);// withdraw amount class  method_call

								 }else {
								System.out.println("Invalid Amount for WithDraw");
								 }
						 }
						 catch(Exception e) {
								System.out.println("Please enter valid amount ");
								
							}
						 
						 break loopbreak;//stop the loop
						 
					 case 2:
						 try {
							 System.out.println("Enter the Amount to deposit:");
							  int amountForDeposite = s.nextInt();
							 if(amountForDeposite>100 && amountForDeposite%100==0) {
							 Deposit dp = new Deposit();
							 dp.process(amountForDeposite,currentBalance);//Deposit amount method_call
							 }else {
							 System.out.println("Invalid Amount for deposit");
							 }
							 
						 }catch(Exception e){
							 System.out.println("Please enter valid amount");
						 }
						 
						 break loopbreak;//end of while loop
					 case 3:
						 new Balance().displayBalance(currentBalance);
						 break loopbreak; //end of while loop
						
					 default:
						 System.out.println("Invalid Choice...");
						 break loopbreak; //end of while loop
					 }//end of switch
				 }
				 else {
					 System.out.println("Pin does not Exists.."+"\n please check your pin befour you enter...");
					 count++;
				 }
				 
			 }else {
			 System.out.println("Invalid pinNo... "+"\n Pin number is four digit code"); 
			 count++;
			 }
			 if(count==5) {
			 System.out.println("Sorry ! Transaction blocked");
			 break;//stop the loop
			 }
		}//end of while loop
	}
}
