import java.io.Serializable;

class Student implements Serializable {



    private String rollNo;
    private String name;
    private String grade;
    private String age;

    public Student(String rollNo, String name, String age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getAge(){
        return age;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}
