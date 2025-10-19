package StudentAttendance;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

   
        studentList.add(new Student(1, "Vinay", "Math", 85.0, 91));
        studentList.add(new Student(2, "Ghanshyam", "Physics", 55.0, 82));    // Below 60
        studentList.add(new Student(3, "Rohit", "Chemistry", 92.0, 88));
        studentList.add(new Student(4, "Suyash", "Math", 78.0, 76));
        studentList.add(new Student(5, "Ganesh", "Physics", 60.0, 65));
        studentList.add(new Student(6, "Pandey", "Chemistry", 45.0, 70)); // Below 60
        studentList.add(new Student(7, "Aditya", "Math", 88.5, 83));
        studentList.add(new Student(8, "Nimitesh", "Physics", 91.0, 95));
        studentList.add(new Student(9, "Amol", "Chemistry", 66.0, 68));
        studentList.add(new Student(10, "Saurav", "Math", 58.0, 72));     // Below 60

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            for (Student s : studentList) {
                oos.writeObject(s);
            }
            System.out.println("Student objects serialized to students.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        TreeSet<Student> sortedStudents = new TreeSet<>(studentList);

        for (Student s : sortedStudents) {
            System.out.println(s);
            try {
                String grade = s.calculateGrade();
                System.out.println("Grade: " + grade);
            } catch (LowAttendance e) {
                System.out.println("Grade: Not applicable. " + e.getMessage());
            }
            System.out.println();
        }
    }
}
