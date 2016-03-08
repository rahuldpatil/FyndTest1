package common;

import java.util.Date;

public class RandomData {
	
	public static Date date = new Date();
	public static String rndmstrng;
	public static String RandomString()
	{		
		rndmstrng = date.toString();
		rndmstrng = rndmstrng.replace(":","");
		rndmstrng = rndmstrng.replace(" ","");
		return rndmstrng; 
	}

}
