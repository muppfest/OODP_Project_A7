import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CourseDao;
import dao.GroupDao;
import dao.MomentDao;
import dao.ProgramDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Course;
import model.Group;
import model.Moment;
import model.Program;
import model.person.Student;
import model.person.Teacher;
import view.StudentTest;

public class test {

	public static void main(String[] args) throws SQLException {
		StudentTest t = new StudentTest();
		
		/*		StudentDao d = new StudentDao();
		
		List<Student> slist = new ArrayList<Student>();
		slist = d.getAll();
		for(Student student : slist) {
			student.printStudent();
			System.out.println();
		}
		
		ProgramDao dp = new ProgramDao();
		List<Program> plist = new ArrayList<Program>();
		plist = dp.getAll();
		
		for(Program program : plist) {
			program.printProgram();
			System.out.println();
		}
		
		CourseDao dc = new CourseDao();
		List<Course> clist = new ArrayList<Course>();
		clist = dc.getAll();
		
		for(Course course : clist) {
			course.printCourse();
			System.out.println();
		}
		
		MomentDao dm = new MomentDao();
		List<Moment> mlist = new ArrayList<Moment>();
		mlist = dm.getAll();

		for(Moment moment : mlist) {
			moment.printMoment();
			System.out.println();
		}
		
		TeacherDao dt = new TeacherDao();
		List<Teacher> tlist = new ArrayList<Teacher>();
		tlist = dt.getAll();
		
		for(Teacher teacher : tlist) {
			teacher.printTeacher();
			System.out.println();
		}
		
		GroupDao dg = new GroupDao();
		List<Group> glist = new ArrayList<Group>();
		glist = dg.getAll();
		
		for(Group group : glist) {
			group.printGroup();
			System.out.println();
		} */
	} 
}
