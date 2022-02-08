package com.company;

import java.util.Objects;

//Modificadores de acceso -> Encapsulamiento
class Student {
    private String name;
    private String lastName;
    private String code;

    //Constructores
    Student(String name, String lastName, String code) {
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCode() {
        return code;
    }
}

class Group {
    private String code; //null
    private Student[] students; //null
    private int enrolled; //0
    private int rejected;

    Group(String code, int capacity) {
        this.code = code;
        students = new Student[capacity];
    }

    public String getCode(){
        return code;
    }

    public boolean addStudents(Student student) {
        if(enrolled < students.length) {
            students[enrolled] = student; //hortogonalidad -> poner instrucciones en la misma linea
            enrolled++;
            return true;
        }
        rejected++;
        return false;
    }

    public void removeStudent(String code) {
        for(int i = 0; i < enrolled; i++) {
            if(students[i].getCode().equals(code)) {
                students[i] = students[i+1];
                enrolled--;
            }
        }
    }

    public int getEnrolled() {
        return enrolled;
    }

    public int getRejected() {
        return rejected;
    }

    public Student getStudent(int index) {
        return students[index];
    }
}

public class Main {

    public static void main(String[] args) {
        //Debugear = Detener la ejecución del programa en un punto en particular; breakpoint
        //IDE = Integrated Development Environment

        Student student; //Referencia a un alumno

        student = new Student("Ivan", "Uresti","972196"); //Creando un objeto alumno
        Student student2 = new Student("Jose", "Gonzalez", "456789");

        Group group = new Group("230401", 8);
        Group group2 = new Group("230402", 6);

        if(!group.addStudents(student)) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group.addStudents(student2)) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group.addStudents(new Student("Jorge", "Acosta", "1"))) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group.addStudents(new Student("Arturo", "Aleman", "2"))) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group.addStudents(new Student("Angel", "Antonio", "3"))) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group.addStudents(new Student("Francisco", "Arreguin", "4"))) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group2.addStudents(new Student("Misael", "Cabrera", "5"))) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group2.addStudents(new Student("Roberto", "Cisneros", "6"))) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group.addStudents(new Student("Juan", "Coronado", "7"))) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group.addStudents(new Student("Jose", "Gonzalez", "8"))) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group.addStudents(new Student("Jesus", "Lara", "9"))) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        if(!group.addStudents(new Student("Jose", "Luna", "10"))) {
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }

        System.out.println("Grupo: " + group.getCode() + ", inscritos: "+ group.getEnrolled() + " rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        group.removeStudent("4");
        group2.removeStudent("6");
        group2.removeStudent("12");

        System.out.println("Grupo: " + group.getCode() + ", inscritos: "+ group.getEnrolled() + " rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        System.out.println();
        System.out.println("Alumnos del grupo: " + group.getCode());

        for(int i = 0; i < group.getEnrolled(); i++) {
            student = group.getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }

        System.out.println();
        System.out.println("Alumnos del grupo: " + group2.getCode());

        for(int i = 0; i < group2.getEnrolled(); i++) {
            student = group2.getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }
    }
}

