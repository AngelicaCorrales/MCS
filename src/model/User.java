package model;

public class User{

	private String userName;
	private String password;
	private int age;
	private Category category;
	private int numSongs;

	public User(String userName, String password, int age){
		this.userName=userName;
		this.password=password;
		this.age=age;
		category=NEWBIE;
		numSongs=0;

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
		int nSongs=addedSong();
		if(nSongs<3){
			setCategory(NEWBIE);
		}

		else if(nSongs<10){
			setCategory(LITTLE_CONTRIBUTOR);
		}
		else if(nSongs<30){
			setCategory(MILD_CONTRIBUTOR);
		}
		else{
			setCategory(STAR_CONTRIBUTOR);
		}
	}

	public int getNumSongs(){
		return numSongs;
	}

	public int addedSong(){
		numSongs++;
		return numSongs;
	}
}