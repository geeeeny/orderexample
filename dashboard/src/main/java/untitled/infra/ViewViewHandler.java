package untitled.infra;

import untitled.domain.*;
import untitled.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ViewViewHandler {

    @Autowired
    private ViewRepository viewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            View view = new View();
            // view 객체에 이벤트의 Value 를 set 함
            view.setId(orderPlaced.getId());
            view.setOrderStatus("주문됨");
            // view 레파지 토리에 save
            viewRepository.save(view);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancelled_then_UPDATE_1(@Payload OrderCancelled orderCancelled) {
        try {
            if (!orderCancelled.validate()) return;
                // view 객체 조회
            Optional<View> viewOptional = viewRepository.findById(orderCancelled.getId());

            if( viewOptional.isPresent()) {
                 View view = viewOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                view.setOrderStatus("취소됨");    
                // view 레파지 토리에 save
                 viewRepository.save(view);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

