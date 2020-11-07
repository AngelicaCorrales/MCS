package model;

public class Song{
	//relationships
	private Genre genre;

	//attributes
	private String title;
	private String artist;
	private String releaseDate;
	private int[] duration;

	/**
	*<b>name:</b> Song <br>
	*This is the constructor of the class <br>
	*<b>post:</b> the relationships and attributes of the class have been initialized <br>
	*@param title Is title of the song. title!=null and title!=""<br>
	*@param artist Is the artist of the song. artist!=null and artist!=""<br>
	*@param releaseDate Is the release date of the song. releaseDate!=null and releaseDate!=""<br>
	*@param duration Is the array of the duration of the song. duration!=null<br>
	*@param genre Is the genre of the song. genre!=null and genre!=""<br>
	*/
	public Song(String title, String artist, String releaseDate, int[] duration, String genre){
		this.title=title;
		this.artist=artist;
		this.releaseDate=releaseDate;
		this.duration=duration;
		this.genre=Genre.valueOf(genre);

	}//end constructor

	/**
	*<b>name:</b> getTitle <br>
	*This method gets the title of the song <br>
	*<b>post:</b> the title of the song has been gotten <br>
	*@return a <code>string</code> specifying title, the title of the song 
	*/
	public String getTitle(){
		return title;
	}//end

	/**
	*<b>name:</b> setTitle<br>
	*This method sets the title of the song <br>
	*<b>post:</b> the title of the song has been set <br>
	*@param title Is the title of the song. title!=null and title!=""<br>
	*/
	public void setTitle(String title){
		this.title=title;
	}//end

	/**
	*<b>name:</b> getArtist <br>
	*This method gets the artist of the song <br>
	*<b>post:</b> the artist of the song has been gotten <br>
	*@return a <code>string</code> specifying artist, the artist of the song 
	*/
	public String getArtist(){
		return artist;
	}//end

	/**
	*<b>name:</b> setArtist<br>
	*This method sets the artist of the song <br>
	*<b>post:</b> the title of the song has been set <br>
	*@param artist Is the artist of the song. artist!=null and artist!=""<br>
	*/
	public void setArtist(String artist){
		this.artist=artist;
	}//end

	/**
	*<b>name:</b> getReleaseDate <br>
	*This method gets the release date of the song <br>
	*<b>post:</b> the release date of the song has been gotten <br>
	*@return a <code>string</code> specifying releaseDate, the release date of the song 
	*/
	public String getReleaseDate(){
		return releaseDate;
	}//end

	/**
	*<b>name:</b> setReleaseDate<br>
	*This method sets the release date of the song <br>
	*<b>post:</b> the release date of the song has been set <br>
	*@param releaseDate Is the release date of the song. releaseDate!=null and releaseDate!=""<br>
	*/
	public void setReleaseDate(String releaseDate){
		this.releaseDate=releaseDate;
	}//end

	/**
	*<b>name:</b> getDuration <br>
	*This method gets the array of the duration of the song <br>
	*<b>post:</b> the duration of the song has been gotten <br>
	*@return an array of <code>integer</code> specifying duration, the duration of the song 
	*/
	public int[] getDuration(){
		return duration;
	}//end

	/**
	*<b>name:</b> setDuration<br>
	*This method sets the duration of the song <br>
	*<b>post:</b> the duration of the song has been set <br>
	*@param duration Is the array of theduration of the song. duration!=null<br>
	*/
	public void setDuration(int[] duration){
		this.duration=duration;
	}//end

	/**
	*<b>name:</b> getGenre <br>
	*This method gets the genre of the song <br>
	*<b>post:</b> the genre of the song has been gotten <br>
	*@return a <code>Genre</code> specifying genre, the genre of the song 
	*/
	public Genre getGenre(){
		return genre;
	}//end

	/**
	*<b>name:</b> setGenre<br>
	*This method sets the genre of the song <br>
	*<b>post:</b> the genre of the song has been set <br>
	*@param genre Is the genre of the song. genre!=null <br>
	*/
	public void setGenre(Genre genre){
		this.genre=genre;
	}//end


	/**
	*<b>name:</b> durationToString <br>
	*This method turns the durartion of the song to a string<br>
	*<b>post:</b> the duration has been turned to string<br>
	*@return a <code>string</code> specifying time, the duration of the song turned to string 
	*/
	public String durationToString(){
		String time;
		if(duration[1]<10){
			time=duration[0]+":0"+duration[1]; 
		}
		else{
			time=duration[0]+":"+duration[1];
		}

		
		return time;
	}//end durationToString


	/**
	*<b>name:</b> genreToString <br>
	*This method turns the genre to a string<br>
	*<b>post:</b> the genre has been turned to string<br>
	*@return a <code>string</code> specifying genrex, the genre of the song turned to string 
	*/
	public String genreToString(){
		String genrex;
		genrex=genre.name();
		return genrex;
	}//end genreToString

}//end class