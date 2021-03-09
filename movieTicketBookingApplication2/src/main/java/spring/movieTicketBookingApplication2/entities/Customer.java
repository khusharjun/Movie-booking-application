package spring.movieTicketBookingApplication2.entities;
//package spring.movieTicketBookingApplication.entities;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class Customer {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	int id;
//	String customerName;
//	String address;
//	String mobileNumber;
//	String email;
//	String password;
//	
//	public Customer() {
//		
//	}
//	
//	public Customer(String customerName, String address, String mobileNumber, String email, String password) {
//		this.customerName = customerName;
//		this.address = address;
//		this.mobileNumber = mobileNumber;
//		this.password = password;
//		this.email = email;
//		
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getCustomerName() {
//		return customerName;
//	}
//
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getMobileNumber() {
//		return mobileNumber;
//	}
//
//	public void setMobileNumber(String mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", customerName=" + customerName + ", address=" + address + ", mobileNumber="
//				+ mobileNumber + ", email=" + email + ", password=" + password + "]";
//	}
//	
//	
//
//}
