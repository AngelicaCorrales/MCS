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

	public void setSongs(Song[] poolSongs){
		this.poolSongs=poolSongs;
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
		boolean control=false;
		for(int i=0; i<users.length && !control; i++){
			if(users[i]!=null){
				userList+="*************  User **************\n"+
				"**  UserName: "+users[i].getUserName()+"\n"+
				"**  Age: "+users[i].getAge()+"\n"+                      
				"**  Category:"+ users[i].categoryToString()+"\n"+
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

	public String addSong(String userName, String songTitle, String artist, String date, int[] duration, String genre){
		String message="La cancion ha sido agregada al pool de canciones";
		boolean exit=false;
		Song song=findSong(songTitle);
		User user=findUser(userName);
		if(user!=null){
			if(song==null){
				for(int i=0; i<poolSongs.length && !exit; i++){
					if(poolSongs[i]==null){
						poolSongs[i]= new Song(songTitle, artist, date, duration, genre);
						exit=true;
						userAddedSong(userName);
					}
				}
				if(!exit){
					message="Lo sentimos. No se pueden agregar mas canciones :(";
				}

			}
			else{
				message="Ups! La cancion ya habia sido agregada al pool de canciones";
			}
		}
		else{
			message="No se pudo agregar la cancion. El usuario no esta registrado.";
		}
		return message;

	}

	public Song findSong(String songTitle){
		boolean found= false;
		Song song=null;
		for(int i=0; i<poolSongs.length && !found; i++){
			if(poolSongs[i]!=null && poolSongs[i].getTitle().equalsIgnoreCase(songTitle)){

				song=poolSongs[i];
				found=true;
			}
		}
		return song;
	
	}

	public void userAddedSong(String userName){
		User userx=findUser(userName);
		userx.updateUserCategory();
	}

	public String showPoolSongs(){
		String poolList="";
		boolean control=false;
		for(int i=0; i<poolSongs.length && !control; i++){
			if(poolSongs[i]!=null){
				poolList+="**************  Song **************\n"+
				"**  Title: "+poolSongs[i].getTitle()+"\n"+
				"**  Artist: "+poolSongs[i].getArtist()+"\n"+                      
				"**  Duration: "+ poolSongs[i].durationToString()+"\n"+
				"**  Genre: "+poolSongs[i].genreToString()+"\n"+
				"***********************************\n \n";
			}
			else{
				control=true;
			}
		}
		if (poolSongs[0]==null){
			poolList="Aun no se han compartido canciones";
		}
		return poolList;

	}


	public void createPlaylist(){
		//sobrecarga con public private y restricted
	}

	/*
	public String addSongToPlaylist(String playlistName, String userName, String songName){
		String message="";
		boolean control=true;
		Playlist playlistx=findPlaylist(playlistName);
		User userx= findUser(userName);
		Song songx= findSong(songName);

		if( playlistx == null || userx==null || songx ==null){
			control=false;
			message+="Error.";
			if(playlistx==null){
				message+=" No existe la playlist ingresada.";
			}
			if(userx==null){
				message+=" No exite el usuario ingresado.";
			}
			if(songx==null){
				message+=" No exite la cancion ingresada.";
			}
		}
		if(control){
			message+=playlistx.addSongToPlaylist(userx, songx);
			
		}

		return message;


	}
	*/
}