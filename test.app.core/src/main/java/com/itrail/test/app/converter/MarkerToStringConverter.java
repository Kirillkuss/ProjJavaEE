
package com.itrail.test.app.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 *
 * @author barysevich_k
 */
@Converter(autoApply = true)
public class MarkerToStringConverter implements AttributeConverter<Marker, String>{

    @Override
    public String convertToDatabaseColumn(Marker marker) {
        try{
            return(marker == null ? null : String.valueOf(marker));           
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Marker convertToEntityAttribute(String string) {
        try{
            return(string == null ? null : MarkerManager.getMarker(string));           
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    
}
