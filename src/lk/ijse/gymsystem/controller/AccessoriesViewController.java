package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
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
import lk.ijse.gymsystem.bo.custom.AccessoriesBO;
import lk.ijse.gymsystem.common.IDGenerator;
import lk.ijse.gymsystem.dto.AccessoriesDTO;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AccessoriesViewController implements Initializable {

    @FXML
    private JFXTextField txt_Type;

    @FXML
    private JFXTextField txt_Id;

    @FXML
    private JFXTextField txt_Brand;

    @FXML
    private JFXButton txt_Search;

    @FXML
    private JFXTextField txt_Count;

    @FXML
    private JFXTextField txt_Date;

    @FXML
    private TableView<AccessoriesDTO> table_Accessories;

    @FXML
    private TextField search;

    @FXML
    private JFXTextField txt_Time;



    static AccessoriesBO bo = (AccessoriesBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.ACCESSORIES);

    public static boolean addItem(AccessoriesDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addItem(ref);
    }

    public static boolean updateItem(AccessoriesDTO ref) throws SQLException, ClassNotFoundException {
        return bo.updateItem(ref);
    }

    public static boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return bo.deleteItem(id);
    }

    public static AccessoriesDTO searchItem(String id) throws SQLException, ClassNotFoundException {
        return bo.searchItem(id);
    }




    public void onaction_Add(ActionEvent actionEvent) throws Exception {

        String type=txt_Type.getText();
        String id=txt_Id.getText();
        String brand=txt_Brand.getText();
        String date=txt_Date.getText();


        AccessoriesDTO cusModel = new AccessoriesDTO(type, id, brand, date);
        boolean addItem = AccessoriesViewController.addItem(cusModel);

        if(addItem){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAccessories();
            setItem();

        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }


    }

    public void onaction_Update(ActionEvent actionEvent) throws Exception {

        String type=txt_Type.getText();
        String id=txt_Id.getText();
        String brand=txt_Brand.getText();
        Integer count=Integer.parseInt(txt_Count.getText()) ;
        String date=txt_Date.getText();

        AccessoriesDTO cusModel = new AccessoriesDTO(type, id, brand, date);
        boolean updateItem =AccessoriesViewController.updateItem(cusModel);


        if(updateItem){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "UPDATED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAccessories();
            setItem();

        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();

        }
    }




    public void onaction_Remove(ActionEvent actionEvent) throws Exception {

        String id = txt_Id.getText();

        boolean deleteItem = deleteItem(id);
        if(deleteItem){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "DELETED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAccessories();
            setItem();

        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }




    private void setAllClear(){
        txt_Type.clear();
        txt_Id.clear();
        txt_Brand.clear();
        txt_Date.clear();




    }

    private void getAllAccessories() throws Exception {
        ArrayList<AccessoriesDTO> accessoriesList;
        try {
            accessoriesList = bo.getAllAccessories();
            ObservableList<AccessoriesDTO> accessory = FXCollections.observableArrayList(accessoriesList);
            table_Accessories.setItems(accessory);
            table_Accessories.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("type"));
            table_Accessories.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_Accessories.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("brand"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllAccessories();
            setDate();
            setTime();
            setItem();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onaction_SearchId(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        AccessoriesDTO searchItem = bo.searchItem(search.getText());
        txt_Type.setText(searchItem.getType() );
        txt_Id.setText(searchItem.getId());
        txt_Brand.setText(searchItem.getBrand());
        txt_Date.setText(searchItem.getDate());

        search.clear();

    }

    public void ocaction_Clicked(MouseEvent mouseEvent) {
        AccessoriesDTO selectedItem = table_Accessories.getSelectionModel().getSelectedItem();

        txt_Type.setText(selectedItem.getType());
        txt_Id.setText(selectedItem.getId());
        txt_Brand.setText(selectedItem.getBrand());
        txt_Date.setText(selectedItem.getDate() );
    }

    private void setDate() {
        txt_Date.setText(LocalDate.now().toString());
    }


    private void setTime() {
        txt_Time.setText(LocalTime.now().toString());
    }

    private void setItem() throws IOException {
        try {
            String id;
            id = IDGenerator.getNewID("accessories", "AccessoryId ", "A");
            txt_Id.setText(id);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            ex.printStackTrace();

        }
    }

}
