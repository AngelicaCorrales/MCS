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

	public void ratePlaylist(int ratex){
		rateSum+=ratex;
		rate=(double)rateSum/(double)quantityUsers;

	}//end ratePlaylist

	public int getRateSum(){
		return rateSum;
	}//end

	public void setRateSum(int rateSum){
		this.rateSum=rateSum;
	}//end


	public int getQuantityUsers(){
		return quantityUsers;
	}//end

	public void setQuantityUsers(int quantityUsers){
		this.quantityUsers=quantityUsers;
	}//end

	public double getRate(){
		return rate;
	}//end

	public void setRate(int rate){
		this.rate=rate;
	}//end

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