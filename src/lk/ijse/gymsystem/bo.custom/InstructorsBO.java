/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymsystem.bo.custom;

import lk.ijse.gymsystem.bo.SuperBO;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.dto.InstructorsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InstructorsBO extends SuperBO {


    public  boolean addInstructor(InstructorsDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateInstructor(InstructorsDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean deleteInstructor(String id) throws SQLException, ClassNotFoundException ;

    public  InstructorsDTO searchInstructor1(String id) throws SQLException, ClassNotFoundException;

    public  InstructorsDTO searchInstructor2(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<InstructorsDTO> getAllInstructor()throws Exception;
}
