package ui;
import java.util.Scanner;
import model.MCS;
public class Main{
	//relashionship
	private MCS mcs;
	private Scanner sc;

	public Main(){
		sc= new Scanner(System.in);
		createMCS();
	}//end constructor

	public static void main(String [] args){
		Main objMain= new Main();
		int option;
		do{
			option=objMain.showMenu();
			objMain.chosenOption(option);
		}while(option!=9);
		
	}// end main

	public int showMenu(){
		System.out.println("Seleccione una opcion:\n"+
				"(1) Registrar usuario\n"+
				"(2) Mostrar usuarios registrados \n"+
				"(3) Compartir cancion\n"+
				"(4) Mostrar canciones en el pool de canciones compartidas \n"+
				"(5) Crear playlist\n"+
				"(6) Agregar cancion a una playlist\n"+
				"(7) Calificar una playlist publica \n"+
				"(8) Mostrar playlists creadas \n"+
				"(9) Salir");
		int option= sc.nextInt();
		return option;
	}//end showMenu

	
	public void chosenOption(int op) {
		
		switch(op) {
		case 1:
			registerUser();
			break;
		case 2:
			showRegisteredUsers();
			break;
		case 3:
			shareSong();
			break;
		case 4:
			showSongs();
			break;
		case 5:
			createPlaylist();
			break;
		case 6:
			addSongToPlaylist();
			break;
		case 7:
			ratePlaylist();
			break;
		case 8:
			showPlaylists();
			break;

		case 9:
			System.out.println("\nHasta la proxima!");
			break;
			
		default:
			System.out.println("\n Error, opcion no valida \n");
		
		}
	}//end chosenOption

	public void registerUser(){
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("REGISTRAR USUARIO \n");
		String userName;
		int age;
		boolean control;
		do{
			System.out.println("Ingrese el nombre de usuario, sin espacios");
			userName=sc.nextLine().toLowerCase();
			control=false;			
			for(int i=0; i<userName.length() && !control; i++){
				if(userName.charAt(i)==' '){
					System.out.println("Error. No puede usar espacios");
					control=true;
				}
			}
		}while(control);
		
		System.out.println("\nIngrese la contrasenia");
		String password=sc.nextLine();
		
		do{
			System.out.println("\nIngrese su edad");
			age=sc.nextInt();
			if(age<1 ||age>130){
				System.out.println("\n No valido ._.");
			}
		}while(age<1 ||age>130);

		String message=mcs.createUser(userName, password, age);
		System.out.println("-----------------------------------------------------------");

		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}// end registerUser

	public void showRegisteredUsers(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR USUARIOS REGISTRADOS \n");
        String list=mcs.showUsers();
        System.out.println(list);
        System.out.println("-----------------------------------------------------------");

	}//end showRegisteredUsers

