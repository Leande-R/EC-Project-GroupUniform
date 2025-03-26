@GetMapping("/current")
public CurrentPercentage getCurrent() { return service.getCurrent(); }

@GetMapping("/historical")
public List<HistoricalUsage> getHistorical(@RequestParam LocalDate start, @RequestParam LocalDate end) {
    return service.getUsageBetween(start, end);
}
