package model;
public class PrivatePlaylist extends Playlist{
	//relationship
	private User owner;

	/**
	*<b>name:</b> PrivatePlaylist <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the relationships and attributes of the class have been initialized <br>
	*@param name Is the title of the playlist. name!=null and name!=""<br>
	*@param owner Is the owner of the playlist. owner!=null<br>
	*/
	public PrivatePlaylist(User owner, String name){
		super(name);
		this.owner=owner;

	}//end constructor

	public User getOwner(){
		return owner;
	}//end
	
	public void setOwner(User owner){
		this.owner=owner;
	}//end
	/**
	*<b>name:</b> addSongToPlaylist <br>
	*This method can add a song to a playlist<br>
	*<b>post:</b> the song may have been added to the playlist<br>
	*@param userx Is the user. user!=null<br>
	*@param songx Is the song. song!=null<br>
	*@return a <code>string</code> specifying message, the message if the song has been added or not
	*/
	@Override 
	public String addSongToPlaylist(User userx, Song songx){
		String message="";
		
		if(userx.getUserName().equals(owner.getUserName())){
			message=super.addSongToPlaylist(userx, songx);
		}
		else{
			message="No se puede agregar la cancion. El usuario no es propietario de la playlist";
		}

		return message;
	}//end addSongToPlaylist

	/**
	*<b>name:</b> toString <br>
	*This method return the title, duration, genre and owner of the playlist on a string<br>
	*<b>post:</b> the title, duration, genre and owner of the playlist have been returned<br>
	*@return a <code>string</code> specifying the title, duration, genre and owner of the playlist
	*/
	@Override 
	public String toString(){
		return super.toString()+"**  Owner: "+owner.getUserName()+"\n \n";
				
				
	}

}//end class