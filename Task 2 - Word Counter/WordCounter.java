import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

            System.out.println("1: to input text");
            System.out.println("2: to input file");
            System.out.println("Enter Your choice: ");
            int count = 0;
            int choice = input.nextInt();
            String word=null;

            if (choice == 1){
                System.out.println("Enter Your word: ");
                input.nextLine();
                word = input.nextLine();
            } else if (choice ==2) {
                System.out.println("Enter your file path: ");
                input.nextLine();
                String filePath = input.nextLine();
                File file = new File(filePath);

                //check whether file exists or not
                if (!file.exists()) {
                    throw new FileNotFoundException("File not found: " + filePath);
                }

                try {
                    input = new Scanner(file);
                    word = input.useDelimiter("\\A").next();
                } catch (FileNotFoundException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                    return;
                }


            }

        count = countWords(word);
            System.out.println(count);


    }

    public static int countWords(String words){
        String[] text = words.split("[\\s.,!?;:]+");
        int counter = text.length;
        return counter;
    }
}
