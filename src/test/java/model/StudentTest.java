package model;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by maria on 10-May-17.
 */
public class StudentTest {
    private Student student;

    @org.junit.Before
    public void setUp() throws Exception {
        student = new Student();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testGetRegNumber() throws Exception {

    }

    @org.junit.Test
    public void testSetRegNumber() throws Exception {

    }

    @org.junit.Test
    public void testGetName() throws Exception {


    }

    @org.junit.Test
    public void testSetName() throws Exception {
        student.setName("Ana");
        assertEquals("Eroare in setName","Ana",student.getName());
        student.setName("90Ana");
        assertEquals("Eroare in setName","90Ana",student.getName());

    }

    @org.junit.Test
    public void testGetGroup() throws Exception {

    }

    @org.junit.Test
    public void testSetGroup() throws Exception {
        student.setGroup(741);
        assertEquals("Eroare in setGroup",741,student.getGroup());
        student.setGroup(-1);
        assertEquals("Eroare in setGroup",-1,student.getGroup());
        student.setGroup(-1);
        assertEquals("Eroare in setGroup",-1,student.getGroup());
    }

    @org.junit.Test
    public void testEquals() throws Exception {

    }
}