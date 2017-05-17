package controller;

        import org.junit.Test;

        import static org.junit.Assert.*;
        import model.Laboratory;
        import model.Student;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;

        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.util.ArrayList;
        import java.util.List;

        import static org.junit.Assert.*;

/**
 * Created by maria on 10-May-17.
 */
public class LaboratoriesControllerTest {
    private Student student;
    private Student student2;

    private LaboratoriesController controller;
    private List<Student> allstudents;
    private List<Student> stud;
    private Laboratory laboratory;
    @Before
    public void setUp() throws Exception {
        controller=new LaboratoriesController("studentfile.txt","laboratoriesfile.txt");
        student=new Student("nmig0026","Nemes","Madalina",731);
        student2 =new Student("gjig0013","Gozner","Judith",731);
        allstudents=new ArrayList<>();
        laboratory=new Laboratory(12,"12/12/2018",13,"nmig0026");

    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void saveStudent() throws Exception {
        if(controller.saveStudent(student)) {
            stud = new ArrayList<>();
            stud = controller.getallStudents();
            Student oneStudent = stud.get(stud.size() - 1);
            assertEquals(student.equals(oneStudent), true);
        } else throw new Exception("Studentul nu a putut fi salvat");

    }


    //assertTrue(controller.saveStudent(student));




    @Test
    public void saveLaboratory() throws Exception {
        if(controller.saveLaboratory(laboratory)) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("laboratoriesfile.txt"));
            String line = null;
            Laboratory labor = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(" ");
                labor = new Laboratory(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Float.parseFloat(temp[3]), temp[4]);
            }
            assertEquals(laboratory.toString(), labor.toString());
            //System.out.println(laboratory);
            //System.out.println(labor);}
            //     12 12/12/2018 13 1.0 nmig0026

        }
    }

    @Test
    public void addGrade() throws Exception {
        controller.saveStudent(student);
        controller.saveLaboratory(laboratory);
        if(controller.addGrade(laboratory.getStudentRegNumber(),Integer.toString(laboratory.getNumber()),6f)){
            BufferedReader bufferedReader=new BufferedReader(new FileReader("laboratoriesfile.txt"));
            String line=null;
            Laboratory labor=null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(" ");
                labor = new Laboratory(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Float.parseFloat(temp[3]), temp[4]);
            }
            laboratory.setGrade(6f);
            assertEquals(laboratory.toString(),labor.toString());
            System.out.println(laboratory);
            System.out.println(labor);



        }


    }

    @Test
    public void passedStudents() throws Exception {
        LaboratoriesController contr=new LaboratoriesController("newstudfile.txt","newstudfile.txt");
        contr.saveStudent(student);
        contr.saveStudent(student2);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("newstudfile.txt"));
        String line = null;
        Student student5=null;
        List<Student> passStud=new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split(" ");
            student5 = new Student(temp[0],temp[1],temp[2],Integer.parseInt(temp[3]));
        }
        // assertEquals();
        //
    }

    @Test
    public void getallStudents() throws Exception {


    }

}