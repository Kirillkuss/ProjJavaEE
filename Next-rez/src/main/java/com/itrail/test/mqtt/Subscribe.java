package com.itrail.test.mqtt;

import org.apache.logging.log4j.LogManager;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author barysevich_k
 */
public class Subscribe {
    
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Subscribe.class);
    
    public static MqttClient getSubcribe(){

        //String broker = "tcp://broker.emqx.io:1883";
        String broker = "ssl://broker.emqx.io:8883";
        String topic = "mqtt/myTest";
        String username = "test";
        String password = "test";
        String clientid = "subscribe_client_test";
        int qos = 0;
        try {
            MqttClient client = new MqttClient(broker, clientid, new MemoryPersistence());

            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            options.setConnectionTimeout(60);
            options.setKeepAliveInterval(60);
            options.setAutomaticReconnect(true );
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    LOGGER.info( "connectionLost: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) {
                    LOGGER.info( "Topic >>>" + topic + " Qos >>> " + message.getQos() +" Message >>> " + new String(message.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    LOGGER.info(  "deliveryComplete >>>" + token.isComplete());
                }

            });
            client.connect(options);
            client.subscribe(topic, qos);
            return client;
        } catch (IllegalArgumentException | MqttException e) {
            e.printStackTrace( System.err );
            return null;
        }
        
    }    
}
