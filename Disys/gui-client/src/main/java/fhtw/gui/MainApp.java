package at.fhtw.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import at.fhtw.gui.view.EnergyDashboard;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        EnergyDashboard dashboard = new EnergyDashboard();
        Scene scene = new Scene(dashboard.getView(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Energy Community Dashboard");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
