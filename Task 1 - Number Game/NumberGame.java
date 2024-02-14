
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args){
        int randomNumber = (int)(Math.random()*100);
        //System.out.println(randomNumber);

        //create obj for Scanner input
        Scanner obj = new Scanner(System.in);

        int maxAttempts = 3;
        boolean play = true;

        while (play) {
            boolean correct = false;
            int attempts=1;
            int score = 0;

            //game repeated 3 times
            while (attempts <= maxAttempts && !correct) {
                //user input
                System.out.println("Find out the Number : ");
                int userInput = obj.nextInt();

                if (userInput == randomNumber) {
                    System.out.println("Congratulations, You are correct.....");
                    System.out.println("Number is: " + randomNumber);
                    correct = true;
                    //assign score
                    score = maxAttempts - attempts +1;


                } else if (randomNumber < userInput) {
                    System.out.println("Your input number is greater than Random number.....");
                } else {
                    System.out.println("Your input number is less than Random Number.....");
                }
              ++attempts;

            }
            if (!correct) {
                System.out.println("Your chance is over......");
                play = false;
            } else {
                System.out.println("Your score is: " + score);
                play = false;
            }


            //if you play again
            System.out.println("Do you want to play again? (y/n)");
            char choice = Character.toLowerCase(obj.next().charAt(0));
            play = (choice=='y');
        }
     }
}

