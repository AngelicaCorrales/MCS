package model;

public class User{

	//constants
	public final static int NEWBIE_TOP=3;
	public final static int LITTLE_CONTRIBUTOR_TOP=10;
	public final static int MILD_CONTRIBUTOR_TOP=30;

	//relationship
	private Category category;

	//attributes
	private String userName;
	private String password;
	private int age;
	private int numSongs;
	
	/**
	*<b>name:</b> User <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the relationships and attributes of the class have been initialized <br>
	*@param userName Is the name of the user. userName!=null and userName!=""<br>
	*@param password Is the password of the user. password!=null and password!=""<br>
	*@param age Is the age of the user. age!=null, age greater than 0  and age less than 131<br>
	*/
	public User(String userName, String password, int age){
		this.userName=userName;
		this.password=password;
		this.age=age;
		category=Category.NEWBIE;
		numSongs=0;

	}//end constructor

	/**
	*<b>name:</b> getUserName <br>
	*This method gets the name of the user <br>
	*<b>post:</b> the name of the user has been gotten <br>
	*@return a <code>string</code> specifying userName, the name of the user 
	*/
	public String getUserName(){
		return userName;
	}//end

	/**
	*<b>name:</b> setUserName <br>
	*This method sets the name of the user <br>
	*<b>post:</b> the name of the user has been set <br>
	*@param userName Is the name of the user. userName!=null and userName!=""<br>
	*/
	public void setUserName(String userName){
		this.userName=userName;
	}//end

	/**
	*<b>name:</b> getPassword<br>
	*This method gets the password of the user <br>
	*<b>post:</b> the password of the user has been gotten <br>
	*@return a <code>string</code> specifying password, the password of the user 
	*/
	public String getPassword(){
		return password;
	}//end

	/**
	*<b>name:</b> setPassword <br>
	*This method sets the password of the user <br>
	*<b>post:</b> the password of the user has been set <br>
	*@param password Is the password of the user. password!=null and password!=""<br>
	*/
	public void setPassword(String password){
		this.password=password;
	}//end

	/**
	*<b>name:</b> getAge <br>
	*This method gets the age of the user <br>
	*<b>post:</b> the age of the user has been gotten <br>
	*@return an <code>integer</code> specifying age, the age of the user 
	*/
	public int getAge(){
		return age;
	}//end

	/**
	*<b>name:</b> setAge <br>
	*This method sets the age of the user <br>
	*<b>post:</b> the age of the user has been set <br>
	*@param age Is the age of the user. age!=null, age greater than 0  and age less than 131<br>
	*/
	public void setAge(int age){
		this.age=age;
	}

	/**
	*<b>name:</b> getCategory <br>
	*This method gets the category of the user <br>
	*<b>post:</b> the category of the user has been gotten <br>
	*@return a <code>Category</code> specifying category, the category of the user 
	*/
	public Category getCategory(){
		return category;
	}//end

	/**
	*<b>name:</b> setCategory <br>
	*This method sets the category of the user <br>
	*<b>post:</b> the category of the user has been set <br>
	*@param category Is the category of the user. category!=null<br>
	*/
	public void setCategory(Category category){
		this.category=category;
	}//end

	/**
	*<b>name:</b> getNumSongs <br>
	*This method gets the number of songs added by the user <br>
	*<b>post:</b> the number of songs added by the user has been gotten <br>
	*@return an <code>integer</code> specifying numSongs, the number of songs added by the user 
	*/
	public int getNumSongs(){
		return numSongs;
	}//end

	/**
	*<b>name:</b> setNumSongs <br>
	*This method sets the number of songs added by the user <br>
	*<b>post:</b> the number of songs added by the user has been set <br>
	*@param numSongs Is the number of songs added by the user. numSongs!=null, numSongs greater than or equal to 0<br>
	*/
	public void setNumSongs(int numSongs){
		this.numSongs=numSongs;
	}//end

	/**
	*<b>name:</b> updateUserCategory <br>
	*This method updates the user category<br>
	*<b>post:</b> the user category has been updated<br>
	*/
	public void updateUserCategory(){
		addedSong();
		if(numSongs<NEWBIE_TOP){ 
			setCategory(Category.NEWBIE);
		}

		else if(numSongs<LITTLE_CONTRIBUTOR_TOP){
			setCategory(Category.LITTLE_CONTRIBUTOR);
		}
		else if(numSongs<MILD_CONTRIBUTOR_TOP){
			setCategory(Category.MILD_CONTRIBUTOR);
		}
		else{
			setCategory(Category.STAR_CONTRIBUTOR);
		}
	}//end updateUserCategory

	/**
	*<b>name:</b> addedSong <br>
	*This method adds one to the number of songs added by the user<br>
	*<b>post:</b> the number of songs has been updated<br>
	*/
	public void addedSong(){
		numSongs++;
	}//end addedSong

	/**
	*<b>name:</b> categoryToString <br>
	*This method turns the category to a string<br>
	*<b>post:</b> the category has been turned to string<br>
	*@return a <code>string</code> specifying cat, the category of the user turned to string 
	*/
	public String categoryToString(){
		String cat;
		cat=category.name();
		return cat;
	}//end categoryToString
}//end class