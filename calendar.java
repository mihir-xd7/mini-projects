import java.util.Scanner;

public class calendarMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter year :: ");
        int year = input.nextInt();
        printYear(year);
        input.close();
    }
    public static void printYear(int year) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%16s%-5s%4d\n"," ","YEAR",year);
        
        System.out.print("Choose -----\n(0) full year calendar     |\n(1) calendar of one month  |\n(2) calendar in range      |  :: ");
        int check = sc.nextInt();
        int r1,r2;
        switch (check) {
            case 1: System.out.print("Enter month number: "); r1 = r2 = sc.nextInt(); break;
            case 2: System.out.print("Enter month to start: "); r1 = sc.nextInt();
                    System.out.print("Enter month till end: "); r2 = sc.nextInt(); break;
            default: r1=1; r2=12; break;
        }
        for (int m = r1; m <= r2; m++) {
            printMonth(year,m);
        }
        sc.close();
    }
    public static void printMonth(int year, int month) {
        printMonthTitle(year,month);
        printDashln();
        System.out.printf("%6s%6s%6s%6s%6s%6s%6s\n","Sun","Mon","Tue","Wed","Thu","Fri","Sat");
        printDashln();
        printCalendar(year,month);
        printDashln();
    }
    public static void printMonthTitle(int year, int month) {
        String monthName = "";
        switch (month) {
            case 1 : monthName = "January"; break;
            case 2 : monthName = "February"; break;
            case 3 : monthName = "March"; break;
            case 4 : monthName = "April"; break;
            case 5 : monthName = "May"; break;
            case 6 : monthName = "June"; break;
            case 7 : monthName = "July"; break;
            case 8 : monthName = "August"; break;
            case 9 : monthName = "September"; break;
            case 10 : monthName = "October"; break;
            case 11 : monthName = "November"; break;
            case 12 : monthName = "December"; break;
        }
        System.out.printf("%14s%-9s %4d%14s\n"," ",monthName,year," ");
    }
    public static void printCalendar(int year, int month) {
        int s = getStartDayOfMonth(year,month);
        int e = getTotalDaysOfMonth(year,month);
        int date = 1;
        for (int c = 0; c < 35; c++) {
            if (c >= s && c < s+e) {
                System.out.printf("%6d",date); 
                date++;
            } else if (c < s) System.out.printf("%6s"," ");
            if ((c+1)%7 == 0) System.out.println();
        }
    }
    public static int getStartDayOfMonth(int year,int month) {
        int days = getNumberOfDaysBeforeYear(year) % 7;
        for (int i=1; i < month; i++) {
            days += getTotalDaysOfMonth(year,i);
        }
        return days % 7;
    }
    public static int getNumberOfDaysBeforeYear(int year) {
        int day = 1;
        for (int i=1; i<year; i++) {
            if (isLeapYear(year)) day += 366;
            else day += 365;
        }
        return day;
    }
    public static int getTotalDaysOfMonth(int year, int month) {
        if (month==4 || month==6 || month==9 || month==11) return 30;
        else if (isLeapYear(year) && month==2) return 29;
        else if (!isLeapYear(year) && month==2) return 28;
        else return 31;
    }
    public static void printDashln() {
        for (int i=1; i<=42; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? true : false;
    }
}
