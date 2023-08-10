package Task1;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class RandomNumMatch {
	public static void main(String[] args) {
		Random random=new Random();
		int randomnum=random.nextInt(100+1);
		double NOofChoices=0;
			Scanner scanner = new Scanner(System.in);
			try(scanner;){
				while(true) {
				System.out.println("enter choice of operation");
				System.out.println("\t1.Start game\n\t2.Exit");
				try {
					int choice=scanner.nextInt();
					switch(choice) {
					case 1:
						System.out.println("Enter a number in range of 0-100");
						innerloop:
						while(true) {
							System.out.println("Enter the number");
							int userinput=scanner.nextInt();
							if(userinput<=100) {
								if(NOofChoices<=10) {
									NOofChoices++;
									if(randomnum<userinput) {
										System.out.println("Entered Value is greater");
									}
									else if(randomnum>userinput){
										System.out.println("Entered value is small");
										
									}
									else {
										System.out.println("Congratulations match found");
										//System.out.println("count value:"+NOofChoices);
										double score=(1.0/NOofChoices)*(100);
										System.out.println("Your Score is:"+score);
										NOofChoices=0;
										System.out.println("Do You want to play Again");
										System.out.println("\t1.Yes"+"\n\t2.No");
										int choice2=Integer.parseInt(scanner.next());
										switch(choice2) {
										case 1:
											break innerloop;
										case 2:
											System.out.println("Thank You!!!!");
											System.exit(0);
										}
										

									}
									
								}else {
									System.out.println("Actual Number is:"+randomnum);
									System.out.println("You ran out of choices better luck next time!!!!");
									break;
								}
								
							}else {
								System.out.println("number should be in range of 0-100");
							}
							
						}//end of inner while
						break;
					case 2: 
						System.out.println("Thank You!!!!");
						System.exit(0);
							break;
				    default: 
				    	System.out.println("please enter a valid choice");
				    	break;
						}//end of switch
					
				}//end of try
				catch(InputMismatchException ime ) {
					System.out.println("plz enter a valid input");
					continue;
					}
				catch(Exception e) {
					e.printStackTrace();
					break;
				}
				
			}//end of while
		}//end of try with resource
			catch(Exception e) {
				e.printStackTrace();
		}
			scanner.close();
			
	}

}
