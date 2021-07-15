
package shopping.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="inventory", url="http://inventory:8080", fallback=InventoryServiceImpl.class)
public interface InventoryService {
    @RequestMapping(method= RequestMethod.GET, path="/inventories/{id}")
    public Inventory getInventory(@PathVariable("id") Long id);

}

