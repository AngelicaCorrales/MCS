package model;
public class RestrictedPlaylist extends Playlist{
	//relationship
	User[] owners;

	/**
	*<b>name:</b> RestrictedPlaylist <br>
	*This is the constructor of the class <br>
	*/
	public RestrictedPlaylist(User[] owners, String name){
		super(name);
		this.owners=owners;
	}//end constructor

	public User[] getOwners(){
		return owners;
	}//end

	public void setOwners(User[] owners){
		this.owners=owners;
	}//end

	public String getOwnersNames(){
		String ownersPlay="";
		for(int i=0; i<owners.length; i++){
			ownersPlay+="- "+owners[i].getUserName()+" ";
		}
		return ownersPlay;
	}//end getOwners

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

	public String toString(){
		return super.toString()+"**  Owner(s): "+getOwnersNames()+"\n \n";
						
	}

	
}//end class