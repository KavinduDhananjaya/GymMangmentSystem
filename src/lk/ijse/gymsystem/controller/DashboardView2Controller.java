package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardView2Controller {

    @FXML
    private AnchorPane main_pane;

    @FXML
    private JFXButton btn_Shedule;

    @FXML
    private JFXButton btn_Mwasurment;

    @FXML
    private JFXButton btn_Accessories;

    @FXML
    private JFXButton btn_Attendance;

    @FXML
    private Label date;


    @FXML
    private JFXButton btn_minimize;

    @FXML
    private JFXButton btn_close;







    public void onaction_Shedule(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/ScheduleView.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(anchorPane1);
    }

    public void onaction_Measurment(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/MeasurmentsView.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(anchorPane1);
    }

    public void onaction_Accessories(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/AccessoriesView.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(anchorPane1);
    }

    public void onaction_Attendance(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/AttendanceDetailView.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(anchorPane1);
    }

    public void onaction_Dashboard(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/DashboardPane.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(anchorPane1);
    }

    public void minimize(ActionEvent actionEvent) {


        Stage stage = (Stage) btn_minimize.getScene().getWindow();
        stage.setIconified(true);
    }

    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }
}
