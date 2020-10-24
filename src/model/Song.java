package model;

public class Song{

	private Genre genre;

	private String title;
	private String artist;
	private int[] duration;

	public Song(String title, String artist){
		this.title=title;
		this.artist=artist;
		duration= new int[2];
		genre=DESCONOCIDO;

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