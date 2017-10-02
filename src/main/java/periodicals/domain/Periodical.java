package periodicals.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class Periodical {
    @Setter
    @Getter
    private int id = 1;
    @Setter
    @Getter
    private String name = "name";
    @Setter
    @Getter
    private String description = "description";
    @Setter
    @Getter
    private Integer issuesPerMonth = 1;
    private BigDecimal cost = BigDecimal.ONE;

    public String getCost() {
        return cost.toString();
    }

    public void setCost(String cost) {
        this.cost = new BigDecimal(cost);
    }

    @Override
    public String toString() {
        return "Periodical{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", issuesPerMonth=" + issuesPerMonth +
                ", cost=" + cost +
                '}';
    }
}
