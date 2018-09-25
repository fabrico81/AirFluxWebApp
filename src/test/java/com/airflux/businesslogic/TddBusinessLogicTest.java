package com.airflux.businesslogic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TddBusinessLogicTest {


    @Test
    public void dateToStringFormatterTest(){
//        2018-09-22T10:00
//        2018-09-22T10:00+02:00[Europe/Berlin]
        String formatJsonDate = "2018-09-22T10:00:00+02:00";
        String str = "2018-09-22";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        LocalDateTime localDateTime = LocalDateTime.of(dateTime, LocalTime.of(10,0,0));
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Berlin"));
        String date = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime);
        Assert.assertEquals(date,formatJsonDate);
    }
}
