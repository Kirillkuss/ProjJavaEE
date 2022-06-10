package com.itrail.test.app.converter;


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
             e.printStackTrace(System.err);
            return null;
        }
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        try{
        //return (timestamp == null ? null : timestamp.toLocalDateTime());
        return (timestamp == null ? null : LocalDateTime.parse(timestamp.toString()));
        } catch(Exception e ){
            e.printStackTrace(System.err);
            return null;
        }
    }
    

 
}
