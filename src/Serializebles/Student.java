package Serializebles;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    private String name;
    private int age;
    private List<String> courses;

    public Student(String name, int age, List<String> courses) {
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCourses() {
        return courses;
    }
}