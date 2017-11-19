package calendar;


import java.util.Calendar;


public class Calendar2 {
	int[] monthday ={31,28,31,30,31,30,31,31,30,31,30,31};
	Calendar cal =Calendar.getInstance();
	int fristofweek;
	int dayofmonth;
	int dayofweek;
	
	public void setdate(int year,int month,int day)
	{
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month+1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		fristofweek = cal.get(Calendar.DAY_OF_WEEK);
		dayofmonth = monthday[month-1];
	}
	
	
}
