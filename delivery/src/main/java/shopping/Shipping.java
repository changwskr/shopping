package shopping;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Shipping_table")
public class Shipping {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String address;
    private String customerId;
    private Integer quantity;
    private String productId;

    @PostPersist
    public void onPostPersist(){
        Shipped shipped = new Shipped();
        BeanUtils.copyProperties(this, shipped);
        shipped.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){
        DeliveryCanceled deliveryCanceled = new DeliveryCanceled();
        BeanUtils.copyProperties(this, deliveryCanceled);
        deliveryCanceled.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }




}
