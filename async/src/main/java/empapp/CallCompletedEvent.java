package empapp;

import lombok.Value;

@Value
public class CallCompletedEvent {

    private long id;

    private String result;

}
