import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DisplayCalendar {

	public static void main(String[] args) {
		int year = 0;
		int month = 0;
		String[] monthString = {"January", "Febuary", "March", "April",
				"May", "June", "July", "August", "September", "October",
				"Novenber", "December"};

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the month (1 to 12): ");
		month = sc.nextInt();
		System.out.println();

		System.out.print("Enter the year: ");
		year = sc.nextInt();
		System.out.println();
		int day, weekdayCount = 1;


		Calendar cal = new GregorianCalendar();

		// set its date to the first day of the month/year given by user
		cal.clear();
		cal.set(year, month - 1, 1);

		// obtain the weekday of the first day of month.
		// return 1 to 7 => sun. to sat.
		int firstWeekdayOfMonth = cal.get(Calendar.DAY_OF_WEEK);

		// obtain the number of days in month.
		int numberOfMonthDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// print calendar month, year header
		System.out.println("\t" + monthString[month-1] + "  "+ year);
		System.out.println();

		// print calendar weekday header
		System.out.println("\tSun\tMon\tTue\tWed\tThu\tFri\tSat");

		// leave/skip weekdays before the first day of month
		for (day = 1; day < firstWeekdayOfMonth; day++) 
		{
			System.out.print("\t");
			++weekdayCount;
		}

		for (int i = 1; i <= numberOfMonthDays; i++)
		{
			if (weekdayCount <= 7)
			{
				System.out.printf("\t%d", i);
				++weekdayCount;
			}
			else
			{
				System.out.println();
				System.out.printf("\t%d", i);
				weekdayCount = 2;

			}

		}

		sc.close();

	}

}
