package model;
public class RestrictedPlaylist extends Playlist{

	User[] owners;

	public RestrictedPlaylist(User[] owners, String name){
		super(name);
		this.owners=owners;
	}

	public User[] getUser(){
		return owners;
	}

	public String getOwners(){
		String ownersPlay="";
		for(int i=0; i<owners.length; i++){
			ownersPlay+="- "+owners[i].getUserName()+" ";
		}
		return ownersPlay;
	}

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
	}

	
}