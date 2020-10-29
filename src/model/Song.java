package model;

public class Song{
	//relationships
	private Genre genre;

	//attributes
	private String title;
	private String artist;
	private String releaseDate;
	private int[] duration;


	public Song(String title, String artist, String releaseDate, int[] duration, String genre){
		this.title=title;
		this.artist=artist;
		this.releaseDate=releaseDate;
		this.duration=duration;
		this.genre=Genre.valueOf(genre);

	}//end constructor

	public String getTitle(){
		return title;
	}//end

	public void setTitle(String title){
		this.title=title;
	}//end

	public String getArtist(){
		return artist;
	}//end

	public void setArtist(String artist){
		this.artist=artist;
	}//end

	public String getReleaseDate(){
		return releaseDate;
	}//end

	public void setReleaseDate(String releaseDate){
		this.releaseDate=releaseDate;
	}//end

	public int[] getDuration(){
		return duration;
	}//end

	public void setDuration(int[] duration){
		this.duration=duration;
	}//end

	public Genre getGenre(){
		return genre;
	}//end

	public void setGenre(Genre genre){
		this.genre=genre;
	}//end

	public String durationToString(){
		String time;
		if(duration[1]<10){
			time=duration[0]+":0"+duration[1]; 
		}
		else{
			time=duration[0]+":"+duration[1];
		}

		
		return time;
	}//end durationToString

	public String genreToString(){
		String genrex;
		genrex=genre.name();
		return genrex;
	}//end genreToString

}//end class