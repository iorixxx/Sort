package edu.eskisehir;

import java.util.*;

public class OnurGozcu {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Onur", "Gözcü", 112));
        studentList.add(new Student("Eren", "Alkan", 113));
        studentList.add(new Student("Ahmet", "Arslan", 114));
        studentList.add(new Student("Ozan", "Gözcü", 115));
        studentList.add(new Student("Ömer", "Aydın", 116));

        // example of a generic method
        Collections.sort(studentList);

        // Please see source code of map, Function and Predicate
        // for far more advanced usage of Generics
        System.out.println(studentList
                .stream()
                .map(Student::getName)
                .distinct()
                .count());

        System.out.println(studentList);

        Student bannedStudent = new Student("Onur", "Gözcü", 112);

        System.out.println(bannedStudent.hashCode());

        System.out.println("İşlemden önceki eleman sayısı: " + studentList.size());

        if (studentList.contains(bannedStudent)) {
            studentList.remove(bannedStudent);
        }

        System.out.println("İşlemden sonraki eleman sayısı: " + studentList.size());

        studentList.contains(5);
        studentList.contains("ahmet");
        studentList.contains(null);

        // Omer: Ey Java! yukardakilere izin veriyorsun da neden asagidakilere izin vermiyorsun?

        // studentList.add(5);
        // studentList.add("ahmet");
        // studentList.add(null);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

    }
}

class Student implements Comparable<Student> {
    String name;
    String surname;
    int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                name.equals(student.name) &&
                surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id);
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }

    public Student(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
}