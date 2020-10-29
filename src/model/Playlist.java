package model;

public class Playlist{

	private String title;
	private int[] duration;
	private Genre[] genres;
	private Song[] playlistSongs;
	

	public Playlist(String title){
		this.title=title;
		duration=new int[2];
		genres=new Genre[6];
		playlistSongs= new Song[MCS.MAX_SONGS];
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title=title;
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

	public void updateDuration(Song songx){
		duration[0]+=songx.getDuration()[0];
		duration[1]+=songx.getDuration()[1];

		if(duration[1]>=60){
			duration[0]+=duration[1]/60;
			duration[1]=duration[1]%60;
		}
	}

	public String durationToString(){
		String time;
		if(duration[0]==0 && duration[1]==0){
			time="00:00";
		}
		if(duration[1]<10){
			time=duration[0]+":0"+duration[1]; 
		}
		else{
			time=duration[0]+":"+duration[1]; 
		}
		
		
		return time;
	}

	public void updateGenre(Song songx){
		boolean same=false;
		boolean exit=false;
		for(int i=0; i<genres.length && !same; i++){
			if(genres[i]!=null && genres[i]==songx.getGenre()){
				same=true;
			}
		}
		if(!same){
			for(int i=0; i<genres.length && !exit; i++){
				if(genres[i]==null){
					genres[i]=songx.getGenre();
					exit=true;

				}
			}
		}
	}

	public String genreToString(){
		String genrex="";
		for(int i=0; i<genres.length; i++){
			if(genres[0]==null){
				genrex=Genre.UNKNOWN.name();
			}
			if(genres[i]!=null){
				genrex+="-"+genres[i].name();
			}
			
		}
		return genrex;
	}

	public String addSongToPlaylist(User userx, Song songx){
		String message="";
		boolean control=false;
		for(int i=0; i<playlistSongs.length && !control; i++){
			if(playlistSongs[i]==null){
				playlistSongs[i]=songx;
				control=true;
				message="Se agrego la cancion a la playlist exitosamente";
				updateDuration(songx);
				updateGenre(songx);
			}
		}
		if(!control){
			message="Lo sentimos. No se pudo agregar la cancion a la playlist :(";
		}
		return message;
	}

	
}