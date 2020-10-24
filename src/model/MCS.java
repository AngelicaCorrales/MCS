package model;
public class MCS{
	public final static int MAX_USERS=10;
	public final static int MAX_PLAYLISTS=20;
	public final static int MAX_SONGS=50;

	private User[] users;
	private Song[] poolSongs;
	private Playlist[] playlists;

	public MCS(){
		users= new User[MAX_USERS];
		poolSongs= new Song[MAX_SONGS];
		playlists= new Playlist[MAX_PLAYLISTS];
	}

	public String createUser(String userName, String password, int age){
		String message="El usuario ha sido registrado exitosamente";
		boolean exit=false;
		User objUser=findUser(userName);
		if(objUser==null){
			for(int i=0; i<users.length && !exit; i++){
				if(users[i]==null){
					users[i]= new User(userName, password, age);
					exit=true;
				}
			}
			if(!exit){
				message="Lo sentimos. No se pueden crear mas usuarios :(";
			}

		}
		else{
			message="No se ha podido registrar el usuario. El nombre de usuario ya esta en uso";
		}
		return message;

	}
	
	public User findUser(String userName){
		boolean found= false;
		User obj=null;
		for(int i=0; i<users.length && !found; i++){
			if(users[i]!=null && users[i].getUserName().equals(userName)){
				obj=users[i];
				found=true;
			}
		}
		return obj;
	
	}

	public void showUsers(){

	}

	public void createSong(){

	}

	public void showPoolSongs(){

	}

	public void addSong(){

	}

	public void createPlaylist(){
		
	}
}