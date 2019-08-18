package lk.ijse.gymsystem.bo.custom;

import lk.ijse.gymsystem.bo.SuperBO;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import lk.ijse.gymsystem.tableModel.AttendendTM;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public interface QueryBO extends SuperBO {

    public List<AttendendTM> getAllAttendence(String memberID)throws Exception;
}
