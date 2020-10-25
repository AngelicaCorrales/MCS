package model;

public class Song{

	private Genre genre;

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

	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getArtist(){
		return title;
	}

	public void setArtist(String artist){
		this.artist=artist;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate=releaseDate;
	}

	public int[] getDuration(){
		return duration;
	}

	public void setDuration(int[] duration){
		this.duration=duration;
	}

	public Genre getGenre(){
		return genre;
	}

	public void setGenre(Genre genre){
		this.genre=genre;
	}
}