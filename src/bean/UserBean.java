/*package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import resources.User;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {
	public void insertUser(String name, String pass)
	{
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = new User();
		user.setName(name);
		user.setPassword(pass);
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	public void deleteUser(User user)
	{
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		long i = user.getId();
		user= (User)session.get(User.class,i);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	} 

}
*/