package com.itrail.test.rest.impl;

import com.itrail.shpinx.Record;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.rest.SpthinxResource;

/**
 *
 * @author barysevich_k
 */
public class SphinxAPI implements SpthinxResource{

    @Override
    public BaseResponse getRecord( String record ) throws Exception {
        BaseResponse baseResponse = new BaseResponse(200, "success");
        try{
            baseResponse.setData( Record.getRecord( record ));
            return baseResponse;
        }catch( Exception ex ){
            return BaseResponse.error( 900, ex );
        }
    }
    
}
