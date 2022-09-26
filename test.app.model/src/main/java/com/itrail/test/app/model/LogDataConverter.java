
package com.itrail.test.app.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.logging.log4j.Level;

/**
 *
 * @author barysevich_k
 */
@Converter(autoApply = true)
public class LogDataConverter implements AttributeConverter<LogData, String>{

    @Override
    public String convertToDatabaseColumn(LogData x) {
        try{
            return(x == null ? null : String.valueOf(x.getLevel().getStandardLevel())); 
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public LogData convertToEntityAttribute(String y) {
        try{
            LogData logData = new LogData();
            logData.setLevel(Level.getLevel(y));
            return logData;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }  
}