	public void shareSong(){
		sc.nextLine();
		String message;
		int day;
		int month;
		int year;
		String genre;
		int[] duration= new int[2];
		System.out.println("-----------------------------------------------------------");
		System.out.println("COMPARTIR CANCION \n");
		System.out.println("Ingrese el nombre de usuario");
		String userName=sc.nextLine().toLowerCase();
		
		System.out.println("\nIngrese titulo de la cancion");
		String title=sc.nextLine();

		System.out.println("\nIngrese nombre del artista");
		String artist=sc.nextLine();
		
		System.out.println("\nFECHA DE LANZAMIENTO (primero el dia, luego mes, por ultimo anio");
		do{
			System.out.println("\nIngrese el dia");
			day=sc.nextInt();
			if(day<1 ||day>31){
				System.out.println("\n No valido ._.");
			}
		}while(day<1 ||day>31);

		
		do{
			System.out.println("\nIngrese el mes (en formato numerico)");
			month=sc.nextInt();
			if(month<1 ||month>12){
				System.out.println("\n No valido ._.");
			}
		}while(month<1 ||month>12);

		
		do{
			System.out.println("\nIngrese el anio");
			year=sc.nextInt();
			if(year<1860 ||year>2020){
				System.out.println("\n No valido ._.");
			}
		}while(year<1860 ||year>2020);

		String date=day+"/"+month+"/"+year;

		System.out.println("\nDURACION DE LA CANCION (primero ingrese los minutos, luego los segundos)");
		do{
			System.out.println("\nIngrese los minutos");
			duration[0]=sc.nextInt();
			if(duration[0]<0){
				System.out.println("\n No valido ._.");
			}
		}while(duration[0]<0);
		
		do{
			System.out.println("\nIngrese los segundos");
			duration[1]=sc.nextInt();
			if(duration[1]<0 || duration[1]>59){
				System.out.println("\n No valido ._.");
			}
		}while(duration[1]<0 || duration[1]>59);
		

		sc.nextLine();
		
		boolean control;
		do{
			System.out.println("\n \nIngrese el genero de la cancion (ROCK, HIPHOP, CLASICA, REGGAE, SALSA, METAL)");
			genre=sc.nextLine().toUpperCase();

			if(genre.equals("ROCK")|| genre.equals("HIPHOP")||genre.equals("CLASICA")||genre.equals("REGGAE")|| genre.equals("SALSA")||genre.equals("METAL")){
				control=false;
			}
			else{
				control=true;
				System.out.println("Genero no valido. Ingrese nuevamente");
			}
		}while(control);


		message=mcs.addSong(userName, title, artist, date, duration, genre);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");


	}//end createSong

	public void showSongs(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR CANCIONES EN EL POOL DE CANCIONES COMPARTIDAS \n");
        String list=mcs.showPoolSongs();
        System.out.println(list);
        System.out.println("-----------------------------------------------------------");

	}//end showSongs
	

	public void createPlaylist(){
		
		String message="";
		int option;
		boolean error;
		String playName;
		System.out.println("-----------------------------------------------------------");
		System.out.println("CREAR PLAYLIST\n");

		do{
			error=false;
			System.out.println("Seleccione la playlist que desea crear:\n"+
				"(1) Privada\n"+
				"(2) Restringida \n"+
				"(3) Publica");
			option= sc.nextInt();
								
			
			switch(option){
				case 1:
				case 3:
					sc.nextLine();
					System.out.println("\nIngrese el nombre de usuario");
					String userName=sc.nextLine().toLowerCase();
					
					
					System.out.println("\nIngrese el nombre de la playlist");
					playName=sc.nextLine();
					if(option==1){
						message=mcs.createPlaylist(userName, playName, option);
					}
					else{
						message=mcs.createPlaylist(userName, playName);
					}
					
					break;

				case 2:
					int numUsers;
					do{
						System.out.println("\nIngrese el numero de usuarios que van a colaborar en la playlist. MAX 5 usuarios");
						numUsers=sc.nextInt();
					}while(numUsers<1 ||numUsers>5);

					String[] userNames= new String[numUsers];
					

					sc.nextLine();
					for(int i=0; i<userNames.length; i++){
						System.out.println("Ingrese el nombre de usuario "+(i+1));
						userNames[i]=sc.nextLine().toLowerCase();
												
					}
						System.out.println("\nIngrese el nombre de la playlist");
						playName=sc.nextLine();
						message=mcs.createPlaylist(userNames, playName);
					
					break;
				
				default:
				System.out.println("\n Error, opcion no valida \n");
				error=true;
			
			}
		}while(error);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}//end createPlaylist
		
	public void addSongToPlaylist(){
		sc.nextLine();
		String message;
		System.out.println("-----------------------------------------------------------");
		System.out.println("AGREGAR CANCION A UNA PLAYLIST \n");
		if (mcs.getPlaylists()[0]==null){
			System.out.println("Aun no se han creado playlists");
		}
		else{
			System.out.println("Ingrese el nombre de usuario");
			String userName=sc.nextLine().toLowerCase();
			System.out.println("\nIngrese el nombre de la playlist");
			String playlistName=sc.nextLine();
			System.out.println("\nIngrese el nombre de la cancion");
			String songName=sc.nextLine();
			message=mcs.addSongToPlaylist(userName, playlistName, songName);
			System.out.println("-----------------------------------------------------------");
			System.out.println(message);
		}

		
		System.out.println("-----------------------------------------------------------");

	
	}//end addSongToPlaylist

