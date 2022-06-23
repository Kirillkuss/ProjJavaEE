
package com.itrail.testik;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
    

    
    @Test
    public void testSomeMethodr() {
        String dateFrom, monthYear;
        LocalDate date = LocalDate.of(2022, Month.JULY, 5);
        String dateTo = date.format( DateTimeFormatter.ofPattern( "dd.MM.yyyy" )); 
        String monthName = date.format(DateTimeFormatter.ofPattern("MM"));
        String strFileName="VED " + date.format( DateTimeFormatter.ofPattern( "dd" ));
        if ( date.getDayOfMonth() == 3 & date.getDayOfMonth() == 4 ) {
           // return unloadStatus;
        }
        if ( date.getDayOfMonth() == 1 | date.getDayOfMonth() == 2 ){//!2
            if(date.getMonthValue() == 12){
                monthYear = date.minusYears(1).format(DateTimeFormatter.ofPattern( "MM.yyyy" ));   
            } else{
                monthYear =  date.minusMonths(1).format(DateTimeFormatter.ofPattern( "MM.yyyy" ));
            }
        } else {
            monthYear = date.format(DateTimeFormatter.ofPattern( "MM.yyyy" ));
        }
        
        if( date.getDayOfMonth() == 2 ){
           if ( date.getMonthValue() == 12 ){
               dateFrom = "05.12." + date.minusYears(1).format( DateTimeFormatter.ofPattern( "yyyy" ));
               monthName = "12";
               strFileName = "VED " + date.format( DateTimeFormatter.ofPattern( "dd." )) + monthName; 
           } else{
            dateFrom = "05."+ date.format( DateTimeFormatter.ofPattern( "MM.yyyy" ));
            monthName = date.format( DateTimeFormatter.ofPattern( "MM" ));
            strFileName="VED "+ date.format( DateTimeFormatter.ofPattern( "dd.MM" ));   
            } 
        }else {
           dateFrom = dateTo; 
        }
        System.out.println( " dateFrom "    + dateFrom );
        System.out.println( " dateTo "      + dateTo );
        System.out.println( " monthName "   + monthName );
        System.out.println( " strFileName " + strFileName );
        System.out.println( " monthYear "   + monthYear );
    }
    
  			
}



