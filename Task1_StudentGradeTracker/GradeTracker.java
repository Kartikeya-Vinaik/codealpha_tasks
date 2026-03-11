import java.util.ArrayList;

public class GradeTracker {

    private ArrayList<Student> students;

    public GradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {

        for (Student s : students) {

            if (s.getId().equals(student.getId())) {
                System.out.println("Error: Student ID already exists.");
                return;
            }
        }

        students.add(student);
    }

    public Student findStudentById(String id) {

        for (Student s : students) {

            if (s.getId().equals(id)) {
                return s;
            }
        }

        return null;
    }

    public boolean removeStudent(String id) {

        return students.removeIf(s -> s.getId().equals(id));
    }

    public void generateReport() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n===== CLASS REPORT =====");

        double classTotal = 0;

        for (Student s : students) {

            System.out.println(s);

            classTotal += s.calculateAverage();
        }

        System.out.println("----------------------------");

        double classAvg = classTotal / students.size();

        System.out.println("Class Average: " + classAvg);
    }
}