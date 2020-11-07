package model;

public abstract class Playlist{
	//constants
	public final static int MIN_SEC_HOUR=3;
	public final static int MAX_GENRES=6;

	//attributes
	private String title;
	private int[] duration;

	//relationships
	private Genre[] genres;
	private Song[] playlistSongs;
	
	/**
	*<b>name:</b> Playlist <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the relationships and attributes of the class have been initialized <br>
	*@param title Is the title of the playlist. title!=null and title!=""<br>
	*/
	public Playlist(String title){
		this.title=title;
		duration=new int[MIN_SEC_HOUR];
		genres=new Genre[MAX_GENRES];
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

	public Song[] getPlaylistSongs(){
		return playlistSongs;
	}//end

	public void setPlaylistSongs(Song[] playlistSongs){
		this.playlistSongs=playlistSongs;
	}//end


	/**
	*<b>name:</b> updateDuration <br>
	*This method updates the duration of the playlist<br>
	*<b>post:</b> the duration has been updated<br>
	*/
	public void updateDuration(Song songx){
		duration[0]+=songx.getDuration()[0];
		duration[1]+=songx.getDuration()[1];

		
		duration[0]+=duration[1]/60;
		duration[1]=duration[1]%60;

		duration[2]+=duration[0]/60;
		duration[0]=duration[0]%60;
		
	}//end updateDuration

	/**
	*<b>name:</b> durationToString <br>
	*This method turns the durartion of the playlist to a string<br>
	*<b>post:</b> the duration has been turned to string<br>
	*@return a <code>string</code> specifying time, the duration of the playlist turned to string 
	*/
	public String durationToString(){
		String time;
		String hour="";
		String min="";
		String sec="";

		if(duration[0]<10){
			min="0"+duration[0]; 
		}
		else{
			min=""+duration[0];
		}

		if(duration[1]<10){
			sec="0"+duration[1]; 
		}

		else{
			sec=""+duration[1];
		}

		if(duration[2]<10){
			hour="0"+duration[2]; 
		}
		else{
			hour=""+duration[2];
		}

		time=hour+":"+min+":"+sec;
		
		
		return time;
	}//enddurationToString

	/**
	*<b>name:</b> updateGenre <br>
	*This method updates the genres of the playlist<br>
	*<b>post:</b> the genres has been updated<br>
	*/
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

	/**
	*<b>name:</b> genreToString <br>
	*This method turns the genre to a string<br>
	*<b>post:</b> the genre has been turned to string<br>
	*@return a <code>string</code> specifying genrex, the genre of the playlist turned to string 
	*/
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

	/**
	*<b>name:</b> addSongToPlaylist <br>
	*This method can add a song to a playlist<br>
	*<b>post:</b> the song may have been added to the playlist<br>
	*@param userx Is the user. user!=null<br>
	*@param songx Is the song. song!=null<br>
	*@return a <code>string</code> specifying message, the message if the song has been added or not
	*/
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

	/**
	*<b>name:</b> toString <br>
	*This method return the title, duration and genre of the playlist on a string<br>
	*<b>post:</b> the title, duration and genre of the playlist have been returned<br>
	*@return a <code>string</code> specifying the title, duration and genre of the playlist
	*/
	public String toString(){
		return "**************  Playlist **************\n"+
				"**  Title: "+title+"\n"+
				"**  Duration: "+ durationToString()+"\n"+
				"**  Genre: "+genreToString()+"\n";
	}

	
}//end class