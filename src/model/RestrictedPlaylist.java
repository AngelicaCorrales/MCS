package model;
public class RestrictedPlaylist extends Playlist{

	User[] owners;

	public RestrictedPlaylist(User[] owners, String name){
		super(name);
		this.owners=owners;
	}

	public void usersAccess(){

	}

	public void showUsers(){
		
	}
}