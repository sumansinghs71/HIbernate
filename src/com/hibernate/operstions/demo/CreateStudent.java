package com.hibernate.operstions.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.annotations.entity.demo.Student;
import com.hidernate.utils.DateUtils;

public class CreateStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating Session factory
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// Creating Session 
		Session session=sf.getCurrentSession();
		try {
			String theDateOfBirthStr = "31/12/1998";
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			//Creating Student
			Student st=new Student("PAul","Pinix", "abc@gmail.com",theDateOfBirth);
			//begin transaction
			session.beginTransaction();
			//save object
			session.save(st);
			//commit transaction
			session.getTransaction().commit();
			
		}catch(Exception e) {
			session.flush();
            session.close();
            sf.close();
		}
	}

}
