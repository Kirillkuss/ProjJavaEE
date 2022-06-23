
package com.itrail.testik;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public void testSomeMethod() {
        String dateFrom, monthYear;
        LocalDate date = LocalDate.now();
        String dateTo = date.format( DateTimeFormatter.ofPattern( "dd.MM.yyyy" )); 
        String monthName = date.format(DateTimeFormatter.ofPattern("MM"));
        String strFileName="VED " + date.format( DateTimeFormatter.ofPattern( "dd" ));
        if ( date.getDayOfMonth() == 3 & date.getDayOfMonth() == 4 ) {
           // return unloadStatus;
        }
        if ( date.getDayOfMonth() == 1 & date.getDayOfMonth() == 2 ){//!2
            if(date.getMonthValue() == 12){
                monthYear = date.minusYears(1).format(DateTimeFormatter.ofPattern( "MM.yyyy" ));   
            } else{ 
                monthYear = date.format(DateTimeFormatter.ofPattern( "MM.yyyy" ));
            }
        } else { 
            monthYear = date.format(DateTimeFormatter.ofPattern( "MM.yyyy" ));
        }
        if( date.getDayOfMonth() == 2 ){
           if ( date.getMonthValue() == 1 ){
               dateFrom = "05.12" + date.minusYears(1).format( DateTimeFormatter.ofPattern( "yyyy" ));
               monthName = "12";
               strFileName = "VED " + date.format( DateTimeFormatter.ofPattern( "dd." )) + monthName; 
           } else{
            dateFrom = "05."+ date.format( DateTimeFormatter.ofPattern( "MM.yyyy" ));
            monthName = date.format( DateTimeFormatter.ofPattern( "MM" ));
            strFileName="VED "+ date.format(DateTimeFormatter.ofPattern( "dd.MM" ));   
            } 
        }else {
           dateFrom = dateTo; 
        }
        System.out.println(" 1 dateFrom "      + dateFrom );
        System.out.println(" 1 dateTo "        + dateTo );
        System.out.println(" 1 monthName "     + monthName );
        System.out.println(" 1 strFileName "   + strFileName );
        System.out.println(" 1 monthYear "     + monthYear );
    }
  			
}



