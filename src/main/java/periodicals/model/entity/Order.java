package periodicals.model.entity;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @ToString @Builder @EqualsAndHashCode
public class Order implements Serializable{
    private int id;
    private int userId;
    private int periodicalId;
    private int count;
}
