package model;
public class PublicPlaylist extends Playlist{
	//attributes
	private int rateSum;
	private int quantityUsers;
	private double rate;

	/**
	*<b>name:</b> PublicPlaylist <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the relationships and attributes of the class have been initialized <br>
	*@param name Is the title of the playlist. name!=null and name!=""<br>
	*/
	public PublicPlaylist(String name){
		super(name);
		rateSum=0;
		quantityUsers=0;
		rate=0;
	}//end constructor

	/**
	*<b>name:</b> getRateSum<br>
	*This method gets the sum of ratings <br>
	*<b>post:</b> the sum of ratings has been gotten <br>
	*@return an <code>integer</code> specifying rateSum, the sum of ratings 
	*/
	public int getRateSum(){
		return rateSum;
	}//end

	/**
	*<b>name:</b> setRateSum <br>
	*This method sets the sum of ratings  <br>
	*<b>post:</b> the sum of ratings has been set <br>
	*@param rateSum Is the sum of ratings . rateSum !=null, rateSum  greater than or equal to 0<br>
	*/
	public void setRateSum(int rateSum){
		this.rateSum=rateSum;
	}//end

	/**
	*<b>name:</b> getQuantityUsers <br>
	*This method gets the quantity of users who have rated the playlist <br>
	*<b>post:</b> the quantity of users who have rated the playlist has been gotten <br>
	*@return an <code>integer</code> specifying quantityUsers, the quantity of users who have rated the playlist
	*/
	public int getQuantityUsers(){
		return quantityUsers;
	}//end

	/**
	*<b>name:</b> setQuantityUsers <br>
	*This method sets the quantity of users who have rated the playlist <br>
	*<b>post:</b> the quantity of users who have rated the playlist has been set <br>
	*@param quantityUsers Is the quantity of users who have rated the playlist. quantityUsers!=null, quantityUsers greater than or equal to 0<br>
	*/
	public void setQuantityUsers(int quantityUsers){
		this.quantityUsers=quantityUsers;
	}//end

	/**
	*<b>name:</b> getRate <br>
	*This method gets the average rating of the playlist <br>
	*<b>post:</b> the average rating of the playlist has been gotten<br>
	*@return an <code>integer</code> specifying rate, the average rating of the playlist
	*/
	public double getRate(){
		return rate;
	}//end

	/**
	*<b>name:</b> setRate <br>
	*This method sets the average rating of the playlist <br>
	*<b>post:</b> the average rating of the playlist has been set <br>
	*@param rate Is the average rating of the playlist . rate !=null, rate  greater than or equal to 0<br>
	*/
	public void setRate(double rate){
		this.rate=rate;
	}//end

	/**
	*<b>name:</b> ratePlaylist <br>
	*This method calculates the average rating of the playlist <br>
	*<b>post:</b> the average rating of the playlist has been calculated<br>
	* @param ratex Is the rating given by the user. 
	*/
	public void ratePlaylist(int ratex){
		rateSum+=ratex;
		rate=(double)rateSum/(double)quantityUsers;

	}//end ratePlaylist

	/**
	*<b>name:</b> userRated <br>
	*This method adds one to the quantity of users that rated the playlist<br>
	*<b>post:</b> quantity of users that rated the playlist has been updated<br>
	*/
	public void userRated(){
		quantityUsers++;
	}//end userRated

	/**
	*<b>name:</b> toString <br>
	*This method return the title, duration, genre and average rating of the playlist on a string<br>
	*<b>post:</b> the title, duration, genre and average rating of the playlist have been returned<br>
	*@return a <code>string</code> specifying  list, is the title, duration, genre and average rating of the playlist
	*/
	@Override 
	public String toString(){
		String list=super.toString();
		if(rate!=0){
			list+="**  Average Rating: "+rate+"\n \n";
		}
		else{
			list+="**  Average Rating: -\n \n";
		}
		return list;
				
				
	}

}//end class