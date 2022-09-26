
package com.itrail.testik;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author barysevich_k
 */
public class SomeTest {
    
    public SomeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
//    @Test
//    public void testSomeMethodr() {        
//        String dateFrom, monthYear,strFileName;
//        LocalDate my, from, date ;
//        date = LocalDate.now();
//        String dateTo = date.plusMonths(1).format( DateTimeFormatter.ofPattern( "dd.MM.yyyy" )); 
//        int monthName; 
//        if ( date.getDayOfMonth() == 3 & date.getDayOfMonth() == 4 ) {
//           // return unloadStatus;
//        }
//        if ( date.getDayOfMonth() == 1 | date.getDayOfMonth() == 2){//!2
//            if(date.getMonthValue() == 12){
//                my =  date.minusYears(1);      
//            } else{
//                my = date.minusMonths(1);      
//            }
//        }else{
//            my = date;  
//        }
//        monthYear = my.format(DateTimeFormatter.ofPattern( "MM.yyyy" ));
//        if( date.getDayOfMonth() == 2 ){
//           if ( date.getMonthValue() == 12 ){
//                from = LocalDate.of( date.minusYears(1).getYear(), date.getMonthValue(), 5 );
//           } else{
//                from = LocalDate.of( date.getYear(), date.getMonthValue(), 5 );
//            }   
//        }else {
//            from = date;
//        }
//        monthName = date.getMonthValue();
//        dateFrom  = from.format(DateTimeFormatter.ofPattern( "dd.MM.yyyy" ));
//        strFileName = "VED " + date.format(DateTimeFormatter.ofPattern( "dd.MM" ));
//        System.out.println( "MY dateFrom "    + dateFrom );
//        System.out.println( "MY dateTo "      + dateTo );
//        System.out.println( "MY monthName "   + monthName );
//        System.out.println( "MY strFileName " + strFileName );
//        System.out.println( "MY monthYear "   + monthYear );
//    }
    
    
    
