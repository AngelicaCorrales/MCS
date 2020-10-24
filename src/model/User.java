package model;

public class User{

	private String userName;
	private String password;
	private int age;
	private Category category;

	public User(String userName, String password, int age){
		this.userName=userName;
		this.password=password;
		this.age=age;
		category=NEWBIE;

	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public int getAge(){
		return age;
	}

	public void setUserName(int age){
		this.age=age;
	}

	public Category getCategory(){
		return category;
	}

	public void setCategory(Category category){
		this.category=category;
	}

	public void updateUserCategory(){

	}
}