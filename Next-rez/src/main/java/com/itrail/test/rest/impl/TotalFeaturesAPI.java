package com.itrail.test.rest.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrail.test.domain.Features;
import com.itrail.test.domain.TotalFeatures;
import com.itrail.test.rest.FeaturesRecource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Path;

/**
 *
 * @author barysevich_k
 */
@Path("TotalFeatures")
public class TotalFeaturesAPI implements FeaturesRecource{
    
    private final ObjectMapper om = new ObjectMapper();

    @Override
    public TotalFeatures addTotalFeatures(TotalFeatures request) throws Exception {
        try{
            TotalFeatures response = request;
            List<Map<String, String>> ret = new ArrayList<>();
            response.getFeatures().stream().filter( s->s.getProperties().isEmpty() != true).map( s-> s.getProperties()).forEach( s -> ret.add( 0, s ) );
            Features features = response.getFeatures().stream().findFirst().orElse( null );
             
            features.setProperties( null );
            
            features.setPropertie( ret );
            List<Features> listFeatures = new ArrayList<>();
            listFeatures.add( features );
            response.setFeatures(listFeatures);
            return response;
        }catch( Exception ex ){
            ex.printStackTrace( System.err );
            return null;
        }
    }
    
    

    
    
    
}
