package ui;
import java.util.Scanner;
import model.MCS;
public class Main{

	private MCS mcs;
	private Scanner sc;

	public Main(){
		sc= new Scanner(System.in);
		createMCS();
	}

	public static void main(String [] args){
		Main objMain= new Main();
		int option;
		do{
			option=objMain.showMenu();
			objMain.chosenOption(option);
		}while(option!=7);
		
	}

	public int showMenu(){
		System.out.println("Seleccione una opcion:\n"+
				"(1) Registrar usuario\n"+
				"(2) Mostrar usuarios registrados \n"+
				"(3) Compartir cancion\n"+
				"(4) Mostrar canciones en el pool de canciones compartidas \n"+
				"(5) Crear playlist\n"+
				"(6) Mostrar playlists creadas \n"+
				"(7) Salir");
		int option= sc.nextInt();
		return option;
	}

	
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
			do{
				createPlaylist(showMenuPlaylists());
			}while(showMenuPlaylists()!=1 && showMenuPlaylists()!=2 && showMenuPlaylists()!=3);
			break;
		case 6:
			showPlaylists();
			break;

		case 7:
			System.out.println("\nHasta la proxima!");
			break;
			
		default:
			System.out.println("\n Error, opcion no valida \n");
		
		}
	}

	public void registerUser(){
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("REGISTRAR USUARIO \n");
		String userName;
		boolean control;
		do{
			System.out.println("Ingrese el nombre de usuario, sin espacios");
			userName=sc.nextLine().toLowerCase();
			control=false;			
			for(int i=0; i<name.length && !control; i++){
				if(name.charAt(i)==' '){
					System.out.println("Error. No puede usar espacios");
					control=true;
				}
			}
		}while(control);
		
		System.out.println("\nIngrese la contraseña");
		String password=sc.nextLine();

		System.out.println("\nIngrese su edad");
		int age=sc.nextInt();

		message=mcs.createUser(userName, password, age);
		System.out.println("-----------------------------------------------------------");

		System.out.println(message);
		System.out.println("-----------------------------------------------------------");



	}
	public void showRegisteredUsers(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR USUARIOS REGISTRADOS \n");
        String list=mcs.showUsers();
        System.out.println(list);
        System.out.println("-----------------------------------------------------------");

	}

	public void shareSong(){
		sc.nextLine();
		String message;
		int[] duration= new int[2];
		System.out.println("-----------------------------------------------------------");
		System.out.println("COMPARTIR CANCION \n");
		System.out.println("Ingrese el nombre de usuario");
		String userName=sc.nextLine().toLowerCase();
		boolean verify=verifyUser(userName);
		if(verify){
			System.out.println("\nIngrese titulo de la cancion");
			String title=sc.nextLine();

			System.out.println("\nIngrese nombre del artista");
			String artist=sc.nextLine();

			System.out.println("\nFECHA DE LANZAMIENTO (primero el dia, luego mes, por ultimo anio");
			System.out.println("\nIngrese el dia");
			int day=sc.nextInt();

			System.out.println("\nIngrese el mes (en formato numerico)");
			int month=sc.nextInt();

			System.out.println("\nIngrese el anio");
			int year=sc.nextInt();

			String date=day+"/"+month+"/"+year;

			System.out.println("\nDURACION DE LA CANCION (primero ingrese los minutos, luego los segundos)");
			System.out.println("\nIngrese los minutos");
			int min=sc.nextInt();
			duration[0]=min;
			System.out.println("\nIngrese los segundos");
			int seg=sc.nextInt();
			duration[1]=seg;

			sc.nextLine();
			String genre;
			boolean control;
			do{
				System.out.println("\nIngrese el genero de la cancion (ROCK, HIPHOP, CLASICA, REGGAE, SALSA, METAL)");
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


		}
		else{
			System.out.println("-----------------------------------------------------------");
			System.out.println("El usuario no esta registrado.");
		}
		System.out.println("-----------------------------------------------------------");


	}

	public void showSongs(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("MOSTRAR CANCIONES EN EL POOL DE CANCIONES COMPARTIDAS \n");
        String list=mcs.showUsers();
        System.out.println(list);
        System.out.println("-----------------------------------------------------------");

	}

	public int showMenuPlaylists(){
		System.out.println("Seleccione la playlist que desea crear:\n"+
				"(1) Privada\n"+
				"(2) Restringida \n"+
				"(3) Publica");
		int option= sc.nextInt();
		return option;
	}

	public void createPlaylist(int op){
		switch(op){
			case 1:
				createPrivatePlaylist();
				break;
			case 2:
				createRestrictedPlaylist();
				break;
			case 3:
				createPublicPlaylist();
				break;
			default:
			System.out.println("\n Error, opcion no valida \n");
		
		}
	}

	public void createPrivatePlaylist(){

	}

	public void createRestrictedPlaylist(){

	}

	public void createPublicPlaylist(){

	}

	public void showPlaylists(){

	}


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
	}

}