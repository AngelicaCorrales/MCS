package model;
public class PublicPlaylist extends Playlist{
	//attributes
	private int rateSum;
	private int quantityUsers;
	private double rate;

	public PublicPlaylist(String name){
		super(name);
		rateSum=0;
		quantityUsers=0;
		rate=0;
	}//end constructor

	public void ratePlaylist(int rateSumx){
		rateSum+=rateSumx;
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

	public void userRated(){
		quantityUsers++;
	}//end userRated

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