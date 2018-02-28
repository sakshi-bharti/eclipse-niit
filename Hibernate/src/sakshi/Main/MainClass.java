package sakshi.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sakshi.bean.UserDetails;

public class MainClass {
	public static void main(String args[]) {
		UserDetails user=new UserDetails();
		user.setUid(101);
		user.setUserName("sakshi");
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		session.getTransaction().commit();
	}
}
