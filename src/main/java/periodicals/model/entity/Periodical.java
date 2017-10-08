package periodicals.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class Periodical {
    @Getter @Setter
    private int id;
    //    private int id = 1;
    @Getter @Setter
    private String name;
    //    private String name = "name";
    @Getter @Setter
    private String description;
    //    private String description = "description";
    @Getter @Setter
    private Integer issuesPerMonth;
    //    private Integer issuesPerMonth = 1;
    private BigDecimal cost;
//    private BigDecimal cost = BigDecimal.ONE;

    public String getCost() {
        return cost.toString();
    }

    public void setCost(String cost) {
        this.cost = new BigDecimal(cost);
    }
}
