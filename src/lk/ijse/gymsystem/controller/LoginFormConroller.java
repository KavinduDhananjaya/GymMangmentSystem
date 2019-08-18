package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginFormConroller {

    @FXML
    private JFXTextField txt_Name;

    @FXML
    private JFXTextField txt_Password;

    @FXML
    private JFXButton btn_Login;



    public void onAction_Login(ActionEvent actionEvent) throws IOException {


        String text = txt_Name.getText();
        String psswrd=txt_Password.getText();



        if(text.equalsIgnoreCase("a") && psswrd.equalsIgnoreCase("123")){
            Parent parent= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/DashboardView1.fxml"));
            Scene scene=new Scene(parent);
            Stage stage = (Stage) this.btn_Login.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        }else if(text.equalsIgnoreCase("i") && psswrd.equalsIgnoreCase("123")){
            Parent parent= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/DashboardView2.fxml"));
            Scene scene=new Scene(parent);
            Stage stage = (Stage) this.btn_Login.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();

            stage.show();
        }else
            {
            Alert a = new Alert(Alert.AlertType.WARNING, "Invalid Login ", ButtonType.OK);
            a.showAndWait();
        }

    }

    public void onaction_Username(ActionEvent actionEvent) {
        txt_Password.requestFocus();
    }

    public void onaction_Password(ActionEvent actionEvent) {
        btn_Login.requestFocus();
    }
}
