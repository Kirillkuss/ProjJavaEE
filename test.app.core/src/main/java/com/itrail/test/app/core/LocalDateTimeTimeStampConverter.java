package com.itrail.test.app.core;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author barysevich_k
 */
@Converter(autoApply = true)
public class LocalDateTimeTimeStampConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        try{
         return (localDateTime == null ? null : Timestamp.valueOf(localDateTime));
        }catch(Exception e){
             e.printStackTrace();
            return null;
        }
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        try{
        return (timestamp == null ? null : timestamp.toLocalDateTime());
        } catch(Exception e ){
            e.printStackTrace();
            return null;
        }
    }
    

 
}
