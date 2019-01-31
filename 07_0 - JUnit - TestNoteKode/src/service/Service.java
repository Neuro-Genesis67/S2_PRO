package service;

import java.util.Set;

import modelstudent.Student;
import modelstudent.Team;
import storage.Storage;

public class Service {
    private Storage storage;
    private static Service service;

    private Service() {
        storage = new Storage();
    }

    public static Service getService() {
        if (service == null) {
            service = new Service();
        }
        return service;
    }
    
    public static Service getTestService() {
        return new Service();
    }
    
    public Team createTeam(String name, String room) {
        Team t = new Team(name, room);
        storage.addTeam(t);
        return t;
    }

    public Student createStudent(String name, int age) {
        Student s = new Student(name, age);
        storage.addStudent(s);
        return s;
    }

    public void addStudentToTeam(Student s, Team t) {
        t.addStudent(s);
    }

    public void updateTeam(Team t, String name, String room) {
        t.setName(name);
        t.setRoom(room);
    }

    public Set<Team> getAllTeams() {
        return storage.getAllTeams();
    }

    public Set<Student> getAllStudents() {
        return storage.getAllStudents();
    }

}