    @Test
    public void testSomeMethod() {
        String dateFrom = "", dateTo = "", monthName, strFileName, monthYear;
        Date dt = new Date();
        Calendar c = new GregorianCalendar(2022, 6 , 27);
        dateTo = "00".substring(String.valueOf(c.get(Calendar.DAY_OF_MONTH)).length())
                + String.valueOf(c.get(Calendar.DAY_OF_MONTH))
                + "."
                + "00".substring(String.valueOf(c.get(Calendar.MONTH) + 1).length())
                + String.valueOf(c.get(Calendar.MONTH) + 1)
                + "."
                + "0000".substring(String.valueOf(c.get(Calendar.YEAR)).length())
                + String.valueOf(c.get(Calendar.YEAR));
        
        monthName   = "00".substring(String.valueOf(c.get(Calendar.MONTH) + 1).length()) + String.valueOf(c.get(Calendar.MONTH) + 1);
        strFileName = "VED" + "00".substring(String.valueOf(c.get(Calendar.DAY_OF_MONTH)).length()) + String.valueOf(c.get(Calendar.DAY_OF_MONTH)) 
                            + "."
                            + "00".substring(String.valueOf(c.get(Calendar.MONTH) + 1).length()) + String.valueOf(c.get(Calendar.MONTH) + 1);

        if (c.get(Calendar.DAY_OF_MONTH) == 3 | c.get(Calendar.DAY_OF_MONTH) == 4) {
           // return unloadStatus;
        }
        if (c.get(Calendar.DAY_OF_MONTH) == 1 |  c.get(Calendar.DAY_OF_MONTH) == 2) {//2!
            if (String.valueOf(c.get(Calendar.MONTH)).equals("0")) {
                monthYear = "12."
                        + "0000".substring(String.valueOf(c.get(Calendar.YEAR) - 1).length())
                        + String.valueOf(c.get(Calendar.YEAR) - 1);
            } else {
                monthYear = "00".substring(String.valueOf(c.get(Calendar.MONTH)).length())
                        + String.valueOf(c.get(Calendar.MONTH))
                        + "."
                        + "0000".substring(String.valueOf(c.get(Calendar.YEAR)).length())
                        + String.valueOf(c.get(Calendar.YEAR));
            }
        } else {
            monthYear = "00".substring(String.valueOf(c.get(Calendar.MONTH) + 1).length())
                    + String.valueOf(c.get(Calendar.MONTH) + 1)
                    + "."
                    + "0000".substring(String.valueOf(c.get(Calendar.YEAR)).length())
                    + String.valueOf(c.get(Calendar.YEAR));
        }

        if (c.get(Calendar.DAY_OF_MONTH) == 2) { //2!
            if (String.valueOf(c.get(Calendar.MONTH)).equals("0")) {
                dateFrom = "05.12."
                        + "0000".substring(String.valueOf(c.get(Calendar.YEAR) - 1).length())
                        + String.valueOf(c.get(Calendar.YEAR) - 1);
                monthName = "12";
                strFileName = "VED" + "00".substring(String.valueOf(c.get(Calendar.DAY_OF_MONTH)).length())
                        + String.valueOf(c.get(Calendar.DAY_OF_MONTH))+"." + "12";
            } else {
                dateFrom = "05." + "00".substring(String.valueOf(c.get(Calendar.MONTH)).length())
                        + String.valueOf(c.get(Calendar.MONTH))
                        + "."
                        + "0000".substring(String.valueOf(c.get(Calendar.YEAR)).length())
                        + c.get(Calendar.YEAR);
                monthName = "00".substring(String.valueOf(c.get(Calendar.MONTH)).length())
                        + String.valueOf(c.get(Calendar.MONTH));
                strFileName = "VED" + "00".substring(String.valueOf(c.get(Calendar.DAY_OF_MONTH)).length())
                        + String.valueOf(c.get(Calendar.DAY_OF_MONTH))+"."
                        + "00".substring(String.valueOf(c.get(Calendar.MONTH)).length())
                        + String.valueOf(c.get(Calendar.MONTH));
            }
        } else {
            dateFrom = dateTo;
        }
        
        String dateFromTWO, monthYearTWO,strFileNameTWO,monthNameTWO,dateToTWO;
        LocalDate my, from, dateTWO ,p1, p2, p3 ;
        dateTWO = LocalDate.of(2022, 6, 27);
        dateToTWO = dateTWO.plusMonths(1).format( DateTimeFormatter.ofPattern( "dd.MM.yyyy" )); 
        if ( dateTWO.getDayOfMonth() == 3 & dateTWO.getDayOfMonth() == 4 ) {
           // return unloadStatus;
        }
        if ( dateTWO.getDayOfMonth() == 1 | dateTWO.getDayOfMonth() == 2){//!2
            if(dateTWO.getMonthValue() == 12){
                my =  dateTWO;      
            } else{
                my = dateTWO;      
            }
        }else{
            my = dateTWO.plusMonths(1);  
        }
        monthYearTWO = my.format(DateTimeFormatter.ofPattern( "MM.yyyy" ));
        
        if( dateTWO.getDayOfMonth() == 2 ){
           if ( dateTWO.getMonthValue() == 12 ){
                from = LocalDate.of( dateTWO.getYear(), dateTWO.getMonthValue(), 5 );
                p1 = dateTWO; p2 = from; p3 = p1;
           } else{
                from = LocalDate.of( dateTWO.getYear(), dateTWO.getMonthValue(), 5 );
                p1 = dateTWO; p2 = from; p3 = p1;
            }   
        }else {
            from = dateTWO.plusMonths(1);
            p1 = from; p2 = from; p3 = from;
        }
        monthNameTWO = p3.format(DateTimeFormatter.ofPattern("MM"));
        strFileNameTWO = "VED" + p1.format(DateTimeFormatter.ofPattern( "dd.MM" )); 
        dateFromTWO  = p2.format(DateTimeFormatter.ofPattern( "dd.MM.yyyy" ));
        
        assertEquals(dateFrom, dateFromTWO);
        assertEquals(dateTo, dateToTWO);
        assertEquals(monthName, monthNameTWO);
        assertEquals(strFileName, strFileNameTWO);
        assertEquals(monthYear, monthYearTWO);
        
    }
    
}



