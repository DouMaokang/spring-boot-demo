//import java.sql.Time;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Date;
//
//public class Draft {
//    public static void main(String[] args) {
//        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss");
//        String dateStr1 = "15/03/2020 09:30:00";
//        String dateStr2 = "15/03/2020 13:30:00";
//
//        Date date1, date2;
//
//        try {
//            date1 = ft.parse(dateStr1);
//            date2 = ft.parse(dateStr2);
//
//            Instant inst1 = date1.toInstant();
//            Instant inst2 = date2.toInstant();
//            // Instant duration = inst1.until(inst2, ChronoUnit.DAYS);
//
//            System.out.println(inst1);
//            System.out.println(inst2);
//
//        } catch (ParseException e) {
//            System.out.println("Unparseable using " + ft);
//        }
//
//
//
//    }
//}
