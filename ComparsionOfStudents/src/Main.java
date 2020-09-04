import java.util.*;

public class Main {

    static void printStudents(Queue<Student> studentQueue)  {
        while (!studentQueue.isEmpty()) {
            System.out.println(studentQueue.poll());
        }
    }

    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student("Alice", 18, 1),
                new Student("Mike", 22, 3),
                new Student("Tim", 34, 5),
                new Student("Yan", 24, 4),
                new Student("Bob", 21, 2),
                new Student("Anya", 26, 4),
                new Student("Anna", 28, 1),
                new Student("Selena", 29, 5),
                new Student("Kate", 2, 2),
                new Student("Nikolay", 21, 3),
                new Student("Вася", 36, 2),
                new Student("Коля", 16, 1));


        Queue<Student> queueComparedByName = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Queue<Student> queueComparedByAge = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        Queue<Student> queueComparedByCourse = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getCourse(), o2.getCourse());
            }
        });

        queueComparedByName.addAll(studentList);
        queueComparedByAge.addAll(studentList);
        queueComparedByCourse.addAll(studentList);

//        System.out.println("Unsorted list:");
//        printStudents(studentList);
        System.out.println();

        System.out.println("Queue compared by name:");
        printStudents(queueComparedByName);
        System.out.println();

        System.out.println("Queue compared by age:");
        printStudents(queueComparedByAge);
        System.out.println();

        System.out.println("Queue compared by course:");
        printStudents(queueComparedByCourse);


    }
}
