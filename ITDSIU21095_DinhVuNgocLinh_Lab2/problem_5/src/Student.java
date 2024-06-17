import java.util.Arrays;
import java.util.Comparator;

public class Student
{
    private String fname, lname;
    private int grade;

    public Student(String fname, String lname, int grade)
    {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getGrade() {
        return grade;
    }

    public String toString()
    {
        return fname + " " + lname + "\t" + grade;
    }

    public static void sortByFname(Student[] students) {
        // using insertion sort
        for (int out = 1 ;out<students.length; out++){
            Student temp = students[out];
            int in = out;
            while (in>0 && students[in -1 ].getFname().compareTo(temp.getFname())>0){
                students[in] = students[in -1];
                in--;
            }
            students[in] = temp;
        }
    }

    public static void sortByLname(Student[] students) {
        //using selection sort
        for (int out = 0; out< students.length - 1; out++){
            int min =out;
            for (int in =out+1; in< students.length; in++){
                if (students[min].getLname().compareTo(students[in].getLname())>0) {
                    min = in;
                }
            }
            Student temp = students[out];
            students[out] = students[min];
            students[min] = temp;
        }
    }

    public static void sortByGrade(Student[] students) {
        //using bubble sort
        for (int out = students.length - 1; out >= 1; out--){
            for (int in =0; in < out; in++){
                if (students[in].getGrade() > students[in + 1].getGrade()){
                    Student temp = students[in];
                    students[in] = students[in + 1];
                    students[in + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Student[] students = new Student[10];
        students[0] = new Student("Amy","Dinh Vu",87);
        students[1] = new Student("Binh","Le",99);
        students[2] = new Student("Lan","Nguyen",67);
        students[3] = new Student("My","Le Thi",82);
        students[4] = new Student("Hang","Dinh Thi",54);
        students[5] = new Student("Bich","Trinh",75);
        students[6] = new Student("Truc","Doan",26);
        students[7] = new Student("Nguyet","Vu",68);
        students[8] = new Student("Chi","Hoang",43);
        students[9] = new Student("Thang","Tran",83);

        sortByFname(students);
        System.out.println("Sorted by first name:");
        for (Student s : students) {
            System.out.println(s.toString());
        }

        sortByLname(students);
        System.out.println("\nSorted by last name:");
        for (Student s : students) {
            System.out.println(s.toString());
        }

        sortByGrade(students);
        System.out.println("\nSorted by grade:");
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }
}
