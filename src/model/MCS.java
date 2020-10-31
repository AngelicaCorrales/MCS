package model;
public class MCS{
	//constants
	public final static int MAX_USERS=10;
	public final static int MAX_PLAYLISTS=20;
	public final static int MAX_SONGS=50;

	//relationships
	private User[] users;
	private Song[] poolSongs;
	private Playlist[] playlists;

	public MCS(){
		users= new User[MAX_USERS];
		poolSongs= new Song[MAX_SONGS];
		playlists= new Playlist[MAX_PLAYLISTS];
	}//end constructor

	public User[] getUsers(){
		return users;
	}//end 

	public void setUsers(User[] users){
		this.users=users;
	}//end

	public Song[] getSongs(){
		return poolSongs;
	}//end

	public void setSongs(Song[] poolSongs){
		this.poolSongs=poolSongs;
	}//end

	public Playlist[] getPlaylists(){
		return playlists;
	}//end

	public void setPlaylists(Playlist[] playlists){
		this.playlists=playlists;
	}//end

	public String createUser(String userName, String password, int age){
		String message="El usuario ha sido registrado exitosamente :D";
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

	}//end createUser
	
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
	
	}//end findUser

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
	}//end showUsers

	public String addSong(String userName, String songTitle, String artist, String date, int[] duration, String genre){
		String message="La cancion ha sido agregada al pool de canciones :D";
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

	}//end addSong

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
	
	}//end findSong

	public void userAddedSong(String userName){
		User userx=findUser(userName);
		userx.updateUserCategory();
	}//end userAddedSong

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

	}//end showPoolSongs


	public Playlist findPlaylist(String playlistName){
		boolean found= false;
		Playlist playlistx=null;
		for(int i=0; i<playlists.length && !found; i++){
			if(playlists[i]!=null && playlists[i].getTitle().equalsIgnoreCase(playlistName)){
				playlistx=playlists[i];
				found=true;
			}
		}
		return playlistx;
	
	}//end findPlaylist

	public String createPlaylist(String userName, String playlistName, int option){
		//private playlist
		String message="La playlist ha sido creada exitosamente :D";
		boolean exit=false;
		Playlist playlistx=findPlaylist(playlistName);
		User user=findUser(userName);
		if(user!=null){
			if(playlistx==null){
				for(int i=0; i<playlists.length && !exit; i++){
					if(playlists[i]==null){
						playlists[i]= new PrivatePlaylist(user, playlistName);
						exit=true;
					}
				}
				if(!exit){
					message="Lo sentimos. No se pueden crear mas playlists :(";
				}

			}
			else{
				message="Ups! Ya existe una playlist con ese nombre";
			}
		}
		else{
			message="No se pudo crear la playlist. El usuario no esta registrado.";
		}
		return message;
		
	}//end createPlaylist

	public String createPlaylist(String userName, String playlistName){
		//public playlist
		String message="La playlist ha sido creada exitosamente :D";
		boolean exit=false;
		Playlist playlistx=findPlaylist(playlistName);
		User user=findUser(userName);
		if(user!=null){
			if(playlistx==null){
				for(int i=0; i<playlists.length && !exit; i++){
					if(playlists[i]==null){
						playlists[i]= new PublicPlaylist(playlistName);
						exit=true;
					}
				}
				if(!exit){
					message="Lo sentimos. No se pueden crear mas playlists :(";
				}

			}
			else{
				message="Ups! Ya existe una playlist con ese nombre";
			}
		}
		else{
			message="No se pudo crear la playlist. El usuario no esta registrado.";
		}
		return message;
		
	}//end createPlaylist

	public String createPlaylist(String[] userNames, String playlistName){
		//restricted playlist
		String message="La playlist ha sido creada exitosamente";
		boolean exit=false;
		Playlist playlistx=findPlaylist(playlistName);
		int userLength=userNames.length;
		User[] usersx= new User[userLength];
		boolean[] exist= new boolean[userLength];
		boolean allExist=true;

		for(int i=0; i<usersx.length; i++){
			usersx[i]=findUser(userNames[i]);
			if(usersx[i]!=null){
				exist[i]=true;
			}
			else{
				exist[i]=false;
				allExist=false;
			}
		}

		if(allExist){

			if(playlistx==null){
				for(int i=0; i<playlists.length && !exit; i++){
					if(playlists[i]==null){
						playlists[i]= new RestrictedPlaylist(usersx, playlistName);
						exit=true;
					}
				}
				if(!exit){
					message="Lo sentimos. No se pueden crear mas playlists :(";
				}
			}
			else{
				message="Ups! Ya existe una playlist con ese nombre";
			}

		}
		else{
			message="No se pudo crear la playlist. Usuario(s) no registrado(s): ";
			for(int i=0; i<usersx.length; i++){
				if(!exist[i]){
					message+="-"+userNames[i];
				}
			}
		}

		return message;
		
	}//end createPlaylist

	public String addSongToPlaylist( String userName, String playlistName, String songName){
		String message="";
		boolean allExist=true;
		User userx= findUser(userName);
		Playlist playlistx=findPlaylist(playlistName);
		Song songx= findSong(songName);

		if( userx==null || playlistx == null  || songx ==null){
			allExist=false;
			message+="Error.";
			if(userx==null){
				message+=" No exite el usuario ingresado.";
			}
			if(playlistx==null){
				message+=" No existe la playlist ingresada.";
			}
			if(songx==null){
				message+=" No exite la cancion ingresada.";
			}
		}
		if(allExist){
			message+=playlistx.addSongToPlaylist(userx, songx);
			
		}
		

		return message;

	}//end adddSongToPlaylist

	public String ratePlaylist(String userName, String playlistName, int rate){
		String message="";
		boolean allExist=true;
		User userx= findUser(userName);
		Playlist playlistx=findPlaylist(playlistName);
			

		if( userx==null || playlistx == null){
			allExist=false;
			message+="Error.";
			if(userx==null){
				message+=" No exite el usuario ingresado.";
			}
			if(playlistx==null){
				message+=" No existe la playlist ingresada.";
			}
			
		}
		if(allExist){
			if(playlistx instanceof PublicPlaylist){
				((PublicPlaylist)playlistx).userRated();
				((PublicPlaylist)playlistx).ratePlaylist(rate);
				message+="Se ha guardado la calificacion :)";

			}
			else{
				message="Ups! La playlist ingresada no es publica";
			}
			
		}

		return message;

	}//end ratePlaylist

	public String showPlaylists(){
		String playlistx="";
		boolean control=false;
		for(int i=0; i<playlists.length && !control; i++){
			if(playlists[i]!=null){
				playlistx+=playlists[i].toString();
				
			}
			else{
				control=true;
			}
		}
		if (playlists[0]==null){
			playlistx="Aun no se han creado playlists";
		}
		return playlistx;
	}//end showPlaylists
	
}//end class