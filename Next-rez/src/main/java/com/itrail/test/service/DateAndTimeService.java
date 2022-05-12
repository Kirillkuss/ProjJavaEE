
package com.itrail.test.service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.ejb.Stateless;

/**
 *
 * @author barysevich_k
 */
@Stateless
public class DateAndTimeService {
        public String dateService(){
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern( "dd.MM.yyyy HH:mm:ss" ) );
    }
}
