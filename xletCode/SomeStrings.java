package irdeto;

import java.util.Calendar;
import java.util.Date;

public class SomeStrings {
    public Streams stream1 = Streams.IMW_PDC_LAB_TS3_Parental_Control_v1_3;

    public static void main(String[] args) {
        new SomeStrings().doStuff();
    }

    public void doStuff() {
        Date d = stream1.getStartDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Streams.IMW_PDC_LAB_TS3_Parental_Control_v1_3.getStartDate());
        long SECONDS_OFFSET = calendar.get(Calendar.SECOND);
        System.out.println(SECONDS_OFFSET);
    }
}
