import java.io.*;
import java.util.*;

/* 672115009 Chidnucha Pobkeeree
 * Tutorial2 Student Data
 */

public class StudentDataProcessor {

    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("/Users/lilaumkubp/Documents/ADT Lab/953102_701000-2.csv");
        Scanner fileScanner = new Scanner(inputFile);

        for (int i = 0; i < 7; i++) {
            fileScanner.nextLine();
        }

        Vector<Student> studentList = new Vector<Student>();
        int studentCount = 0;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line.trim(), ",");
            tokenizer.nextToken();  
            String firstName = tokenizer.nextToken();
            String lastName = tokenizer.nextToken();
            String id = tokenizer.nextToken();

            studentList.addElement(new Student(id, firstName, lastName));
            studentCount++;
        }

        for (Student student : studentList) {
            System.out.println(student.toString());
        }

        System.out.println();

        displayStudentSummary(studentCount, studentList);
    }

    private static int countByFirstLetter(Vector<Student> studentLists, char letter) {
        int count = 0;
        for (int i = 0; i < studentLists.size(); i++) {
            if ((studentLists.elementAt(i)).getFirstName().toLowerCase().charAt(0) == (letter)) {
                count++;
            }
        }
        return count;
    }

    private static void printNamesByFirstLetter(Vector<Student> studentLists, char letter) {
        for (int i = 0; i < studentLists.size(); i++) {
            if ((studentLists.elementAt(i)).getFirstName().toLowerCase().charAt(0) == (letter)) {
                System.out.println(studentLists.elementAt(i));
            }
        }
    }

    private static void displayStudentSummary(int totalStudents, Vector<Student> stuList) {
        System.out.println("Total number of students: " + totalStudents);
        
        for (char letter = 'a'; letter <= 'z'; letter++) {
            int count = countByFirstLetter(stuList, letter);
            if (count > 0) {  
                System.out.println("Number of students whose names start with '" + letter + "': " + count);
                System.out.println("Here are the student's names starting with letter: " + letter);
                printNamesByFirstLetter(stuList, letter);
                System.out.println();
            }
        }
    }
}

class Student {
    private String studentId;
    private String firstName;
    private String lastName;

    public Student(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return this.studentId + " " + this.firstName + " " + this.lastName;
    }
}
