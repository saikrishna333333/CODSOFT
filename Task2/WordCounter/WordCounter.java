package Task2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class CountOfWordsInFiles {
	 static String readFile(String filePath) throws FileNotFoundException {
	        StringBuilder content = new StringBuilder();
	        Scanner fileScanner = new Scanner(new File(filePath));

	        while (fileScanner.hasNextLine()) {
	            content.append(fileScanner.nextLine()).append(" ");
	        }

	        fileScanner.close();
	        return content.toString();
	    }

}//end of CountOfWordsInFiles class

class CountOfWordsInString {
	public static int countWordsUsingSplit(String input) {
	    if (input == null || input.isEmpty()) {
	      return 0;
	    }

	    String[] words = input.split("\\s+");
	    return words.length;
	  }

}//end of CountOfWordsInString class


public class WordCounter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose an option:");
        System.out.println("1. Enter text");
        System.out.println("2.Provide a file");

        int choice = scanner.nextInt();
        scanner.nextLine(); 
        String inputText = "";
        

        switch (choice) {
            case 1:
            		System.out.println("Enter the text:");
                    inputText = scanner.nextLine();
                    break;	
            case 2:
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                try {
                    inputText = CountOfWordsInFiles.readFile(filePath);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found. Please check the file path and try again.");
                    System.exit(1);
                }
                break;
            default:
                System.out.println("Invalid option. Please choose either 1 or 2.");
                System.exit(1);
		       
		}

        int wordCount = CountOfWordsInString.countWordsUsingSplit(inputText);
        System.out.println("Total word count: " + wordCount);
        scanner.close();
   }
}

