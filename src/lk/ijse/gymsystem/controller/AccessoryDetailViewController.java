package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.gymsystem.dto.CustomerDTO;

public class AccessoryDetailViewController {


    @FXML
    private JFXTextField txt_MemberId;

    @FXML
    private JFXTextField txt_Name;

    @FXML
    private JFXTextField txt_AccessryId;

    @FXML
    private JFXTextField txt_AccessoryType;

    @FXML
    private JFXButton btn_Register;

    @FXML
    private JFXButton btn_Update;

    @FXML
    private JFXButton btn_remove;

    @FXML
    private TextField txt_SearchId;

    @FXML
    private TableView<CustomerDTO> tbl_Accessory;


    public void onaction_Register(ActionEvent actionEvent) {

        String memberId=txt_MemberId.getText();
        String memberName=txt_Name.getText();
        String accId=txt_AccessryId.getText();
        String accType=txt_AccessoryType.getText();



    }

    public void onaction_Update(ActionEvent actionEvent) {

    }

    public void onaction_Remove(ActionEvent actionEvent) {

    }
}
