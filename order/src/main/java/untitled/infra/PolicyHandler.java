package untitled.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import untitled.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='InventoryIncreased'")
    public void wheneverInventoryIncreased_SendAlert(@Payload InventoryIncreased inventoryIncreased){

        InventoryIncreased event = inventoryIncreased;
        System.out.println("\n\n##### listener SendAlert : " + inventoryIncreased + "\n\n");


        

        // Sample Logic //
        Order.sendAlert(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_UpdateDeliveryStatus(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener UpdateDeliveryStatus : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        Order.updateDeliveryStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryCancelled'")
    public void wheneverDeliveryCancelled_UpdateDeliveryStatus(@Payload DeliveryCancelled deliveryCancelled){

        DeliveryCancelled event = deliveryCancelled;
        System.out.println("\n\n##### listener UpdateDeliveryStatus : " + deliveryCancelled + "\n\n");


        

        // Sample Logic //
        Order.updateDeliveryStatus(event);
        

        

    }

}


