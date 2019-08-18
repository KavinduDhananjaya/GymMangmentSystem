package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.gymsystem.bo.BOFactory;
import lk.ijse.gymsystem.bo.custom.CustomerBO;
import lk.ijse.gymsystem.bo.custom.MeasurmentBO;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.dto.MeasurmentDTO;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MeasurmentViewController implements Initializable {

    @FXML
    private JFXTextField txt_CustomerId;

    @FXML
    private JFXTextField txt_CustomerName;

    @FXML
    private JFXTextField txt_Height;

    @FXML
    private JFXTextField txt_Weight;

    @FXML
    private JFXTextField txt_Chest;

    @FXML
    private JFXTextField txt_Waist;

    @FXML
    private JFXTextField txt_Arm;

    @FXML
    private JFXTextField txt_MeasurmentId;

    @FXML
    private JFXTextField txt_Calf;

    @FXML
    private TableView<MeasurmentDTO> table_Measurment;

    @FXML
    private JFXTextField txt_Date;


    static MeasurmentBO bo = (MeasurmentBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.MEASURMENT);

    public static boolean addMeasurment(MeasurmentDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addMeasurment(ref);
    }

    public static boolean updateMeasurment(MeasurmentDTO  ref) throws SQLException, ClassNotFoundException {
        return bo.updateMeasurment(ref);
    }

    public static boolean deleteMeasurment(String id) throws SQLException, ClassNotFoundException {
        return bo.deleteMeasurment(id);
    }


    public static MeasurmentDTO  searchMeasurment(String id) throws SQLException, ClassNotFoundException {
        return bo.searchMeasurment(id);
    }






    public void onaction_ADD(ActionEvent actionEvent) throws Exception {

        String id=txt_MeasurmentId.getText();
        String date=txt_Date.getText();
        Integer height=Integer.parseInt(txt_Height.getText());
        Integer weight=Integer.parseInt(txt_Weight.getText());
        Integer chest=Integer.parseInt(txt_Chest.getText());
        Integer waist=Integer.parseInt(txt_Waist.getText());
        Integer arm=Integer.parseInt(txt_Arm.getText());
        Integer calf=Integer.parseInt(txt_Calf.getText());

       MeasurmentDTO cusModel = new MeasurmentDTO(id, date, height, weight, chest,waist,arm,calf);
        boolean add = MeasurmentViewController.addMeasurment(cusModel);

        if(add){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllMeasurment();



        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }


    }

    public void onaction_Update(ActionEvent actionEvent) throws Exception {

        String id=txt_MeasurmentId.getText();
        String date=txt_Date.getText();
        Integer height=Integer.parseInt(txt_Height.getText());
        Integer weight=Integer.parseInt(txt_Weight.getText());
        Integer chest=Integer.parseInt(txt_Chest.getText());
        Integer waist=Integer.parseInt(txt_Waist.getText());
        Integer arm=Integer.parseInt(txt_Arm.getText());
        Integer calf=Integer.parseInt(txt_Calf.getText());

        MeasurmentDTO cusModel = new MeasurmentDTO(id, date, height, weight, chest,waist,arm,calf);
        boolean add = MeasurmentViewController.updateMeasurment(cusModel);

        if(add){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "UPDATED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllMeasurment();


        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_Delete(ActionEvent actionEvent) throws Exception {

        String id = txt_MeasurmentId.getText();

        boolean deleteCustomer = deleteMeasurment(id);
        if(deleteCustomer){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DELETED SUCCSESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllMeasurment();
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }

    }


    public void onaction_Clicked(MouseEvent mouseEvent) {

        MeasurmentDTO selectedItem = table_Measurment.getSelectionModel().getSelectedItem();

        txt_MeasurmentId.setText(selectedItem.getId());
        txt_Date.setText(selectedItem.getDate());
        txt_Height.setText(selectedItem.getHeight()+"");
        txt_Weight.setText(selectedItem.getWeight()+"");
        txt_Chest.setText(selectedItem.getChest()+"" );
        txt_Waist.setText(selectedItem.getWaist()+"" );
        txt_Arm.setText(selectedItem.getArm()+"" );
        txt_Calf.setText(selectedItem.getCalf()+"" );
    }


    public void onaction_Clear(ActionEvent actionEvent) {

       setAllClear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllMeasurment();
            setDate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void setAllClear(){
        txt_MeasurmentId.clear();
        txt_CustomerName.clear();
        txt_Date.clear();
        txt_CustomerId.clear();
        txt_Height.clear();
        txt_Weight.clear();
        txt_Chest.clear();
        txt_Waist.clear();
        txt_Arm.clear();
        txt_Calf.clear();

    }

    private void getAllMeasurment() throws Exception {
        ArrayList<MeasurmentDTO> customerList;
        try {
            customerList = bo.getAllMeasurment();
            ObservableList<MeasurmentDTO> customers = FXCollections.observableArrayList(customerList);
            table_Measurment.setItems(customers);
            table_Measurment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>(""));
            table_Measurment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
            table_Measurment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("height"));
            table_Measurment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("weight"));
            table_Measurment.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("chest"));
            table_Measurment.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("waist"));
            table_Measurment.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("arm"));
            table_Measurment.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("calf"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setDate() {
        txt_Date.setText(LocalDate.now().toString());
    }
}
