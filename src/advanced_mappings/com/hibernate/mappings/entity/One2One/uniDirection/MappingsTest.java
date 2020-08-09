package advanced_mappings.com.hibernate.mappings.entity.One2One.uniDirection;

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
			InstructorDetail idetails=new InstructorDetail("https://youtube.com","Playing");
			Instructor i=new Instructor("suman","singh","abc@gmail.com");
			i.setInstructorDetail(idetails);
			//begin transaction
			session.beginTransaction();
			//save object
			session.save(i);
			//commit transaction
			session.getTransaction().commit();
			
			// find out the instructor's id: primary key
			System.out.println("Saved Instructor. Generated id: " + i.getId());
			
			// now get a new session and start transaction
			session = sf.getCurrentSession();
			session.beginTransaction();
			
			// retrieve instructor based on the id: primary key
			System.out.println("\nGetting instructor with id: " + i.getId());
						
			Instructor myinstructor = session.get(Instructor.class, i.getId());
			System.out.println("Get complete: " + myinstructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			// now get a new session and start transaction
			session = sf.getCurrentSession();
			session.beginTransaction();
			
			session.delete(i);
			// commit the transaction
			session.getTransaction().commit();
			
			

		}catch(Exception e) {
			session.flush();
            session.close();
            sf.close();
		}
	}

}
