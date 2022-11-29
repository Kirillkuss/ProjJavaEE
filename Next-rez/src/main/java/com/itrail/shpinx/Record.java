package com.itrail.shpinx;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author barysevich_k
 */
public class Record {
    private static String ACOUSTIC_MODELS = "file:///D:/Project/test/sphinx4/sphinx/ru4/split/msu_ru_zero.cd_cont_2000";
    private static String LANGUAGE_MODEL  = "file:///D:/Project/test/sphinx4/sphinx/ru.lm";
    private static String DICTIONARY      = "file:///D:/Project/test/sphinx4/sphinx/ru.dic";
    private static String GRAMMAR         = "file:///D:/Project/test/sphinx4/sphinx/gram/";
    /**
     * English Dictionary
     * @param param - входной параметр
     * @return <code> String </code>
     * @throws IOException 
     */
    public static String getRecord( String param ) throws IOException{
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
        }catch( IOException ex ){
            ex.printStackTrace( System.err );
            return ex.getMessage();
        }        
    }
    /**
     * Russian Dictionary
     * @param record - путь к файлу ( запись ) 
     * @return <code> String </code>
     * @throws IOException 
     */
    public static String getRuRecord( String record ) throws IOException{
        try{
            String response = null;
            Configuration configuration = new Configuration();
            configuration.setAcousticModelPath( ACOUSTIC_MODELS );
            configuration.setDictionaryPath( DICTIONARY );
            //configuration.setLanguageModelPath( LANGUAGE_MODEL );
            configuration.setGrammarPath( GRAMMAR );
            configuration.setGrammarName("digits.grxml");
            configuration.setUseGrammar( true );
            configuration.setSampleRate( 8000 );
            StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer( configuration );
            InputStream stream = new FileInputStream( new File( record ));
            recognizer.startRecognition( stream );
            SpeechResult result;
            while(( result = recognizer.getResult()) != null ){
                response = new String( result.getHypothesis().getBytes(), "UTF-8");
            }
            return response;
        } catch( IOException ex ){
            ex.printStackTrace( System.err );
            return ex.getMessage();
        }
    }
    
}
