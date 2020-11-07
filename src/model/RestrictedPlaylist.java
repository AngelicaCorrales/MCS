package model;
public class RestrictedPlaylist extends Playlist{
	//relationship
	User[] owners;

	/**
	*<b>name:</b> RestrictedPlaylist <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the relationships and attributes of the class have been initialized <br>
	*@param name Is the title of the playlist. name!=null and name!=""<br>
	*@param owners Is the array of owners of the playlist. owners!=null<br>
	*/
	public RestrictedPlaylist(User[] owners, String name){
		super(name);
		this.owners=owners;
	}//end constructor

	/**
	*<b>name:</b> getOwners <br>
	*This method gets the array of owners of the playlist <br>
	*<b>post:</b> the array of owners has been gotten <br>
	*@return an array of <code>User</code> specifying owners, the owners of the playlist
	*/
	public User[] getOwners(){
		return owners;
	}//end

	/**
	*<b>name:</b> setOwners <br>
	*This method sets the array of owners of the playlist <br>
	*<b>post:</b> the array of owners has been set <br>
	* @param owners Is an array with the owners of the playlist. 
	*/
	public void setOwners(User[] owners){
		this.owners=owners;
	}//end

	/**
	*<b>name:</b> getOwnersNames <br>
	*This method returns the names of the owners of the playlist<br>
	*<b>post:</b> the names of the owners of the playlist have been returned<br>
	*@return a <code>string</code> specifying ownersPlay, the names of the owners of the playlist
	*/
	public String getOwnersNames(){
		String ownersPlay="";
		for(int i=0; i<owners.length; i++){
			ownersPlay+="- "+owners[i].getUserName()+" ";
		}
		return ownersPlay;
	}//end getOwnersNames

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
		boolean control=false;
		for(int i=0; i<owners.length && !control; i++){
			if(userx.getUserName().equals(owners[i].getUserName())){
				control=true;
				message=super.addSongToPlaylist(userx, songx);
			}
			else{
				message="No se puede agregar la cancion. El usuario no es colaborador de la playlist";
			}
		}

		return message;
	}//end addSongToPlaylist

	/**
	*<b>name:</b> toString <br>
	*This method return the title, duration, genre and owners of the playlist on a string<br>
	*<b>post:</b> the title, duration, genre and owners of the playlist have been returned<br>
	*@return a <code>string</code> specifying the title, duration, genre and owners of the playlist
	*/
	@Override 
	public String toString(){
		return super.toString()+"**  Owner(s): "+getOwnersNames()+"\n \n";
						
	}

	
}//end class