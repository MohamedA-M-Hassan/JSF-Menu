package resources;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@NamedQuery(name="User.byId",query="from User where id = ?")
@Entity
@Table (name= "MH_USER")//,uniqueConstraints=@UniqueConstraint (columnNames={"UserName"}))
//@ManagedBean(name="user")
//@SessionScoped
public class User implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@SequenceGenerator(name = "seq_generator", sequenceName = "MH_USER_SEQ2",allocationSize=1)
	private long id;
	
	@Column (name="Password")
	private String password;
	
	@Column (name="UserName")
	private String userName;
	
	@Column (name="Name")
	private String name;
	
	@Column (name="PhoneNum")
	private int phone;
	/*
	@OneToMany(cascade = CascadeType.ALL,mappedBy="ownerUserId")*/
	// trial 
	//@JoinTable(joinColumns= @JoinColumn( name="User_ID")
	//, inverseJoinColumns=@JoinColumn(name="ORDER_ID"))
	/*private Collection<Order> order = new ArrayList<Order>() ;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="userId")
	private Collection<MH_OrderItems> orderItems = new ArrayList<MH_OrderItems>();
	*/
//	public User() {
//		super();
//		name = "Default Name";
//		password = "Default Password";
//	}


	/*
	 public Collection<MH_OrderItems> getOrderItems() {
	 
		return orderItems;
	}
	public void setOrderItems(Collection<MH_OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public Collection<Order> getOrder() {
		return order;
	}
	public void setOrder(Collection<Order> oorder) {
		order = oorder;
	}*/
	public long getId() {
		return id;
	}
	public void setId(long userId) {
		this.id = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
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


}


