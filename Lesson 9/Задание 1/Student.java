import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades); // Создаем копию списка, чтобы избежать изменения оригинала
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades); // Возвращаем копию списка, чтобы избежать изменения оригинала
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void incrementCourse() {
        course++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                ", averageGrade=" + getAverageGrade() +
                '}';
    }

 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group) &&
                Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course, grades);
    }

    public static void removePoorStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.incrementCourse();
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }


    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Alice", "A1", 1, Arrays.asList(4, 5, 4)));
        students.add(new Student("Bob", "B2", 2, Arrays.asList(2, 3, 2)));
        students.add(new Student("Charlie", "C3", 1, Arrays.asList(5, 5, 5)));
        students.add(new Student("David", "D4", 3, Arrays.asList(4, 4, 3)));
        students.add(new Student("Eve", "E5", 2, Arrays.asList(2, 2, 2)));

        System.out.println("Исходный список студентов:");
        for (Student student : students) {
            System.out.println(student);
        }

        removePoorStudents(students);
        System.out.println("\nСписок студентов после удаления неуспевающих:");
        for (Student student : students) {
            System.out.println(student);
        }

        promoteStudents(students);
        System.out.println("\nСписок студентов после перевода на следующий курс:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nСтуденты 2 курса:");
        printStudents(students, 2);
    }
}