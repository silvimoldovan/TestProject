package validator;

import org.junit.Test;

import static org.junit.Assert.*;
import model.Laboratory;
import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by maria on 10-May-17.
 */
public class ValidatorTest {
    private List<Student> allstudents;

    Validator validator;
    Student student1;
    Student student2;
    Student student3;
    Student student4;
    Student student5;
    Student student6;
    Student student7;
    Student student8;
    Student student9;


    Laboratory laborator1;
    Laboratory laborator2;
    Laboratory laborator3;
    Laboratory laborator4;
    Laboratory laborator5;
    Laboratory laborator6;
    @Before
    public void setUp() throws Exception {
        validator=new Validator();
        allstudents=new ArrayList<>();
        student1 = new Student("gjig0013", "Gozner", "Judith", 123);
        student2 = new Student("nmig0026", "Nemes", "Mada", 763);
        allstudents.add(student1);
        allstudents.add(student2);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void validateStudent() throws Exception {

        student1 = new Student("gjig0013", "Gozner", "Judith", 731);
        student2 = new Student("nmig0026", "Nemes", "Mada", 731);
        student3 = new Student("24", "Barutia", "Monica",731);
        student4 = new Student("0021jghg", "Aurel", "Mircea Luceafarul", 731);
        student5 = new Student("nmig0026", "Dorel", "Fara-cap", 731);
        student6 = new Student("gjig0013", "009Gozner", "Judith", 731);


        assertEquals(validator.validateStudent(student1), true);
        assertEquals(validator.validateStudent(student2), true);
        assertEquals(validator.validateStudent(student3), false);
        assertEquals(validator.validateStudent(student4), false);
        assertEquals(validator.validateStudent(student5), false);
        assertEquals(validator.validateStudent(student6), false);


    }

    @Test
    public void validateLaboratory() throws Exception {
        laborator1=new Laboratory(763,"12/30/1000",-1,9,"nmig0026");
        laborator2=new Laboratory(763,"12/30/1000",0,0,"nmig0026");
        laborator3=new Laboratory(123,"-12/12/0",1,-9,"gjig0013");
        laborator4=new Laboratory(123,"12/12/2017",4,13,"gjig0013");
        laborator5 = new Laboratory(123, "12/12/2017", 4, 9, "gjig0013");




        assertEquals(validator.validateLaboratory(laborator1,allstudents),false);
        assertEquals(validator.validateLaboratory(laborator2,allstudents),false);
        assertEquals(validator.validateLaboratory(laborator4,allstudents),false);
        assertEquals(validator.validateLaboratory(laborator5,allstudents),true);




    }

    @Test
    public void validateGrade() throws Exception {
        laborator6=new Laboratory(9,"12/12/2017",6,10,"nmig0026");
        assertEquals(validator.validateGrade(10),true);
        assertEquals(validator.validateGrade(-1),false);
        assertEquals(validator.validateGrade(12),false);


    }



    @Test
    public void existNrReg() throws Exception {

        student7=new Student("lddd9923","Nemes","Cristian",345);
        student8=new Student("dfss1234","Nemes","Raul",345);
        allstudents.add(student7);
        allstudents.add(student8);
        assertEquals(validator.existNrReg("lddd9923",allstudents),true);
        assertEquals(validator.existNrReg("bmig0003",allstudents),false);




    }

}