package at.fhtw.restapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class CurrentPercentage {
    @Id
    private LocalDateTime hour;

    private double communityDepleted;
    private double gridPortion;

    public LocalDateTime getHour() { return hour; }
    public void setHour(LocalDateTime hour) { this.hour = hour; }

    public double getCommunityDepleted() { return communityDepleted; }
    public void setCommunityDepleted(double v) { this.communityDepleted = v; }

    public double getGridPortion() { return gridPortion; }
    public void setGridPortion(double v) { this.gridPortion = v; }
}
