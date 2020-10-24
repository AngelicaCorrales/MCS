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

	public User[] getUsers(){
		return users;
	}

	public void setUsers(User[] users){
		this.users=users;
	}

	public Song[] getSongs(){
		return poolSongs;
	}

	public void setSongs(Song[] songs){
		this.songs=songs;
	}

	public Playlist[] getPlaylists(){
		return playlists;
	}

	public void setPlaylists(Playlist[] playlists){
		this.playlists=playlists;
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

	public String showUsers(){
		String userList="";
		control=false;
		for(int i=0; i<users.length && !control; i++){
			if(users[i]!=null){
				userList+="*************  User **************\n"+
				"**  UserName: "+users[i].getUserName()+"\n"+
				"**  Age: "+users[i].getAge()+"\n"+                      
				"**  Category:" users.getCategory().name()+"\n"+
				"**********************************\n \n";
			}
			else{
				control=true;
			}
		}
		if (users[0]==null){
			userList="Aun no se han registrado usuarios";
		}
		return userList;
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