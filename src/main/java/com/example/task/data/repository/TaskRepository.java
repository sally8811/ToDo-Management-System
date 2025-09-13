import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser_UserNameAndDueAtBetween(
        String userName,
        LocalDateTime from,
        LocalDateTime to
    );
}
