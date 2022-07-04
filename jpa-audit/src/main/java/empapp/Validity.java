package empapp;

import lombok.Data;
import lombok.Value;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Value
public class Validity {

    private LocalDateTime validFrom;

    private LocalDateTime validTo;


}
