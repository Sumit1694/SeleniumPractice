package temp;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {
		
		Date date=new Date();
		String dateString=date.toString().replaceAll(" ", "").replaceAll(":", "")+"@gmail.com";
		System.out.println(dateString);
		
		
		
	}
	
}
