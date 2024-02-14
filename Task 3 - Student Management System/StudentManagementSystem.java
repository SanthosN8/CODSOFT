import java.io.IOException;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        StudentManagement sm = new StudentManagement("student_information.ser");

        while (true) {
            System.out.println("1: Add a Student");
            System.out.println("2: View Student Details");
            System.out.println("3: Find Student Details");
            System.out.println("4: Remove Student Details");
            System.out.print("Enter Your Choice: ");
            int choice = obj.nextInt();
            obj.nextLine();


            switch (choice) {
                case 1:
                    //store the name
                    System.out.println("Enter Your Name: ");
                    String name = obj.nextLine();
                    //store roll no
                    System.out.println("Enter the Roll No: ");
                    String rollNo = obj.nextLine();
                    //store the age
                    System.out.println("Enter Your Age: ");
                    String age = obj.nextLine();
                    //store result
                    System.out.println("Enter Your Result: ");
                    String grade = obj.nextLine();
                    sm.addStudent(new Student(rollNo, name, age, grade));
                    try {
                        sm.saveDataFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    //sm.saveToFile();
                    break;


                case 2:
                    sm.ViewAllStudentsDetails();
                   // sm.toString();
                    break;

                case 3:
                    //find student
                    System.out.println("Enter Student RollNo to serach: ");
                    if(obj.hasNext()) {
                        String rollNumber = obj.nextLine();
                        System.out.println(sm.findStudent(rollNumber));
                    }
                    break;

                case 4:
                    //remove student
                    System.out.println("Enter Student RollNo to remove:");
                    String rollNumber1 = obj.nextLine();
                    sm.removeStudent(rollNumber1);

                    break;





            }
        }

    }
}
