package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelstudent.Student;
import modelstudent.Team;
import service.Service;

public class ServiceTest {
    Service service;

    @Before
    public void setUp() throws Exception {
        service = Service.getTestService();
    }

    @Test
    public void testCreateTeam() {
        assertEquals(0, service.getAllTeams().size());
        //act
        Team t = service.createTeam("T1", "R1");
        //assert
        assertNotNull(t);
        assertTrue(service.getAllTeams().contains(t));
        assertEquals("T1", t.getName());
        assertEquals("R1", t.getRoom());
    }

    @Test
    public void testCreateStudent() {
        assertEquals(0, service.getAllStudents().size());
        //act
        Student s = service.createStudent("N1", 20);
        //assert
        assertNotNull(s);
        assertTrue(service.getAllStudents().contains(s));
        assertEquals("N1", s.getName());
        assertEquals(20, s.getAge());
    }

    @Test
    public void testAddStudentToTeam() {
        // arrange
        Team t = service.createTeam("T1", "R1");
        Student s = service.createStudent("N1", 20);
        assertEquals(0, t.getNumberOfStudents());
        //act
        service.addStudentToTeam(s, t);
        //assert
        assertEquals(1, t.getNumberOfStudents());
        assertTrue(t.getStudents()[0].equals(s));
    }

    @Test
    public void testUpdateTeam() {
        // arrange
        Team t = service.createTeam("T1", "R1");
        //act
        t.setName("T2");
        t.setRoom("R2");
        //assert
        assertEquals("T2", t.getName());
        assertEquals("R2", t.getRoom());
    }

}
