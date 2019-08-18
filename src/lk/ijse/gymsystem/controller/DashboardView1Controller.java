package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DashboardView1Controller implements  Initializable {

    @FXML
    private AnchorPane main_pane;

    @FXML
    private JFXButton btn_Register;

    @FXML
    private JFXButton btn_Payment;

    @FXML
    private JFXButton btn_Accessories;

    @FXML
    private JFXButton btn_Instructors;

    @FXML
    private JFXButton btn_Attendance;

    @FXML
    private ImageView btn_Logout;

    @FXML
    private Text date;


    @FXML
    private JFXButton btn_minimize;

    @FXML
    private JFXButton btn_close;






    public void onaction_Dashboard(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane5= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/DashboardPane.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(anchorPane5);

    }

    public void onaction_Register(ActionEvent actionEvent) throws IOException {


        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/MemberView.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(anchorPane1);
    }

    public void onaction_Payment(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane2= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/PaymentView.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(anchorPane2);

    }

    public void onaction_Accessories(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane3= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/AccessoriesView.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(anchorPane3);

    }

    public void onaction_Instructor(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane4= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/InstructorView.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(anchorPane4);
    }

    public void onaction_Attendance(ActionEvent actionEvent) throws IOException {

         AnchorPane pane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/AttendanceView.fxml"));
        main_pane.getChildren().clear();
        main_pane.getChildren().add(pane);
    }


    public void ocaction_Out(MouseEvent mouseEvent) throws IOException {



        Parent parent=FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/LoginFormView.fxml"));
        Scene scene=new Scene(parent);
        Stage  stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private void setDate() {
        date.setText(LocalDate.now().toString());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setDate();
    }

    public void minimize(ActionEvent actionEvent) {

        Stage stage = (Stage) btn_minimize.getScene().getWindow();
        stage.setIconified(true);

    }

    public void close(ActionEvent actionEvent) {

        System.exit(0);
    }
}
