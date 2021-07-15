package shopping;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Inventory_table")
public class Inventory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long stock;

    @PostUpdate
    public void onPostUpdate(){
        InventoryReduced inventoryReduced = new InventoryReduced();
        BeanUtils.copyProperties(this, inventoryReduced);
        inventoryReduced.publishAfterCommit();

        InventoryIncreased inventoryIncreased = new InventoryIncreased();
        BeanUtils.copyProperties(this, inventoryIncreased);
        inventoryIncreased.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }




}
