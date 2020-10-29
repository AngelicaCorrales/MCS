package model;

public class User{

	//relationship
	private Category category;

	//attributes
	private String userName;
	private String password;
	private int age;
	private int numSongs;
	

	public User(String userName, String password, int age){
		this.userName=userName;
		this.password=password;
		this.age=age;
		category=Category.NEWBIE;
		numSongs=0;

	}//end constructor

	public String getUserName(){
		return userName;
	}//end

	public void setUserName(String userName){
		this.userName=userName;
	}//end

	public String getPassword(){
		return password;
	}//end

	public void setPassword(String password){
		this.password=password;
	}//end

	public int getAge(){
		return age;
	}//end

	public void setUserName(int age){
		this.age=age;
	}

	public Category getCategory(){
		return category;
	}//end

	public void setCategory(Category category){
		this.category=category;
	}//end

	public void updateUserCategory(){
		addedSong();
		if(numSongs<3){ 
			setCategory(Category.NEWBIE);
		}

		else if(numSongs<10){
			setCategory(Category.LITTLE_CONTRIBUTOR);
		}
		else if(numSongs<30){
			setCategory(Category.MILD_CONTRIBUTOR);
		}
		else{
			setCategory(Category.STAR_CONTRIBUTOR);
		}
	}//end updateUserCategory

	public int getNumSongs(){
		return numSongs;
	}//end

	public void addedSong(){
		numSongs++;
	}//end addedSong

	public String categoryToString(){
		String cat;
		cat=category.name();
		return cat;
	}//end categoryToString
}//end class