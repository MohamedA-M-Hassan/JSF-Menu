package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import resources.User;

@ManagedBean(name= "user")
@SessionScoped
public class UserBean implements Serializable {

	private String userName;
	private String name;
	private int phone;
	private String password;
	private String passwordCheck;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	
	
	
	
	
	public String joinUs()
	{	
		if (password.equals(passwordCheck))
		{	User user = new User();
			user.setName(name);
			user.setUserName(userName);
			user.setPassword(password);
			user.setPhone(phone);
		
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
		
			session.save(user);
			
			session.getTransaction().commit();
			session.close();
			
			return "welcome?faces-redirect=true";
			
		}
		else return null;
	}
	public String retrieveUser(){
		
		return"hi";
	}
	/*public void deleteUser(User user)
	{
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		long i = user.getId();
		user= (User)session.get(User.class,i);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	} */

}
