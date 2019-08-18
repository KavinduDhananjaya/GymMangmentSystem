package lk.ijse.gymsystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gymsystem.bo.BOFactory;
import lk.ijse.gymsystem.bo.custom.AttendanceBO;
import lk.ijse.gymsystem.bo.custom.CustomerBO;
import lk.ijse.gymsystem.bo.custom.QueryBO;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import lk.ijse.gymsystem.dto.CustomDTO;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.dto.InstructorsDTO;
import lk.ijse.gymsystem.entity.Attendance;
import lk.ijse.gymsystem.entity.CustomEntity;
import lk.ijse.gymsystem.tableModel.AttendendTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AttendanceDetailViewController implements Initializable {

    @FXML
    private TableView<AttendendTM> tbl_detail2;

    @FXML
    private TextField txt_search2;

    @FXML
    private JFXTextField txt_SearchName2;

    @FXML
    private TableView<AttendendTM> tbl_detail1;

    @FXML
    private TextField txt_search1;

    @FXML
    private JFXTextField txt_SeachSid;

    @FXML
    private JFXTextField txt_SeachName1;

    static CustomerBO bo2 = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CUSTOMER);

    public static CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo2.searchCustomer(id);
    }

    public void Search() throws SQLException, ClassNotFoundException {

        CustomerDTO searchCustomer = bo2.searchCustomer(txt_search2.getText());
        txt_SearchName2.setText(searchCustomer.getName());

    }



    private QueryBO queryBO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        queryBO = (QueryBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.QUERY);

    }
    private  void loadAttendenceById(String memberID){


        try {
            List<AttendendTM> allAttendence = queryBO.getAllAttendence(memberID);
            ObservableList<AttendendTM> attendendTMS = FXCollections.observableArrayList(allAttendence);
            tbl_detail2.setItems(attendendTMS);
            tbl_detail2.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("date"));
            tbl_detail2.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("arrivaltime"));
            tbl_detail2.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("depatureTime"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void onaction_Search2(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        Search();
        String memberId = txt_search2.getText();
        loadAttendenceById(memberId);

    }
}
