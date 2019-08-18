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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.gymsystem.bo.BOFactory;
import lk.ijse.gymsystem.bo.custom.CustomerBO;
import lk.ijse.gymsystem.bo.custom.InstructorsBO;
import lk.ijse.gymsystem.common.IDGenerator;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.dto.InstructorsDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InstructorsViewController implements Initializable {

    @FXML
    private JFXTextField txt_insId;

    @FXML
    private JFXTextField txt_InsName;

    @FXML
    private JFXTextField txt_InsNic;

    @FXML
    private JFXTextField txt_InsEmail;

    @FXML
    private JFXTextField txt_InsTp;

    @FXML
    private TextField txt_SearchNic;

    @FXML
    private TextField txt_SearchId;

    @FXML
    private TableView<InstructorsDTO> table_Instructors;

    @FXML
    private JFXTextField txt_InsAddress;



    static InstructorsBO bo = (InstructorsBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.INSTRUCTOR);

    public static boolean addCustomer(InstructorsDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addInstructor(ref);
    }

    public static boolean updateCustomer(InstructorsDTO ref) throws SQLException, ClassNotFoundException {
        return bo.updateInstructor(ref);
    }

    public static boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo.deleteInstructor(id);
    }


    public static InstructorsDTO searchCustomer1(String id) throws SQLException, ClassNotFoundException {
        return bo.searchInstructor1(id);
    }

    public static InstructorsDTO searchCustomer2(String id) throws SQLException, ClassNotFoundException {
        return bo.searchInstructor2(id);
    }

    public void onaction_Add(ActionEvent actionEvent) throws Exception {

        String id=txt_insId.getText();
        String name=txt_InsName.getText();
        String nid=txt_InsNic.getText();
        String address=txt_InsAddress.getText();
        String email=txt_InsEmail.getText();
        String tp=txt_InsTp.getText();


        InstructorsDTO cusModel = new InstructorsDTO(id, name, nid, address,email,tp);
        boolean addCustomer = InstructorsViewController.addCustomer(cusModel);

        if(addCustomer){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllCustomers();
            setInstructor();



        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }



    }

    public void onaction_Update(ActionEvent actionEvent) throws Exception {

        String id=txt_insId.getText();
        String name=txt_InsName.getText();
        String nid=txt_InsNic.getText();
        String address=txt_InsAddress.getText();
        String email=txt_InsEmail.getText();
        String tp=txt_InsTp.getText();

        InstructorsDTO cusModel = new InstructorsDTO(id, name,nid, address, email,tp);
        boolean updateCustomer = InstructorsViewController.updateCustomer(cusModel);


        if(updateCustomer){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "UPDATED SUCCESSFULLY", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllCustomers();
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }

    }

    public void onaction_Remove(ActionEvent actionEvent) throws Exception {

        String id = txt_insId.getText();

        boolean deleteCustomer = deleteCustomer(id);
        if(deleteCustomer){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DELETED SUCCSESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllCustomers();
            setInstructor();

        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }

    }

    public void onaction_SearchID(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        InstructorsDTO searchCustomer = bo.searchInstructor1(txt_SearchId.getText());
        txt_insId.setText(searchCustomer.getId());
        txt_InsName.setText(searchCustomer.getName());
        txt_InsNic.setText(searchCustomer.getNic());
        txt_InsAddress.setText(searchCustomer.getAddress());
        txt_InsEmail.setText(searchCustomer.getEmail());
        txt_InsTp.setText(searchCustomer.getTp());

        txt_SearchId.clear();
    }

    public void onaction_SearchNIC(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        InstructorsDTO searchCustomer = bo.searchInstructor2(txt_SearchNic.getText());
        txt_insId.setText(searchCustomer.getId());
        txt_InsName.setText(searchCustomer.getName());
        txt_InsNic.setText(searchCustomer.getNic());
        txt_InsAddress.setText(searchCustomer.getAddress());
        txt_InsEmail.setText(searchCustomer.getEmail());
        txt_InsTp.setText(searchCustomer.getTp());

        txt_SearchNic.clear();
    }

    public void onaction_Clicked(MouseEvent mouseEvent) {

        InstructorsDTO selectedItem = table_Instructors.getSelectionModel().getSelectedItem();

        txt_insId.setText(selectedItem.getId());
        txt_InsName.setText(selectedItem.getName());
        txt_InsNic.setText(selectedItem.getNic());
        txt_InsAddress.setText(selectedItem.getAddress());
        txt_InsEmail.setText(selectedItem.getEmail() );
        txt_InsTp.setText(selectedItem.getTp() );
    }

    public void onaction_Clear(ActionEvent actionEvent) throws IOException {

        setAllClear();
        setInstructor();
    }




    private void setAllClear(){
        txt_insId.clear();
        txt_InsName.clear();
        txt_InsNic.clear();
        txt_InsEmail.clear();
        txt_InsAddress.clear();
        txt_InsTp.clear();



    }

    private void getAllCustomers() throws Exception {
        ArrayList<InstructorsDTO> customerList;
        try {
            customerList = bo.getAllInstructor();
            ObservableList<InstructorsDTO> customers = FXCollections.observableArrayList(customerList);
            table_Instructors.setItems(customers);
            table_Instructors.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_Instructors.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            table_Instructors.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
            table_Instructors.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
            table_Instructors.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
            table_Instructors.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("tp"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllCustomers();
            setInstructor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setInstructor() throws IOException {
        try {
            String customer;
            customer = IDGenerator.getNewID("instructors", "InstructorId ", "I");
            txt_insId.setText(customer);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            ex.printStackTrace();

        }
    }



}
