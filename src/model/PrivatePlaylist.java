package model;
public class PrivatePlaylist extends Playlist{
	
	private User owner;

	public PrivatePlaylist(User owner, String name){
		super(name);
		this.owner=owner;

	}
	/*
	public void userAcces(){

	}

	public void showUser(){
		
	}
	*/

	public String addSongToPlaylist(User userx, Song songx){
		String message="";
		boolean control=false;

		if(userx.getUserName().equals(owner.getUserName())){
			control=true;
			message=super.addSongToPlaylist(userx, songx);
		}
		else{
			message="No se puede agregar la cancion. El usuario no es propietario de la playlist";
		}

		return message;
	}
}