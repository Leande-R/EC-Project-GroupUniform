package at.fhtw.restapi.repository;

import at.fhtw.restapi.model.HourlyUsage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HourlyUsageRepository extends JpaRepository<HourlyUsage, LocalDateTime> {
    List<HourlyUsage> findByHourBetween(LocalDateTime start, LocalDateTime end);
}
