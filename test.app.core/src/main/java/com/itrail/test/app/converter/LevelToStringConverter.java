package com.itrail.test.app.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.logging.log4j.Level;

/**
 *
 * @author barysevich_k
 */
@Converter(autoApply = true)
public class LevelToStringConverter implements AttributeConverter<Level, String>{

    @Override
    public String convertToDatabaseColumn(Level level) {
        try{
            return(level == null ? null : String.valueOf(level.name()));           
        }catch(Exception e){
            e.printStackTrace(System.err);
            return null;
        }
    }

    @Override
    public Level convertToEntityAttribute(String string) {
        try{
           return(string == null ? null : Level.valueOf(string)); 
        }catch(Exception e){
            e.printStackTrace(System.err);
            return null;
        }
    }
    
    
}
