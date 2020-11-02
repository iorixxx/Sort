package edu.eskisehir;

import java.util.ArrayList;
import java.util.Objects;

public class OnurGozcu {

    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Onur", "Gözcü", 112));
        studentList.add(new Student("Eren", "Alkan", 113));
        studentList.add(new Student("Ahmet", "Arslan", 114));
        studentList.add(new Student("Ozan", "Gözcü", 115));
        studentList.add(new Student("Ömer", "Aydın", 116));


       // studentList.add(5);
       // studentList.add("ahmet");
       // studentList.add(null);


        // Omer: Ey java asagidakilere izin veriyorsun da neden yukardakilere izin vermiyorsun?
        studentList.contains(5);
        studentList.contains("ahmet");
        studentList.contains(null);

        Student bannedStudent = new Student("Onur", "Gözcü", 112);

        System.out.println("İşlemden önceki eleman sayısı: " + studentList.size());

        if (studentList.contains(bannedStudent)) {
            studentList.remove(bannedStudent);
        }

        System.out.println("İşlemden sonraki eleman sayısı: " + studentList.size());

    }
}

class Student {
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

    public Student(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }
}