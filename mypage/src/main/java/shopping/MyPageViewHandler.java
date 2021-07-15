package shopping;

import shopping.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPageViewHandler {


    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setId(orderPlaced.getId());
            myPage.setAccountId(orderPlaced.getCustomerId());
            myPage.setItemId(orderPlaced.getProductId());
            myPage.setQuantity(orderPlaced.getQty());
            myPage.setAddress(orderPlaced.getAddress());
            myPage.setOrderStatus("주문성공");
            // view 레파지 토리에 save
            myPageRepository.save(myPage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenShipped_then_UPDATE_1(@Payload Shipped shipped) {
        try {
            if (!shipped.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(shipped.getOrderId());

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 myPage.setDeliveryStatus("배송시작");
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_2(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(orderCanceled.getId());

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 myPage.setOrderStatus("주문취소");
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCanceled_then_UPDATE_3(@Payload DeliveryCanceled deliveryCanceled) {
        try {
            if (!deliveryCanceled.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(deliveryCanceled.getOrderId());

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 myPage.setDeliveryStatus("배송취소");
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenInventoryIncreased_then_UPDATE_4(@Payload InventoryIncreased inventoryIncreased) {
        try {
            if (!inventoryIncreased.validate()) return;
                // view 객체 조회

                    List<MyPage> myPageList = myPageRepository.findByItemId(inventoryIncreased.getId());
                    for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setStock(inventoryIncreased.getStock());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenInventoryReduced_then_UPDATE_5(@Payload InventoryReduced inventoryReduced) {
        try {
            if (!inventoryReduced.validate()) return;
                // view 객체 조회

                    List<MyPage> myPageList = myPageRepository.findByItemId(inventoryReduced.getId());
                    for(MyPage myPage : myPageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myPage.setStock(inventoryReduced.getStock());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

