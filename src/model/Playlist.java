package model;

public abstract class Playlist{
	//attributes
	private String title;
	private int[] duration;

	//relationships
	private Genre[] genres;
	private Song[] playlistSongs;
	

	public Playlist(String title){
		this.title=title;
		duration=new int[2];
		genres=new Genre[6];
		playlistSongs= new Song[MCS.MAX_SONGS];
	}//end constructor

	public String getTitle(){
		return title;
	}//end

	public void setTitle(String title){
		this.title=title;
	}//end

	public int[] getDuration(){
		return duration;
	}//end

	public void setDuration(int[] duration){
		this.duration=duration;
	}//end

	public Genre[] getGenres(){
		return genres;
	}//end

	public void setGenres(Genre[] genres){
		this.genres=genres;
	}//end

	public Song[] getSongs(){
		return playlistSongs;
	}//end

	public void setSongs(Song[] playlistSongs){
		this.playlistSongs=playlistSongs;
	}//end

	public void updateDuration(Song songx){
		duration[0]+=songx.getDuration()[0];
		duration[1]+=songx.getDuration()[1];

		if(duration[1]>=60){
			duration[0]+=duration[1]/60;
			duration[1]=duration[1]%60;
		}
	}//end updateDuration

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
	}//enddurationToString

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
	}//end updateGenre

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
	}//end genreToString

	public String addSongToPlaylist(User userx, Song songx){
		String message="";
		boolean control=false;
		for(int i=0; i<playlistSongs.length && !control; i++){
			if(playlistSongs[i]==null){
				playlistSongs[i]=songx;
				control=true;
				message="Se agrego la cancion a la playlist exitosamente :D";
				updateDuration(songx);
				updateGenre(songx);
			}else{
				if(playlistSongs[i]==songx){
					message="Ups! La cancion ya estaba en la playlist";
					control=true;
				}
			}
		}
		if(!control){
			message="Lo sentimos. No se pudo agregar la cancion a la playlist :(";
		}
		return message;
	}//end addSongToPlaylist

	public String toString(){
		return "**************  Playlist **************\n"+
				"**  Title: "+title+"\n"+
				"**  Duration: "+ durationToString()+"\n"+
				"**  Genre: "+genreToString()+"\n";
	}

	
}//end class