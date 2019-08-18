package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gymsystem.bo.BOFactory;
import lk.ijse.gymsystem.bo.custom.AttendanceBO;
import lk.ijse.gymsystem.bo.custom.CustomerBO;
import lk.ijse.gymsystem.dto.AccessoriesDTO;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import lk.ijse.gymsystem.dto.CustomerDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static lk.ijse.gymsystem.controller.AccessoriesViewController.deleteItem;

public class AttendanceViewController implements Initializable {

    @FXML
    private JFXTextField txt_CustomerId;

    @FXML
    private JFXTextField txt_CustomerName;

    @FXML
    private JFXTextField txt_ArrivalTime;

    @FXML
    private JFXTextField txt_DepartureTime;

    @FXML
    private TableView<AttendanceDTO> tbl_Attendance;

    @FXML
    private JFXTextField txt_Id;

    @FXML
    private JFXTextField txt_Date;

    @FXML
    private AnchorPane att_pane;



    static AttendanceBO bo = (AttendanceBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.ATTENDANCE);

    public static boolean addAttendance(AttendanceDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addAttendance(ref);
    }

    public static boolean updateAttendance(AttendanceDTO  ref) throws SQLException, ClassNotFoundException {
        return bo.updateAttendance(ref);
    }

    public static boolean deleteAttendance(String id) throws SQLException, ClassNotFoundException {
        return bo.deleteAttendance(id);
    }


    public static AttendanceDTO  searchAttendance(String id) throws SQLException, ClassNotFoundException {
        return bo.searchAttendance(id);
    }

    static CustomerBO bo2 = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CUSTOMER);

    public static CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo2.searchCustomer(id);
    }

    public void Search() throws SQLException, ClassNotFoundException {

        CustomerDTO searchCustomer = bo2.searchCustomer(txt_CustomerId.getText());
        txt_CustomerName.setText(searchCustomer.getName());

    }




    public void onaction_Add(ActionEvent actionEvent) throws Exception {


        String id=txt_Id.getText();
        String date=txt_Date.getText();
        String arivaltime=txt_ArrivalTime.getText();
        String departuretime=txt_DepartureTime.getText();




        AttendanceDTO cusModel = new AttendanceDTO(id, date, arivaltime, departuretime);
        boolean addItem = AttendanceViewController.addAttendance(cusModel);

        if(addItem){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAttendance();

        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }


    }

    public void onaction_Update(ActionEvent actionEvent) throws Exception {


        String id=txt_Id.getText();
        String date=txt_Date.getText();
        String arivaltime=txt_ArrivalTime.getText();
        String departuretime=txt_DepartureTime.getText();

        AttendanceDTO cusModel = new AttendanceDTO(id, date, arivaltime, departuretime);
        boolean update = AttendanceViewController.updateAttendance(cusModel);

        if(update){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "UPDATED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAttendance();

        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }




    }

    public void onaction_Details(ActionEvent actionEvent) throws IOException {


        AnchorPane anchorPane= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/AttendanceDetailView.fxml"));
        att_pane.getChildren().clear();
        att_pane.getChildren().add(anchorPane);

    }

    public void onaction_Clicked(MouseEvent mouseEvent) {

        AttendanceDTO selectedItem = tbl_Attendance.getSelectionModel().getSelectedItem();

        txt_Id.setText(selectedItem.getAttendanceId());
        txt_CustomerId.setText(selectedItem.getAttendanceId());
        txt_CustomerName.setText(selectedItem.getAttendanceId());
        txt_Date.setText(selectedItem.getDate());
        txt_ArrivalTime.setText(selectedItem.getArrivaltime());
        txt_DepartureTime.setText(selectedItem.getDepatureTime() );
    }

    public void onaction_Delete(ActionEvent actionEvent) throws Exception {

        String id = txt_Id.getText();

        boolean deleteItem = deleteAttendance(id);
        if(deleteItem){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "DELETED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAttendance();

        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_Clear(ActionEvent actionEvent) {

        setAllClear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            setDate();
            getAllAttendance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setDate() {
        txt_Date.setText(LocalDate.now().toString());
    }


    private void setAllClear(){

        txt_Id.clear();
        txt_Date.setText(LocalDate.now().toString());
        txt_CustomerId.clear();
        txt_CustomerName.clear();
        txt_ArrivalTime.clear();
        txt_DepartureTime.clear();



    }

    private void getAllAttendance() throws Exception {
        ArrayList<AttendanceDTO> accessoriesList;
        try {
            accessoriesList = bo.getAllAttendance();
            ObservableList<AttendanceDTO> accessory = FXCollections.observableArrayList(accessoriesList);
            tbl_Attendance.setItems(accessory);
            tbl_Attendance.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
            tbl_Attendance.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("arrivaltime"));
            tbl_Attendance.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("depatureTime"));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void request2(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        txt_CustomerName.requestFocus();
        Search();
    }

    public void request3(ActionEvent actionEvent) {

        txt_Date.requestFocus();
    }

    public void request5(ActionEvent actionEvent) {

        txt_DepartureTime.requestFocus();
    }

    public void request1(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        txt_CustomerId.requestFocus();
        Search();
    }

    public void request4(ActionEvent actionEvent) {
        txt_ArrivalTime.requestFocus();
    }


}
