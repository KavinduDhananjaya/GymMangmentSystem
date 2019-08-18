package lk.ijse.gymsystem.dao.custom;

import lk.ijse.gymsystem.dao.SuperDAO;
import lk.ijse.gymsystem.entity.Attendance;
import lk.ijse.gymsystem.entity.CustomEntity;
import lk.ijse.gymsystem.tableModel.AttendendTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {

    public ArrayList<AttendendTM> getAllAttendence(String memberID)throws Exception;
}
