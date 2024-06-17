package bai1_2v;

/*
 * Reading student records from a file, generating Student objects, counting and averaging
 * Suggested exercises:
 * - Use grade to determine the type of the student: excellent (> 89), ok [60,89], and failure (< 60)
 * - Define an enum type {excellent, ok, failure} and use it to print the student type
 * - Do counting and averaging within each student type (excellent, ok, and failure)
 * - Count students by using a static variable in class Student
 */
import java.util.Scanner;
import java.io.*;

public class Students {
    public static void main(String[] args) throws IOException {
        String first_name, last_name;
        int grade, total = 0, count = 0;
        double average;
        String filePath = "C:\\Users\\PC\\DSA LAB\\lab1\\bai1_2v\\students.txt";
        Scanner fileInput = new Scanner(new File(filePath));
         while (fileInput.hasNext())
         {
         first_name = fileInput.next();
         last_name = fileInput.next();
         grade = fileInput.nextInt();

         Student st = new Student(first_name, last_name, grade);

         System.out.println(st);
         total = total + grade;
         count++;
         }
        average = (double) total / count;
        System.out.println("There are " + count + " students with average grade " + average);
    }
}

//        int n = fileInput.length;
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = fileInput.nextInt();
//        }
//        for (count = 0; count < n; count++) {
//            first_name = fileInput.next();
//            last_name = fileInput.next();
//            grade = fileInput.nextInt();
//
//            Student st = new Student(first_name, last_name, grade);
//
//            System.out.println(st);
//            total = total + grade;
//        }

