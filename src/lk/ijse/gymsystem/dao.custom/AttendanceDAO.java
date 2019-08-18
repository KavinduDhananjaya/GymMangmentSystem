package lk.ijse.gymsystem.dao.custom;

import lk.ijse.gymsystem.dao.CrudDAO;
import lk.ijse.gymsystem.entity.Accessories;
import lk.ijse.gymsystem.entity.Attendance;

import java.util.List;

public interface AttendanceDAO extends CrudDAO<Attendance, String> {

    public List<Attendance> getAllAttendendces() throws Exception;
}
