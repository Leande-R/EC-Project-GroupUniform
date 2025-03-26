package at.fhtw.gui.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import at.fhtw.gui.model.*;
import at.fhtw.gui.service.EnergyService;

import java.time.LocalDate;
import java.util.List;

public class EnergyDashboard {
    private final VBox root;
    private final Text currentText = new Text("Click below to load current percentage");
    private final TableView<HistoricalUsage> table = new TableView<>();
    private final DatePicker startPicker = new DatePicker();
    private final DatePicker endPicker = new DatePicker();
    private final EnergyService energyService = new EnergyService();

    public EnergyDashboard() {
        root = new VBox(15);
        root.setPadding(new Insets(20));

        // Current Section
        Button fetchCurrentBtn = new Button("Fetch Current Percentage");
        fetchCurrentBtn.setOnAction(e -> loadCurrentPercentage());

        // Historical Section
        HBox dateControls = new HBox(10, new Label("Start:"), startPicker, new Label("End:"), endPicker);
        Button fetchHistoryBtn = new Button("Fetch Historical Data");
        fetchHistoryBtn.setOnAction(e -> loadHistoricalData());

        setupTable();

        root.getChildren().addAll(
            new Label("📊 Current Hour Energy Percentage:"),
            fetchCurrentBtn,
            currentText,
            new Separator(),
            new Label("📈 Historical Energy Usage:"),
            dateControls,
            fetchHistoryBtn,
            table
        );
    }

    public VBox getView() {
        return root;
    }

    private void loadCurrentPercentage() {
        try {
            CurrentPercentage cp = energyService.fetchCurrentPercentage();
            currentText.setText(
                "Community Depleted: " + cp.getCommunityDepleted() + "%\n" +
                "Grid Portion: " + cp.getGridPortion() + "%"
            );
        } catch (Exception ex) {
            currentText.setText("❌ Error fetching current data");
        }
    }

    private void loadHistoricalData() {
        LocalDate start = startPicker.getValue();
        LocalDate end = endPicker.getValue();
        if (start == null || end == null) return;

        try {
            List<HistoricalUsage> usage = energyService.fetchHistoricalUsage(start, end);
            table.setItems(FXCollections.observableArrayList(usage));
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, "Failed to fetch historical data.").show();
        }
    }

    private void setupTable() {
        TableColumn<HistoricalUsage, String> hourCol = new TableColumn<>("Hour");
        hourCol.setCellValueFactory(new PropertyValueFactory<>("hour"));

        TableColumn<HistoricalUsage, Double> producedCol = new TableColumn<>("Produced (kWh)");
        producedCol.setCellValueFactory(new PropertyValueFactory<>("produced"));

        TableColumn<HistoricalUsage, Double> usedCol = new TableColumn<>("Used (kWh)");
        usedCol.setCellValueFactory(new PropertyValueFactory<>("used"));

        TableColumn<HistoricalUsage, Double> gridCol = new TableColumn<>("Grid Used (kWh)");
        gridCol.setCellValueFactory(new PropertyValueFactory<>("gridUsed"));

        table.getColumns().addAll(hourCol, producedCol, usedCol, gridCol);
    }
}
