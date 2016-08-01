package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

import resources.User;

@ManagedBean(name = "login")
@SessionScoped
public class Login implements Serializable {

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String actionLogin() {

		//boolean flag = false;

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("User.byName");
		query.setString(0, userName);
		List<User> users = (List<User>) query.list();

		for (User ay7aga : users) {
			if (userName.equals(ay7aga.getUserName()) && password.equals(ay7aga.getPassword())) {
				session.getTransaction().commit();
				session.close();

				return "home?faces-redirect=true";

			}
		}
		session.getTransaction().commit();
		session.close();
		return null;

	}

}
