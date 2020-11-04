package model;
public class PrivatePlaylist extends Playlist{
	//relationship
	private User owner;

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

	public String toString(){
		return super.toString()+"**  Owner: "+owner.getUserName()+"\n \n";
				
				
	}

}//end class