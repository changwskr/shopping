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
    @Autowired InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverShipped_ReduceInventory(@Payload Shipped shipped){

        if(!shipped.validate()) return;

        System.out.println("\n\n##### listener ReduceInventory : " + shipped.toJson() + "\n\n");



        // Sample Logic //
        // Inventory inventory = new Inventory();
        // inventoryRepository.save(inventory);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCanceled_IncreaseInventory(@Payload DeliveryCanceled deliveryCanceled){

        if(!deliveryCanceled.validate()) return;

        System.out.println("\n\n##### listener IncreaseInventory : " + deliveryCanceled.toJson() + "\n\n");



        // Sample Logic //
        // Inventory inventory = new Inventory();
        // inventoryRepository.save(inventory);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
