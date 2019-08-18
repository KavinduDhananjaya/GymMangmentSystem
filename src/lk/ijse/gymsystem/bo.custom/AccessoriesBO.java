package lk.ijse.gymsystem.bo.custom;

import lk.ijse.gymsystem.bo.SuperBO;
import lk.ijse.gymsystem.dto.AccessoriesDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AccessoriesBO extends SuperBO {

    public  boolean addItem(AccessoriesDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateItem(AccessoriesDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean deleteItem(String id) throws SQLException, ClassNotFoundException ;

    public  AccessoriesDTO searchItem(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<AccessoriesDTO> getAllAccessories()throws Exception;
}
