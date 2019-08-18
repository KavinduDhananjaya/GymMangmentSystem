package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.gymsystem.bo.BOFactory;
import lk.ijse.gymsystem.bo.custom.CustomerBO;
import lk.ijse.gymsystem.bo.custom.impl.CustomerBOImpl;
import lk.ijse.gymsystem.common.IDGenerator;
import lk.ijse.gymsystem.dto.CustomerDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MemberViewController implements Initializable {

    @FXML
    private JFXTextField txt_CustId;

    @FXML
    private JFXTextField txt_CustName;

    @FXML
    private JFXTextField txt_CustAddress;

    @FXML
    private JFXTextField txt_Email;

    @FXML
    private JFXTextField txt_Tel;

    @FXML
    private JFXButton btn_Register;

    @FXML
    private JFXButton btn_Update;

    @FXML
    private JFXButton btn_remove;

    @FXML
    private JFXTextField txt_searchId;

    @FXML
    private JFXTextField txt_searchName;

    @FXML
    private JFXRadioButton radio1;

    @FXML
    private JFXRadioButton radio2;

    @FXML
    private JFXButton btn_Clear;



    @FXML
    private TableView<CustomerDTO> table_Customer;


    static CustomerBO bo = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CUSTOMER);

    public static boolean addCustomer(CustomerDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addCustomer(ref);
    }

    public static boolean updateCustomer(CustomerDTO ref) throws SQLException, ClassNotFoundException {
        return bo.updateCustomer(ref);
    }

    public static boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo.deleteCustomer(id);
    }


    public static CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo.searchCustomer(id);
    }




    public void onaction_Register(ActionEvent actionEvent) throws Exception {



        String id = txt_CustId.getText();
        String name = txt_CustName.getText();
        String address = txt_CustAddress.getText();
        String email = txt_Email.getText();
        String tel = txt_Tel.getText();

        CustomerDTO cusModel = new CustomerDTO(id, name, address, email, tel);
        boolean addCustomer = MemberViewController.addCustomer(cusModel);

        if(addCustomer){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllCustomers();
            setcustomer();



        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }



    }

    public void onaction_Update(ActionEvent actionEvent) throws Exception {
        String id = txt_CustId.getText();
        String name = txt_CustName.getText();
        String address = txt_CustAddress.getText();
        String email = txt_Email.getText();
        String tel = txt_Tel.getText();

        CustomerDTO cusModel = new CustomerDTO(id, name, address, email,tel);
        boolean updateCustomer = MemberViewController.updateCustomer(cusModel);


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
        String id = txt_CustId.getText();

        boolean deleteCustomer = deleteCustomer(id);
        if(deleteCustomer){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DELETED SUCCSESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllCustomers();
            setcustomer();
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }

    }


    private void setAllClear(){
        txt_CustId.clear();
        txt_CustName.clear();
        txt_CustAddress.clear();
        txt_Tel.clear();
        txt_Email.clear();



    }

    private void getAllCustomers() throws Exception {
        ArrayList<CustomerDTO> customerList;
        try {
            customerList = bo.getAllCustomers();
            ObservableList<CustomerDTO> customers = FXCollections.observableArrayList(customerList);
            table_Customer.setItems(customers);
            table_Customer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_Customer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            table_Customer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
            table_Customer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("email"));
            table_Customer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("tel"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllCustomers();
            setcustomer();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onaction_SearchID(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        CustomerDTO searchCustomer = bo.searchCustomer(txt_searchId.getText());
        txt_CustId.setText(searchCustomer.getId());
        txt_CustName.setText(searchCustomer.getName());
        txt_CustAddress.setText(searchCustomer.getAddress());
        txt_Email.setText(searchCustomer.getEmail());
        txt_Tel.setText(searchCustomer.getTel());

    }

    public void onaction_Clicked(MouseEvent Event) {

        CustomerDTO selectedItem = table_Customer.getSelectionModel().getSelectedItem();

        txt_CustId.setText(selectedItem.getId());
        txt_CustName.setText(selectedItem.getName());
        txt_CustAddress.setText(selectedItem.getAddress());
        txt_Email.setText(selectedItem.getEmail());
        txt_Tel.setText(selectedItem.getTel() );
    }

    public void onaction_Clear(ActionEvent actionEvent) throws IOException {
        setAllClear();
        setcustomer();
    }

    private void setcustomer() throws IOException {
        try {
            String customer;
            customer = IDGenerator.getNewID("customer", "CustomerId ", "C");
            txt_CustId.setText(customer);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            ex.printStackTrace();

        }
    }

}
