package periodicals.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    private int id;
    private int userId;
    private int periodicalId;
}
