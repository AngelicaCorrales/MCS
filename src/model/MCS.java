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

	/**
	*<b>name:</b> MCS <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the relationships of the class have been initialized
	*/
	public MCS(){
		users= new User[MAX_USERS];
		poolSongs= new Song[MAX_SONGS];
		playlists= new Playlist[MAX_PLAYLISTS];
	}//end constructor

	/**
	*<b>name:</b> getUsers <br>
	*This method gets the array of users <br>
	*<b>post:</b> the array of users has been gotten <br>
	*@return an array of <code>User</code> specifying users, the users of MCS
	*/
	public User[] getUsers(){
		return users;
	}//end 

	/**
	*<b>name:</b> setUsers <br>
	*This method sets the array of users <br>
	*<b>post:</b> the array of users has been set <br>
	* @param users is an array with the users. 
	*/
	public void setUsers(User[] users){
		this.users=users;
	}//end

	/**
	*<b>name:</b> getPoolSongs <br>
	*This method gets the array of pool songs <br>
	*<b>post:</b> the array of pool songs has been gotten <br>
	*@return an array of <code>Song</code> specifying poolSongs, the songs of the pool
	*/
	public Song[] getPoolSongs(){
		return poolSongs;
	}//end

	/**
	*<b>name:</b> setPoolSongs <br>
	*This method sets the array of pool songs <br>
	*<b>post:</b> the array of pool songs has been set <br>
	* @param poolSongs Is an array with the pool songs. 
	*/
	public void setPoolSongs(Song[] poolSongs){
		this.poolSongs=poolSongs;
	}//end

	/**
	*<b>name:</b> getPlaylists <br>
	*This method gets the array of playlists <br>
	*<b>post:</b> the array of playlists has been gotten <br>
	*@return an array of <code>Playlist</code> specifying playlists, the playlist of MCS
	*/
	public Playlist[] getPlaylists(){
		return playlists;
	}//end

	/**
	*<b>name:</b> setPlaylists <br>
	*This method sets the array of playlists <br>
	*<b>post:</b> the array of playlists has been set <br>
	* @param playlists Is an array with the playlists. 
	*/
	public void setPlaylists(Playlist[] playlists){
		this.playlists=playlists;
	}//end

	/**
	*<b>name:</b> createUser <br>
	*This method can create an user<br>
	*<b>post:</b> the user may have been created<br>
	*@param userName Is the name of the user. userName!=null and userName!=""<br>
	*@param password Is the password of the user. password!=null and password!=""<br>
	*@param age Is the age of the user. age!=null, age greater than 0  and age less than 131<br>
	*@return a <code>string</code> specifying message, the message if the user has been created or not
	*/
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
	
	/**
	*<b>name:</b> findUser <br>
	*This method finds an user<br>
	*<b>post:</b> the user may have been found<br>
	*@param userName Is the name of the user. userName!=null and userName!=""<br>
	*@return a <code>User</code> specifying obj, the user if it has been found or not
	*/
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

	/**
	*<b>name:</b> showUsers <br>
	*This method shows the users that have been created<br>
	*<b>post:</b> the users have been shown<br>
	*@return a <code>string</code> specifying userList, the list of created users
	*/
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

	/**
	*<b>name:</b> addSong <br>
	*This method can add a song to the pool songs<br>
	*<b>post:</b> the song may have been added<br>
	*@param userName Is the name of the user. userName!=null and userName!=""<br>
	*@param songTitle Is title of the song. songTitle!=null and songTitle!=""<br>
	*@param artist Is the artist of the song. artist!=null and artist!=""<br>
	*@param date Is the release date of the song. date!=null and date!=""<br>
	*@param duration Is the array of the duration of the song. duration!=null<br>
	*@param genre Is the genre of the song. genre!=null and genre!=""<br>
	*@return a <code>string</code> specifying message, the message if the song has been added or not
	*/
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
						user.updateUserCategory();;
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

	/**
	*<b>name:</b> findSong <br>
	*This method finds a song<br>
	*<b>post:</b> the song may have been found<br>
	*@param songTitle Is the title of the song. songTitle!=null and songTitle!=""<br>
	*@return a <code>Song</code> specifying song, the song if it has been found or not
	*/
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

	/**
	*<b>name:</b> showPoolSongs <br>
	*This method shows the songs that have been created<br>
	*<b>post:</b> the songs have been shown<br>
	*@return a <code>string</code> specifying poolList, the list of created songs
	*/
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

	/**
	*<b>name:</b> findPlaylist <br>
	*This method finds a playlist<br>
	*<b>post:</b> the playlist may have been found<br>
	*@param playlistName Is the name of the playlist. playlistName!=null and playlistName!=""<br>
	*@return a <code>Playlist</code> specifying playlistx, the playlist if it has been found or not
	*/
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

	/**
	*<b>name:</b> createPlaylist <br>
	*This method can create a private playlist<br>
	*<b>post:</b> the playlist may have been created<br>
	*@param userName Is the name of the user. userName!=null and userName!=""<br>
	*@param playlistName Is the name of the playlist. playlistName!=null and playlistName!=""<br>
	*@param option Is the option chosen. option!=null, option==1<br>
	*@return a <code>string</code> specifying message, the message if the playlist has been created or not
	*/
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

	/**
	*<b>name:</b> createPlaylist <br>
	*This method can create a public playlist<br>
	*<b>post:</b> the playlist may have been created<br>
	*@param userName Is the name of the user. userName!=null and userName!=""<br>
	*@param playlistName Is the name of the playlist. playlistName!=null and playlistName!=""<br>
	*@return a <code>string</code> specifying message, the message if the playlist has been created or not
	*/
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

	/**
	*<b>name:</b> createPlaylist <br>
	*This method can create a restricted playlist<br>
	*<b>post:</b> the playlist may have been created<br>
	*@param userNames Is the array of the name of users. Each name is different from the other. userNames!=null<br>
	*@param playlistName Is the name of the playlist. playlistName!=null and playlistName!=""<br>
	*@return a <code>string</code> specifying message, the message if the playlist has been created or not
	*/
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

	/**
	*<b>name:</b> addSongToPlaylist <br>
	*This method can add a song to a playlist<br>
	*<b>post:</b> the song may have been added to the playlist<br>
	*@param userName Is the name of the user. userName!=null and userName!=""<br>
	*@param playlistName Is the name of the playlist. playlistName!=null and playlistName!=""<br>
	*@param songName Is the title of the song. songTitle!=null and songTitle!=""<br>
	*@return a <code>string</code> specifying message, the message if the song has been added or not
	*/
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

	/**
	*<b>name:</b> ratePlaylist <br>
	*This method can rate a restricted playlist<br>
	*<b>post:</b> the playlist may have been rated<br>
	*@param userName Is the name of the user. userName!=null and userName!=""<br>
	*@param playlistName Is the name of the playlist. playlistName!=null and playlistName!=""<br>
	*@param rate Is the rating given by the user. rate!=null, rate greater than 0 and rate less than 6<br>
	*@return a <code>string</code> specifying message, the message if the playlist has been rated or not
	*/
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

	/**
	*<b>name:</b> showPlaylists <br>
	*This method shows the playlists that have been created<br>
	*<b>post:</b> the playlists have been shown<br>
	*@return a <code>string</code> specifying playlistx, the list of created playlists
	*/
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