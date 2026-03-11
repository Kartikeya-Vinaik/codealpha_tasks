import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();

        boolean running = true;

        while (running) {

            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1 Add Student");
            System.out.println("2 Add Grade");
            System.out.println("3 Show Report");
            System.out.println("4 Remove Student");
            System.out.println("5 Exit");

            int choice = InputHelper.getIntInput(scanner, "Enter choice: ");
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();

                    tracker.addStudent(new Student(name, id));

                    break;

                case 2:

                    System.out.print("Enter student ID: ");
                    String sid = scanner.nextLine();

                    Student s = tracker.findStudentById(sid);

                    if (s == null) {

                        System.out.println("Student not found.");
                        break;
                    }

                    double grade = InputHelper.getDoubleInput(scanner, "Enter grade: ");

                    if (grade < 0 || grade > 100) {

                        System.out.println("Invalid grade.");
                        break;
                    }

                    s.addGrade(grade);

                    break;

                case 3:

                    tracker.generateReport();
                    break;

                case 4:

                    System.out.print("Enter ID to remove: ");
                    String rid = scanner.nextLine();

                    tracker.removeStudent(rid);

                    break;

                case 5:

                    running = false;
                    break;

                default:

                    System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }
}
