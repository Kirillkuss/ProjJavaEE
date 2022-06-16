
package com.itrail.testik;

import com.itrail.test.app.converter.LocalDateTimeTimeStampConverter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Этот юнит тест предназначен для тестирования конвертора LocalDateTimeTimeStampConverter
 * @author barysevich_k
 */
public class ConverterTest {
    private LocalDateTimeTimeStampConverter converter;
    
    public ConverterTest() {
    }
   
    @Before
    public void setUp() {
        converter = new LocalDateTimeTimeStampConverter();
    }
    
    @After
    public void tearDown() {
    }
        
    @Test
    public void testIsNullTimeStamp() {
         Timestamp timestamp = converter.convertToDatabaseColumn(null);
         assertNotEquals(timestamp, Timestamp.valueOf(LocalDateTime.now()));
    }
     
    @Test
    public void testTimeStampWithValue(){
        LocalDateTime localdatetime = LocalDate.of(2010, Month.JANUARY, 1).atTime(1, 10, 30, 0);
	Timestamp timestamp = converter.convertToDatabaseColumn(localdatetime);
	Calendar c = new GregorianCalendar(2010, Calendar.JANUARY, 1, 1, 10, 30);
	Timestamp expected = new Timestamp(c.getTimeInMillis());
        assertEquals(timestamp, expected);
     }
     
    @Test
    public void testIsNullLocalDateTime(){
         LocalDateTime localdatetime = converter.convertToEntityAttribute(null);
         assertNotEquals(localdatetime, nullValue());
    }
     
    @Test
    public void testLocalDateTimeWithValue(){
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(2020, Month.MARCH, 1, 1, 10,30));
        LocalDateTime localdatetime = LocalDate.of(2020, Month.MARCH, 1).atTime(1,10,30);
        LocalDateTime conv  = converter.convertToEntityAttribute(timestamp);
        assertEquals(conv, localdatetime);     
    }  
}
