package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gymsystem.bo.BOFactory;
import lk.ijse.gymsystem.bo.custom.ScheduleBO;
import lk.ijse.gymsystem.dto.ScheduleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleViewController {

    @FXML
    private JFXTextField txt_Scheduled;

    @FXML
    private JFXTextField txt_MeasurmentId;

    @FXML
    private JFXTextField txt_InstructorName;

    @FXML
    private JFXTextField txt_MemberId;

    @FXML
    private JFXTextField txt_InstructorId;

    @FXML
    private TextArea txt_Discription;

    @FXML
    private TextField txt_SearchId;

    @FXML
    private JFXButton btn_Register;

    @FXML
    private JFXButton btn_Update;

    @FXML
    private JFXButton btn_remove;

    @FXML
    private JFXButton btn_Clear;

    static ScheduleBO bo = (ScheduleBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.SCHEDULE);

    public static boolean addSchedule(ScheduleDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addSchedule(ref);
    }

    public static boolean updateSchedule(ScheduleDTO ref) throws SQLException, ClassNotFoundException {
        return bo.updateSchedule(ref);
    }

    public static boolean deleteSchedule(String id) throws SQLException, ClassNotFoundException {
        return bo.deleteSchedule(id);
    }


    public static ScheduleDTO searchSchedule(String id) throws SQLException, ClassNotFoundException {
        return bo.searchSchedule(id);
    }


    public void onaction_Register(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String scheduleID=txt_Scheduled.getText();
        String measurementID=txt_MeasurmentId.getText();
        String instructorID=txt_InstructorId.getText();
        String instructorName=txt_InstructorName.getText();
        String memberID=txt_MeasurmentId.getText();
        String desc=txt_Discription.getText();

        ScheduleDTO cusModel = new ScheduleDTO(scheduleID, measurementID, instructorID,memberID,desc);
        boolean addSchedule = ScheduleViewController.addSchedule(cusModel);

        if(addSchedule){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();


        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }


    private void setAllClear() {
        txt_Scheduled.clear();
        txt_MeasurmentId.clear();
        txt_InstructorId.clear();
        txt_InstructorName.clear();
        txt_MemberId.clear();
        txt_Discription.clear();
    }

    public void onaction_Update(ActionEvent actionEvent) {

    }

    public void onaction_Remove(ActionEvent actionEvent) {

    }

    public void onaction_Clear(ActionEvent actionEvent) {

    }
}