	public void ratePlaylist(){
		sc.nextLine();
		String message;
		int rate;
		System.out.println("-----------------------------------------------------------");
		System.out.println("CALIFICAR UNA PLAYLIST PUBLICA \n");
		if(mcs.getPlaylists()[0]==null){
			System.out.println("Aun no se han creado playlists");
		}
		else{
			System.out.println("Ingrese el nombre de usuario");
			String userName=sc.nextLine().toLowerCase();
			System.out.println("\nIngrese el nombre de la playlist");
			String playlistName=sc.nextLine();
			
			do{
				System.out.println("\nIngrese la calificacion de la playlist (1 la nota mas baja, 5 la nota mas alta)");
				rate=sc.nextInt();
			}while(rate<1 ||rate>5);
			message=mcs.ratePlaylist(userName, playlistName, rate);

			System.out.println("-----------------------------------------------------------");
			System.out.println(message);
		}

		System.out.println("-----------------------------------------------------------");

	}//end ratePlaylist
	
	public void showPlaylists(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR PLAYLISTS CREADAS \n");
        String list=mcs.showPlaylists();
        System.out.println(list);
        System.out.println("-----------------------------------------------------------");
	}//end showPlaylist
	

	public void createMCS(){
		System.out.println(""+

			"((((((((((((((((((((((((((((((((((((((((((((((((( \n"+
			"((((((((((((((((/(((((((((((((((((((((((((((((((( \n"+
			"(((/  .(((((((*  .((((((*        (((((/      /((( \n"+
			"(((/   .((((((.  .(((((   ,((((((((((*  .(((((((( \n"+
			"(((/    /((((/   .((((/  ,(((((((((((.  /(((((((( \n"+
			"(((/     ((((*   .((((*  ,(((((((((((/   (((((((( \n"+
			"(((/  *  *(((     ((((*  ,((((((((((((,  .((((((( \n"+
			"(((/  /.  ((*     ((((*  *(((((((((((((,   (((((( \n"+
			"(((/  //  ,(  .   ((((*  *((((((((((((((/   /(((( \n"+
			"(((/  *(*  ,  (   ((((*  *((((((((((((((((   /((( \n"+
			"(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   ((( \n"+
			"(((/  .((    ((   /((((  .(((((((((((((((((.  /(( \n"+
			"(((/  .((.  .((.  *((((,  *((((((((((((((((   /(( \n"+
			"(((/  .((((((((.  *(((((   *((((/,/(((((((/   ((( \n"+
			"(((/  .((((((((.  *((((((.        *((   .   .(((( \n"+
			"(((((((((((((((/*/((((((((((///(((((((////((((((( \n"+
			"((((((((((((((((((((((((((((((((((((((((((((((((( \n"+
			"               ./(###((///((###(*                 \n"+
			"           *#(,                   *((,            \n"+
			"        ,#/                           ((          \n"+
			"      .#*          .**/////*,.          ((        \n"+
			"     *(.      .//////////////////*       *#       \n"+
			"    .#,     *///////////////////////,     /(      \n"+
			"    /(    *///////////////////////////    .#.     \n"+
			"  ,/////,*/////////////////////////////,*////*.   \n"+
			"  /////////////////////////*,...,/////////////,   \n"+
			"  //////*,,,********,,.............,,,,,//////,   \n"+
			"  //////*.........//*........//*.......,//////,   \n"+
			"  //////*.........,,.........,,........,//////,   \n"+
			"  //////*..............................,//////,   \n"+
			"   *///*  ........,/.........**.......  .*///,    \n"+
			"            .......,/*.....,/*.......             \n"+
			"               ........,,,,.......                \n"+
			"                    .........                     \n"+
			"      \n"+
			"************************************************* \n");

		mcs=new MCS();
	}//end createMCS

}//end class