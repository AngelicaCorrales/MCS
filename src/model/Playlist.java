package model;

public class Playlist{

	private String name;
	private int[] duration;
	private Genre[] genres;
	private Song[] playlistSongs;

	public Playlist(String name){
		this.name=name;
		duration=new int[2];
		genres=new Genre[6];
		playlistSongs= new Song[50];
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public int[] getDuration(){
		return duration;
	}

	public void setDuration(int[] duration){
		this.duration=duration;
	}

	public Genre[] getGenres(){
		return genres;
	}

	public void setGenres(Genre genres){
		this.genres=genres;
	}

	public Song[] getSongs(){
		return playlistSongs;
	}

	public void setSongs(Song playlistSongs){
		this.playlistSongs=playlistSongs;
	}
}