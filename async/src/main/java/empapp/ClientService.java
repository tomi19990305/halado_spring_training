package empapp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ClientService {

    private ApplicationEventPublisher publisher;

    @Async
    public void getStatus(long id){
        log.info("Get status");

        //HTTP kérés a háttérrendszer felé

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            log.error("InterruptedException ",e);
        }

        String status = "200";
        publisher.publishEvent(new CallCompletedEvent(id, status));

        log.info("getStatus end");
        //Háttérrendszer hívása - URL lekérése
    }
}
