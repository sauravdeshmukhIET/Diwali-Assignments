package StudentAttendance;
import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {
    private int rollno;
    private String sname;
    private String course;
    private double attendance_percentage;
    private int score;

    public Student() {
    }

    public Student(int rollno, String sname, String course, double attendance_percentage, int score) {
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendance_percentage = attendance_percentage;
        this.score = score;
    }

    public String calculateGrade() throws LowAttendance {
        if (attendance_percentage < 60) {
            throw new LowAttendance("Attendance below 60% for student: " + sname);
        }

        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }

    public double getAttendancePercentage() {
        return attendance_percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", sname='" + sname + '\'' +
                ", course='" + course + '\'' +
                ", attendance_percentage=" + attendance_percentage +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student other) {
 
        return Double.compare(other.attendance_percentage, this.attendance_percentage);
    }
}

