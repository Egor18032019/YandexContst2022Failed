import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NewHistoryLong {
    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        Long firstDate = giveMeDateAsLong(firstLine);
        String[] secondLine = reader.readLine().split(" ");
        Long secondDate = giveMeDateAsLong(secondLine);
     /*
     1514912244
     661713335
      */
        long difference_In_Time = Math.subtractExact(secondDate, firstDate);

        final long SECONDS_PER_DAY = 86400;
        long difference_In_Days = (difference_In_Time / SECONDS_PER_DAY); // -2 начало и конец;

        System.out.println(difference_In_Days);
        //также количество секунд в неполном дне.
        Long foo = Long.sum(firstDate, ((difference_In_Days) * 60 * 60 * 24));
        long difference_In_Time2 = Math.subtractExact(secondDate, foo);

        long difference_In_Sec = (difference_In_Time2);
        System.out.println(difference_In_Sec);
    }

    /*
1001 5 20 14 15 16
9009 9 11 12 21 11
2923033 79555
2923028 79555
     */
    public static Long giveMeDateAsLong(String[] line) {
        int year = Integer.parseInt(line[0]);

        long yearsAsLong = 1L * year * 365 * 24 * 60 * 60;// дни*часы*минуты*секундны

        int month = Integer.parseInt(line[1]);
        long monthAsLong = 1L * getDaysOfMonths(month) * 24 * 60 * 60;// дни*часы*минуты*секундны

        int day = Integer.parseInt(line[2]);
        long dayAsLong = 1L * day * 24 * 60 * 60;//  часы*минуты*секундны

        int hour = Integer.parseInt(line[3]);
        long hourAsLong = hour * 60 * 60;//   минуты*секундны

        int minute = Integer.parseInt(line[4]);
        long minuteAsLong = minute * 60;//    *секундны

        int sec = Integer.parseInt(line[5]);
        long secAsLong = sec;//

        Long lineDate = yearsAsLong + monthAsLong + dayAsLong + hourAsLong + minuteAsLong + secAsLong;

        return lineDate;
    }

    private static int getDaysOfMonths(long months) {
        Map<Long, Integer> fullMonths = new HashMap<>();
        fullMonths.put(1L, 0);
        fullMonths.put(2L, 31);
        fullMonths.put(3L, 59);
        fullMonths.put(4L, 90);
        fullMonths.put(5L, 120);
        fullMonths.put(6L, 151);
        fullMonths.put(7L, 181);
        fullMonths.put(8L, 212);
        fullMonths.put(9L, 243);
        fullMonths.put(10L, 273);
        fullMonths.put(11L, 304);
        fullMonths.put(12L, 334);
        return fullMonths.get(months);
    }
}
/*
1502764928-10368000-1728000 50400:900: 16
639982464 -20736000-950400  43200:1260:11
 Сейчас активно развивается новая история, основателем которой является Профессор А.С. Багиров. Он выяснил, что на протяжении многих лет на земле вместе с людьми существовали ящеры. Строительство пирамид, захват Байкала и еще много разных событий произошли благодаря ящерам.

Учёные ещё не выяснили, сколько времени ящеры существовали на земле. Они находят разные данные в виде даты начала и даты окончания, и чтобы проверить их на корректность, необходимо посчитать, сколько дней ящеры существовали для двух конкретных дат. Календарь ящеров очень похож на григорианский, лишь с тем исключением, что там нет високосных годов.

Вам даны дата начала и дата окончания существования ящеров, нужно найти количество полных дней и секунд в неполном дне, чтобы учёные смогли оценить, насколько даты корректны.

Формат ввода
В первой строке содержатся 6 целых чисел year1,month1,day1,hour1,min1,sec1(1≤year1≤9999,1≤month1≤12,1≤day1≤31,0≤hour1≤23,0≤min1≤59,0≤sec1≤59)- дата начала существования ящеров.

Во второй строке содержатся 6 целых чисел year2,month2,day2,hour2,min2,sec2(1≤year2≤9999,1≤month2≤12,1≤day2≤31,0≤hour2≤23,0≤min2≤59,0≤sec2≤59)- дата окончания существования ящеров.

Гарантируется, что дата начала меньше,чем дата конца.

Формат вывода
В первой и единственной строке выведите 2 числа: количество дней, сколько существовали ящеры, а также количество секунд в неполном дне.
Пример 1
Ввод
Вывод

980 2 12 10 30 1
980 3 1 10 31 37



17 96

Пример 2
Ввод
Вывод

1001 5 20 14 15 16
9009 9 11 12 21 11



2923033 79555

Примечания
В одном году 365 дней. Год делится на 12 месяцев, количество дней в каждом месяце: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]. В одном дне 24 часа (от 0 до 23), в одном часу 60 минут (от 0 до 59), в одной минуте 60 секунд (от 0 до 59).

В первом тестовом примере года совпадают, а между 12 февраля и 1 марта прошло 17 полных дней, начало было в 10:30:01, а конец в 10:31:37,таким образом прошла 1 минута и 36 секунд, что в сумме получается 96 секунд.

 */
