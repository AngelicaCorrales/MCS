package model;
public class PublicPlaylist extends Playlist{
	
	private int rateSum;
	private int quantityUsers;
	private double rate;

	public PublicPlaylist(String name){
		super(name);
		rateSum=0;
		quantityUsers=0;
		rate=0;
	}

	public void ratePlaylist(int rateSumx){
		rateSum+=rateSumx;
		rate=rateSum/quantityUsers;

	}

	public int getRateSum(){
		return rateSum;
	}

	public void setRateSum(int rateSum){
		this.rateSum=rateSum;
	}


	public int getQuantityUsers(){
		return quantityUsers;
	}

	public void setQuantityUsers(int quantityUsers){
		this.quantityUsers=quantityUsers;
	}

	public double getRate(){
		return rate;
	}

	public void setRate(int rate){
		this.rate=rate;
	}

	public void userRated(){
		quantityUsers++;
	}
	/*
	

	public double calculateRate(){


	}
	*/

	public void showRate(){
		
	}

}