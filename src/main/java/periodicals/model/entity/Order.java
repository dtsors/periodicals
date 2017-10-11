package periodicals.model.entity;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @ToString(exclude = "id") @Builder @EqualsAndHashCode
public class Order implements Serializable{
    private int id;
    private int periodicalId;
    private int count;
}
