package at.fhtw.restapi.service;

import at.fhtw.restapi.model.CurrentPercentage;
import at.fhtw.restapi.model.HourlyUsage;
import at.fhtw.restapi.repository.CurrentPercentageRepository;
import at.fhtw.restapi.repository.HourlyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnergyService {

    @Autowired
    private HourlyUsageRepository hourlyRepo;

    @Autowired
    private CurrentPercentageRepository percentageRepo;

    public CurrentPercentage getCurrentPercentage() {
        return percentageRepo.findTopByOrderByHourDesc()
                .orElseThrow(() -> new RuntimeException("No percentage data available"));
    }

    public List<HourlyUsage> getUsage(LocalDate start, LocalDate end) {
        return hourlyRepo.findByHourBetween(
                start.atStartOfDay(),
                end.atTime(23, 59, 59)
        );
    }
}
