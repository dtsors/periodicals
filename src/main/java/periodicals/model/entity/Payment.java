package periodicals.model.entity;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@ToString
@EqualsAndHashCode
public class Payment implements Serializable {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private int userId;
    @Getter @Setter
    private int orderId;
    private BigDecimal amount;
}
