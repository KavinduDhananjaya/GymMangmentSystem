package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gymsystem.bo.BOFactory;
import lk.ijse.gymsystem.bo.custom.CustomerBO;
import lk.ijse.gymsystem.bo.custom.PaymentBO;
import lk.ijse.gymsystem.common.IDGenerator;
import lk.ijse.gymsystem.db.DBConnection;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.dto.PaymentDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class PaymentViewController implements Initializable {

    @FXML
    private AnchorPane payment_pane;

    @FXML
    private JFXTextField txt_CustomerId;

    @FXML
    private JFXTextField txt_customerName;

    @FXML
    private JFXTextField txt_PaymentId;

    @FXML
    private JFXTextField txt_Date;

    @FXML
    private JFXTextField txt_amount;

    @FXML
    private JFXTextField txt_Diuration;

    @FXML
    private TextArea txt_Desc;

    @FXML
    private JFXTextField txt_cash;

    @FXML
    private JFXTextField txt_balance;

    @FXML
    private TableView<PaymentDTO> tbl_Payment;

    static PaymentBO bo = (PaymentBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.PAYMENT);

    public static boolean addPayment(PaymentDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addPayment(ref);
    }

    public static boolean updateCustomer(PaymentDTO ref) throws SQLException, ClassNotFoundException {
        return bo.updatePayment(ref);
    }

    public static boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo.deletePayment(id);
    }



    static CustomerBO bo2 = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CUSTOMER);

    public static CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo2.searchCustomer(id);
    }

    public void onaction_Search2() throws SQLException, ClassNotFoundException {

        CustomerDTO searchCustomer = bo2.searchCustomer(txt_CustomerId.getText());
        txt_customerName.setText(searchCustomer.getName());

    }





    public void onaction_Proceed(ActionEvent actionEvent) throws Exception {

        String pid=txt_PaymentId.getText();
        String cid=txt_CustomerId.getText();
        String date=txt_Date.getText();
        Double amount=Double.parseDouble(txt_amount.getText());
        String desc=txt_Desc.getText();

        PaymentDTO payModel = new PaymentDTO(pid, cid, date, amount,desc);
        boolean add = PaymentViewController.addPayment(payModel);

        if(add){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "PAYMENT COMPLETED ", ButtonType.OK);
            a.showAndWait();
            getAll();
            setPayments();
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }

    }

    private void setOrderDate() {
        txt_Date.setText(LocalDate.now().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setOrderDate();
        try {
            setOrderDate();
            getAll();
            setPayments();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void request2(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        txt_customerName.requestFocus();
        onaction_Search2();

    }

    public void request3(ActionEvent actionEvent) {

        txt_Date.requestFocus();
    }

    public void request1(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        txt_CustomerId.requestFocus();
        onaction_Search2();
    }

    public void request6(ActionEvent actionEvent) {

        txt_Desc.requestFocus();
    }

    public void request5(ActionEvent actionEvent) {

        txt_amount.requestFocus();
    }

    public void request4(ActionEvent actionEvent) {

        txt_Diuration.requestFocus();
    }



    private void getAll() throws Exception {
        ArrayList<PaymentDTO> customerList;
        try {
            customerList = bo.getAllCustomers();
            ObservableList<PaymentDTO> customers = FXCollections.observableArrayList(customerList);
            tbl_Payment.setItems(customers);
            tbl_Payment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("pid"));
            tbl_Payment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
            tbl_Payment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cid"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onaction_Clicked(MouseEvent Event) throws SQLException, ClassNotFoundException {

        PaymentDTO selectedItem = tbl_Payment.getSelectionModel().getSelectedItem();

        txt_PaymentId.setText(selectedItem.getPid());
        txt_CustomerId.setText(selectedItem.getCid());
        onaction_Search2();
//        txt_customerName.setText(selectedItem.getAddress());
        txt_Date.setText(selectedItem.getDate() );
//        txt_Diuration.setText(selectedItem.get() );
        txt_amount.setText(selectedItem.getAmount()+"");
        txt_Desc.setText(selectedItem.getDiscroption() );

    }

    public void onaction_Print(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, JRException {

    }


    private void setPayments() throws IOException {
        try {
            String customer;
            customer = IDGenerator.getNewID("payment", "PaymentId ", "P");
            txt_PaymentId.setText(customer);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            ex.printStackTrace();

        }
    }

    public void calculate(ActionEvent actionEvent) {


        Integer amount=Integer.parseInt(txt_amount.getText()) ;
        Integer cash=Integer.parseInt(txt_cash.getText()) ;

        Integer balance=cash-amount;

        txt_balance.setText(balance+"");


    }
}
