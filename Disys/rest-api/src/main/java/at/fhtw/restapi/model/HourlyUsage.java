package at.fhtw.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class HourlyUsage {
    @Id
    private LocalDateTime hour;

    private double communityProduced;
    private double communityUsed;
    private double gridUsed;

    // Getters & Setters
    public LocalDateTime getHour() { return hour; }
    public void setHour(LocalDateTime hour) { this.hour = hour; }

    public double getCommunityProduced() { return communityProduced; }
    public void setCommunityProduced(double v) { this.communityProduced = v; }

    public double getCommunityUsed() { return communityUsed; }
    public void setCommunityUsed(double v) { this.communityUsed = v; }

    public double getGridUsed() { return gridUsed; }
    public void setGridUsed(double v) { this.gridUsed = v; }
}
