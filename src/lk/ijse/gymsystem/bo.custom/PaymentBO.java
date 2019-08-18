/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymsystem.bo.custom;

import lk.ijse.gymsystem.bo.SuperBO;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.dto.PaymentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {


    public  boolean addPayment(PaymentDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updatePayment(PaymentDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean deletePayment(String id) throws SQLException, ClassNotFoundException ;

    public  PaymentDTO searchPayment(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<PaymentDTO> getAllCustomers()throws Exception;
}
