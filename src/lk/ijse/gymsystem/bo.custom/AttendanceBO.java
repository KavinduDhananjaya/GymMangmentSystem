package lk.ijse.gymsystem.bo.custom;

import lk.ijse.gymsystem.bo.SuperBO;
import lk.ijse.gymsystem.dto.AccessoriesDTO;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceBO extends SuperBO {

    public  boolean addAttendance(AttendanceDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateAttendance(AttendanceDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean deleteAttendance(String id) throws SQLException, ClassNotFoundException ;

    public  AttendanceDTO searchAttendance(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<AttendanceDTO> getAllAttendance()throws Exception;
}
