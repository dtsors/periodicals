package periodicals.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
class Order {
    private int id;
    private int userId;
    private int periodicalId;
}
