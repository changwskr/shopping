package shopping;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyPageRepository extends CrudRepository<MyPage, Long> {

    List<MyPage> findByItemId(Long itemId);
    List<MyPage> findByItemId(Long itemId);

}