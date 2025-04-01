package at.fhtw.gui.model;

public class HistoricalUsage {
    private String hour;
    private double produced;
    private double used;
    private double gridUsed;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public double getProduced() {
        return produced;
    }

    public void setProduced(double produced) {
        this.produced = produced;
    }

    public double getUsed() {
        return used;
    }

    public void setUsed(double used) {
        this.used = used;
    }

    public double getGridUsed() {
        return gridUsed;
    }

    public void setGridUsed(double gridUsed) {
        this.gridUsed = gridUsed;
    }
}
