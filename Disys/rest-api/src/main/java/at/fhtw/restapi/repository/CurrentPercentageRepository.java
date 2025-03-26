package at.fhtw.restapi.repository;

import at.fhtw.restapi.model.CurrentPercentage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CurrentPercentageRepository extends JpaRepository<CurrentPercentage, LocalDateTime> {
    Optional<CurrentPercentage> findTopByOrderByHourDesc();
}
