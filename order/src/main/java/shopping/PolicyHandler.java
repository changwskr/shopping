package shopping;

import shopping.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverShipped_UpdateStatus(@Payload Shipped shipped){

        if(!shipped.validate()) return;

        System.out.println("\n\n##### listener UpdateStatus : " + shipped.toJson() + "\n\n");



        // Sample Logic //
        // Order order = new Order();
        // orderRepository.save(order);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCanceled_UpdateStatus(@Payload DeliveryCanceled deliveryCanceled){

        if(!deliveryCanceled.validate()) return;

        System.out.println("\n\n##### listener UpdateStatus : " + deliveryCanceled.toJson() + "\n\n");



        // Sample Logic //
        // Order order = new Order();
        // orderRepository.save(order);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
