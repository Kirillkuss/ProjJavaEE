package com.itrail.test.mqtt;

import org.apache.logging.log4j.LogManager;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author barysevich_k
 */
public class SentMessage {
    
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(SentMessage.class);
    
    public static void getPublish( String param){
        //String broker = "tcp://broker.emqx.io:1883";
        // TLS/SSL
        String broker = "ssl://broker.emqx.io:8883";
        String topic = "mqtt/myTest";
        String username = "test";
        String password = "test";
        String clientid = "publish_client_test_two";
        long start = System.currentTimeMillis();
        try ( MqttClient client = new MqttClient(broker, clientid, new MemoryPersistence());){ 
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            options.setKeepAliveInterval(60);
            options.setConnectionTimeout(60);
            client.connect(options);
            MqttMessage message = new MqttMessage(param.getBytes());
            message.setQos( 0 );
            client.publish(topic, message);
            client.disconnect();
            client.close();
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }finally{
            LOGGER.info(  "SentMessage -->> " + (System.currentTimeMillis() - start) + " ms;" + " Message >>>" + param );
        }
    }
    
}
