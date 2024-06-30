import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class Date {

	String day() {
		LocalDate date = LocalDate.now(); 
		String formattedDate = date.format(DateTimeFormatter.ofPattern("YYYY년MM월dd일"));
		return formattedDate;
	}
	
	String time() {
		LocalTime time = LocalTime.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시mm분ss초");
		String formattedTime = time.format(formatter);
		return formattedTime;
	}
	
	


}
