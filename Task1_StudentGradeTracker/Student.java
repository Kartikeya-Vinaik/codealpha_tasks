import java.util.ArrayList;

public class Student {

    private String name;
    private String id;
    private ArrayList<Double> grades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {

        if (grades.isEmpty()) return 0;

        double sum = 0;

        for (double g : grades) {
            sum += g;
        }

        return sum / grades.size();
    }

    public double getHighest() {

        if (grades.isEmpty()) return 0;

        double highest = grades.get(0);

        for (double g : grades) {

            if (g > highest) {
                highest = g;
            }
        }

        return highest;
    }

    public double getLowest() {

        if (grades.isEmpty()) return 0;

        double lowest = grades.get(0);

        for (double g : grades) {

            if (g < lowest) {
                lowest = g;
            }
        }

        return lowest;
    }

    public int getGradeCount() {
        return grades.size();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    @Override
    public String toString() {

        return String.format(
                "ID: %-10s | Name: %-20s | Avg: %.2f | High: %.2f | Low: %.2f",
                id, name, calculateAverage(), getHighest(), getLowest()
        );
    }
}