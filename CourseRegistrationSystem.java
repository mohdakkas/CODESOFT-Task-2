import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        initializeCourses();
        int choice;

        do {
            System.out.println("Course Registration System");
            System.out.println("1. Add Student");
            System.out.println("2. Register Course");
            System.out.println("3. Display Registered Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    registerCourse();
                    break;
                case 3:
                    displayRegisteredCourses();
                    break;
                case 4:
                    System.out.println("Thank you for using the Course Registration System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void initializeCourses() {
        courses.add(new Course("C101", "Introduction to Programming"));
        courses.add(new Course("C102", "Data Structures"));
        courses.add(new Course("C103", "Algorithms"));
        courses.add(new Course("C104", "Databases"));
        courses.add(new Course("C105", "Operating Systems"));
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        students.add(new Student(studentId, studentName));
        System.out.println("Student " + studentName + " added successfully.");
    }

    private static void registerCourse() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);

        if (student != null) {
            System.out.println("Available Courses:");
            for (Course course : courses) {
                System.out.println(course);
            }
            System.out.print("Enter Course ID to register: ");
            String courseId = scanner.nextLine();
            Course course = findCourseById(courseId);

            if (course != null) {
                student.registerCourse(course);
            } else {
                System.out.println("Invalid Course ID.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayRegisteredCourses() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);

        if (student != null) {
            student.displayRegisteredCourses();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}
