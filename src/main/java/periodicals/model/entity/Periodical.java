package periodicals.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString @EqualsAndHashCode
public class Periodical {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Integer issuesPerMonth;
    private BigDecimal cost;

    public String getCost() {
        return cost.toString();
    }

    public void setCost(String cost) {
        this.cost = new BigDecimal(cost);
    }
}
