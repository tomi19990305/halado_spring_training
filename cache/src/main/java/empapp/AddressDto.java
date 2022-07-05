package empapp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AddressDto implements Serializable {

    private Long id;

    private String city;
}
