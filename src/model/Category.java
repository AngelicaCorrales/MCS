package model;

/**
*<b>name:</b> Category <br>
*This is the enumeration that represents the group of constants of category<br>
*/
public enum Category{
	/**
	**A user is NEWBIE when he/she is newly created and until shares three songs
	*/
	NEWBIE,
	/**
	**From three shared songs, a user becomes LITTLE_CONTRIBUTOR until he/she shares ten songs
	*/
	LITTLE_CONTRIBUTOR,
	/**
	**When a user shares ten songs he/she becomes MILD_CONTRIBUTOR and keeps this category until he/she shares 30 songs
	*/
	MILD_CONTRIBUTOR,
	/**
	**From the 30 shared songs, the user is STAR_CONTRIBUTOR
	*/
	 STAR_CONTRIBUTOR;
}