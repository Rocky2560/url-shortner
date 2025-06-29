package Repository;

import Model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UrlRepository extends JpaRepository<UrlMapping , String> {
}
