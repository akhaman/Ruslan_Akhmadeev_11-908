public class Student {
    private String name;
    private int age;
    private int course;

    public Student(String name, int age, int course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getCourse() {
        return this.course;
    }

    @Override
    public String toString() {
        return String.format("[%s, age: %d, course: %d]", name, age, course);
    }
}
