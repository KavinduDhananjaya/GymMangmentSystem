package lk.ijse.gymsystem.bo.custom;

import lk.ijse.gymsystem.bo.SuperBO;

import lk.ijse.gymsystem.dto.MeasurmentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MeasurmentBO extends SuperBO {

    public  boolean addMeasurment(MeasurmentDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateMeasurment(MeasurmentDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean deleteMeasurment(String id) throws SQLException, ClassNotFoundException ;

    public MeasurmentDTO searchMeasurment(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<MeasurmentDTO> getAllMeasurment()throws Exception;
}
