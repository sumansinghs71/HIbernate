package advanced_mappings.com.hibernate.mappings.entity.One2One.biDirectional;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hidernate.utils.DateUtils;

public class MappingsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating Session factory
		SessionFactory sf=new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// Creating Session 
		Session session=sf.getCurrentSession();
		try {
			int theId=9;
			//begin transaction
			session.beginTransaction();
//			Instructor ins=new Instructor("sai","xxx","abc@gmail.com");
//			InstructorDetail id=new InstructorDetail("Mental Channel","timepass");
//			ins.setInstructorDetail(id);
			InstructorDetail id = session.get(InstructorDetail.class, theId);
//			session.save(ins);
			//commit transaction
			session.delete(id);
			
			//System.out.println("Save InstructorDetail " + id);
			System.out.println("Saved InstructorDetail. Instructor: " + id.getId());
			session.getTransaction().commit();
//			session.flush();
			// find out the instructor's id: primary key
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
//			session.flush();
//            session.close();
            sf.close();
		}
	}

}
