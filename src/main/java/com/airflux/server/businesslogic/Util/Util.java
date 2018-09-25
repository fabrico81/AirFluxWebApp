package com.airflux.server.businesslogic.Util;

import java.time.*;
import java.util.IllegalFormatException;

public final class Util {


    public static ZonedDateTime getZonedDateTime(String hour, String minute) {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(Integer.valueOf(hour), Integer.valueOf(minute)));
        return ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Berlin"));
    }

    public static String[] getTimeSplit(String time) throws Exception{
        try{
            if(time != null && !time.isEmpty()){
                String departureTime = time;
                return departureTime.split(":");
            }else {
                return null;
            }

        }catch (IllegalFormatException ex){
           throw ex;
        }
    }

    public static String getHour(String[] hour){
        if(hour != null && hour.length != 0)
            return hour[0];
        else{
            return null;
        }
    }

    public static String getMinute(String[] minute){
        if(minute != null && minute.length != 0 )
            return minute[1];
        else{
            return null;
        }
    }
}
