import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class StudentManagement {
    private List<Student> students;
    private File data;




    public StudentManagement(String filename) {
        students = new ArrayList<>();
        data = new File(filename);

        if(data.exists()) {
            try {
                readFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("File Not Found.....");
        }

    }

    //add student to the list
    public void addStudent(Student student){
        students.add(student);
        System.out.println("Add student Successfully.....");

    }

    //view all student details from the list
    public void ViewAllStudentsDetails(){

        for (Student student: students){
            System.out.println(student);
        }

    }

    //search Student
    public Student findStudent(String rollNumber){
        for(Student student : students){
            //System.out.println(student);
            if(student.getRollNo() != null && student.getRollNo().equals(rollNumber)){
                return student;
            }
        }
        return null;
    }

    //remove student
    public void removeStudent(String rollNumber){
        Student removeStudent = null;
        for(Student student : students){
            //System.out.println(student);
            if(student.getRollNo() != null && student.getRollNo().equals(rollNumber)){
                removeStudent = student;
            }
        }

        if(removeStudent != null){
            students.remove(removeStudent);
            System.out.println("Student Removed Successfully.....");
        }else{
            System.out.println("Student Not Found.....");
        }
    }

    //store students in the external file
    public void saveDataFile() throws IOException {

        FileOutputStream os = new FileOutputStream(data);
        ObjectOutputStream objout = new ObjectOutputStream(os);
        objout.writeObject(students);

    }

    //read students from external file
    @SuppressWarnings("unchecked")
    private void readFile() throws IOException, ClassNotFoundException {
        FileInputStream input = new FileInputStream(data);
        ObjectInputStream objin = new ObjectInputStream(input);
        students = (ArrayList<Student>)objin.readObject();
    }




}
