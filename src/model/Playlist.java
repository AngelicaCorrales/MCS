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
		playlistSongs= new Song[MCS.MAX_SONGS];
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

	public void setGenres(Genre[] genres){
		this.genres=genres;
	}

	public Song[] getSongs(){
		return playlistSongs;
	}

	public void setSongs(Song[] playlistSongs){
		this.playlistSongs=playlistSongs;
	}

	public String addSongToPlaylist(User userx, Song songx){
		String message="";
		boolean control=false;
		for(int i=0; i<playlistSongs.length && !control; i++){
			if(playlistSongs[i]==null){
				playlistSongs[i]=songx;
				control=true;
				message="Se agrego la cancion a la playlist exitosamente";
			}
		}
		if(!control){
			message="Lo sentimos. No se pudo agregar la cancion a la playlist :(";
		}
		return message;
	}
}