package lk.ijse.gymsystem.bo.custom;

import lk.ijse.gymsystem.bo.SuperBO;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.dto.ScheduleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ScheduleBO extends SuperBO {

    public  boolean addSchedule(ScheduleDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateSchedule(ScheduleDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean deleteSchedule(String id) throws SQLException, ClassNotFoundException ;

    public  ScheduleDTO searchSchedule(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<ScheduleDTO> getAllSchedule()throws Exception;
}
