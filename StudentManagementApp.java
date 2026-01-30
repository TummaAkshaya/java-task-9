import java.util.*;

public class StudentManagementApp {

    public static void main(String[] args) {

        // Step 1: Store students in ArrayList
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "Akshay", 20, 85.5));
        students.add(new Student(102, "Rahul", 21, 78.0));
        students.add(new Student(103, "Sneha", 19, 92.3));
        students.add(new Student(101, "Akshay", 20, 85.5)); // Duplicate

        // Step 2: Remove duplicates using Set
        Set<Student> uniqueStudents = new HashSet<>(students);
        students = new ArrayList<>(uniqueStudents);

        // Step 3: Store in HashMap for fast lookup
        HashMap<Integer, Student> studentMap = new HashMap<>();
        for (Student s : students) {
            studentMap.put(s.id, s);
        }

        // Step 4: Sort students using Comparator (by marks)
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.marks, s1.marks); // Descending
            }
        });

        // Step 5: Print formatted report
        System.out.println("------ STUDENT REPORT ------");
        System.out.printf("%-5s %-10s %-5s %-6s\n", "ID", "Name", "Age", "Marks");
        System.out.println("--------------------------------");

        for (Student s : students) {
            System.out.printf("%-5d %-10s %-5d %-6.2f\n",
                    s.id, s.name, s.age, s.marks);
        }

        // Step 6: Fast lookup demo
        System.out.println("\nSearching student with ID 102:");
        Student found = studentMap.get(102);
        System.out.println(found.name + " | Marks: " + found.marks);
    }
}
