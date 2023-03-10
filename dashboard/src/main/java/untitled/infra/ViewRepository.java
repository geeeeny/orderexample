package untitled.infra;

import untitled.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="views", path="views")
public interface ViewRepository extends PagingAndSortingRepository<View, Long> {

    

    
}
