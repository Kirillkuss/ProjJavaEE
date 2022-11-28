package com.itrail.shpinx;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
/**
 *
 * @author barysevich_k
 */
public class Record {
    /**
     * English Dictionary
     * @param param - входной параметр
     * @return <code> String </code>
     * @throws Exception 
     */
    public static String getRecord( String param ) throws Exception{
        try{
            String response = null;
            Configuration configuration = new Configuration();
            configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
            configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
            configuration.setSampleRate( 12000 );
            StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer( configuration );
            InputStream stream = new FileInputStream( new File( param ));
            recognizer.startRecognition( stream );
            SpeechResult result;
            while(( result = recognizer.getResult()) != null ){
                response = result.getHypothesis() ;
            }
            return response;
        }catch( Exception ex ){
            ex.printStackTrace( System.err );
            return ex.getMessage();
        }
        
    }
    
}
