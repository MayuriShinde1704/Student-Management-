package constraints;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
	
	
	public static String getCurrentDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return formatter.format(dateTime);
	}
	

	public static String parseDateToDDMMYYYY(Date date) {
		String parsedate="";
		try {
		     SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		      parsedate=formatter.format(date);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parsedate;
	}
	
	
	public static int calculateAge(String date) {
		int age=0;
		try {
			LocalDate dob = LocalDate.parse(date);
			LocalDate dob1 = LocalDate.parse(DateTimeUtils.getCurrentDateTime());
			age= Period.between(dob,dob1).getYears();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return age;
	}
	
	public static void main(String[] args) {
		System.out.println(getCurrentDateTime());
		calculateAge("");
		
	}
}