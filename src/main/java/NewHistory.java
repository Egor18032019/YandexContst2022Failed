//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.Period;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//import java.time.temporal.TemporalUnit;
//import java.util.Date;
//
//public class NewHistory {
//    private static BufferedReader reader = null;
//
//
//    public static void main(String[] args) throws Exception {
//        init();
//        run();
//    }
//
//    private static void init() {
//        reader = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//
//    private static void run() throws IOException, ParseException {
//        String[] firstLine = reader.readLine().split(" ");
//        LocalDate firstDate = giveMeFormatLocalDate(firstLine);
//        String[] secondLine = reader.readLine().split(" ");
//        LocalDate secondDate = giveMeFormatLocalDate(secondLine);
//
//        Long difDays = Math.abs(ChronoUnit.DAYS.between(firstDate, secondDate)) + 1;
//        Period p = Period.between(firstDate, secondDate);
//
//        System.out.println(p.getYears());
//        System.out.println(p.getDays());
//
//
//        Date d1 = giveMeFormatDate(firstLine);
//        Date d2 = giveMeFormatDate(secondLine);
//        long difference_In_Time = d2.getTime() - d1.getTime();
//        long d = Math.subtractExact(d2.getTime(), d1.getTime());
//        System.out.println(difference_In_Time);
//        System.out.println(d);
//        long downDays = 1000L * 60 * 60 * 24;
//        long difference_In_Days
//                = (difference_In_Time
//                / downDays)
//                % 365;
//        long difference_In_Seconds
//                = (difference_In_Time
//                / 1000)
//                % 60;
//        long difference_In_Minutes
//                = (difference_In_Time
//                / (1000 * 60))
//                % 60;
//        long difference_In_Hours
//                = (difference_In_Time
//                / (1000 * 60 * 60))
//                % 24;
//        long down = 1000L * 60 * 60 * 24 * 365;
//        long difference_In_Years =
////                Math.abs(ChronoUnit.YEARS.between(firstDate, secondDate)) + 1;
//                p.getYears(); //8008
////                 (difference_In_Time /down);//8013
////        2923143 79555
//
////        2924968 79555
////        2923033 79555
//
//        System.out.println(difference_In_Years);
//        System.out.println(difference_In_Days);
//        System.out.println("difDays " + difDays);
//        System.out.println(difference_In_Seconds);
//        System.out.println(difference_In_Minutes);
//        System.out.println(difference_In_Hours);
//        long seconds = difference_In_Seconds + difference_In_Minutes * 60 + difference_In_Hours * 60 * 60;
//        if (seconds > 0) {
//            System.out.println((difference_In_Years) * 365 + difference_In_Days - 1 + " " + seconds);
//        } else {
//            System.out.println((difference_In_Years) * 365 + difference_In_Days + " " + seconds);
//        }
//    }
//
//    /*
//1001 5 20 14 15 16
//9009 9 11 12 21 11
//
//     */
//    public static LocalDate giveMeFormatLocalDate(String[] line) {
//        String year = line[0];
//        if (year.length() < 4) year = "0" + year;
//        String month = line[1];
//        if (month.length() < 2) month = "0" + month;
//        String day = line[2];
//        if (day.length() < 2) day = "0" + day;
//        String hour = line[3];
//        if (hour.length() < 2) hour = "0" + hour;
//        String minute = line[4];
//        if (minute.length() < 2) minute = "0" + minute;
//        String sec = line[5];
//        if (sec.length() < 2) sec = "0" + sec;
//        String lineDate = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + sec;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDate date = LocalDate.parse(lineDate, formatter);
//        return date;
//    }
//
//    public static Long giveMeFormatDate(String[] line) throws ParseException {
//        int year = Integer.parseInt(line[0]);
//        long yearsAsLong = year * 1000L * 365 * 24 * 60 * 60;// дни*часы*минуты*секундны
//
//
//        int month = Integer.parseInt(line[1]);
//        long monthAsLong = year * 1000L * 30 * 24 * 60 * 60;// дни*часы*минуты*секундны
//
//
//        int day = Integer.parseInt(line[2]);
//        long dayAsLong = year * 1000L * 24 * 60 * 60;//  часы*минуты*секундны
//
//        long dayAsLong = year * 1000L * 24 * 60 * 60;//  часы*минуты*секундны
//        if (day.length() < 2) day = "0" + day;
//        String hour = line[3];
//        if (hour.length() < 2) hour = "0" + hour;
//        String minute = line[4];
//        if (minute.length() < 2) minute = "0" + minute;
//        String sec = line[5];
//        if (sec.length() < 2) sec = "0" + sec;
//        String lineDate = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + sec;
//        System.out.println(lineDate);
//
//        return d;
//    }
//}
///*
// Сейчас активно развивается новая история, основателем которой является Профессор А.С. Багиров. Он выяснил, что на протяжении многих лет на земле вместе с людьми существовали ящеры. Строительство пирамид, захват Байкала и еще много разных событий произошли благодаря ящерам.
//
//Учёные ещё не выяснили, сколько времени ящеры существовали на земле. Они находят разные данные в виде даты начала и даты окончания, и чтобы проверить их на корректность, необходимо посчитать, сколько дней ящеры существовали для двух конкретных дат. Календарь ящеров очень похож на григорианский, лишь с тем исключением, что там нет високосных годов.
//
//Вам даны дата начала и дата окончания существования ящеров, нужно найти количество полных дней и секунд в неполном дне, чтобы учёные смогли оценить, насколько даты корректны.
//
//Формат ввода
//В первой строке содержатся 6 целых чисел year1,month1,day1,hour1,min1,sec1(1≤year1≤9999,1≤month1≤12,1≤day1≤31,0≤hour1≤23,0≤min1≤59,0≤sec1≤59)- дата начала существования ящеров.
//
//Во второй строке содержатся 6 целых чисел year2,month2,day2,hour2,min2,sec2(1≤year2≤9999,1≤month2≤12,1≤day2≤31,0≤hour2≤23,0≤min2≤59,0≤sec2≤59)- дата окончания существования ящеров.
//
//Гарантируется, что дата начала меньше,чем дата конца.
//
//Формат вывода
//В первой и единственной строке выведите 2 числа: количество дней, сколько существовали ящеры, а также количество секунд в неполном дне.
//Пример 1
//Ввод
//Вывод
//
//980 2 12 10 30 1
//980 3 1 10 31 37
//
//
//
//17 96
//
//Пример 2
//Ввод
//Вывод
//
//1001 5 20 14 15 16
//9009 9 11 12 21 11
//
//
//
//2923033 79555
//
//Примечания
//В одном году 365 дней. Год делится на 12 месяцев, количество дней в каждом месяце: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]. В одном дне 24 часа (от 0 до 23), в одном часу 60 минут (от 0 до 59), в одной минуте 60 секунд (от 0 до 59).
//
//В первом тестовом примере года совпадают, а между 12 февраля и 1 марта прошло 17 полных дней, начало было в 10:30:01, а конец в 10:31:37,таким образом прошла 1 минута и 36 секунд, что в сумме получается 96 секунд.
//
// */
