package at.fhtw.restapi.controller;

import at.fhtw.restapi.model.CurrentPercentage;
import at.fhtw.restapi.model.HourlyUsage;
import at.fhtw.restapi.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/energy")
@CrossOrigin
public class EnergyController {

    @Autowired
    private EnergyService service;

    @GetMapping("/current")
    public CurrentPercentage getCurrent() {
        return service.getCurrentPercentage();
    }

    @GetMapping("/historical")
    public List<HourlyUsage> getHistorical(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end
    ) {
        return service.getUsage(start, end);
    }
}
