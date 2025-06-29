package Repository;

import Model.ClickLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClickLogRepository extends JpaRepository<ClickLog, Long> {
    List<ClickLog> findByShortCode(String shortCode);
}
