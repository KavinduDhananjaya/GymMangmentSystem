package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.PaymentDAO;
import lk.ijse.gymsystem.entity.Customer;
import lk.ijse.gymsystem.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public void CrudTest() {

    }

    @Override
    public boolean add(Payment ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into Payment values(?,?,?,?,?)", ref.getPid(), ref.getCid(), ref.getDate(), ref.getAmount(),ref.getDiscroption());
    }

    @Override
    public boolean update(Payment ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update Payment set customerID=?,paymentdate=?,amount=? ,disciption=? where paymentId=?",  ref.getCid(), ref.getDate(), ref.getAmount(),ref.getDiscroption(),ref.getPid());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from Payment where paymentId=?", id);
    }

    @Override
    public Payment search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Payment where PaymentId=?", id);
        if (rst.next()){
            return new Payment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getString(5)
            );
        }
        return null;
    }

    @Override
    public Payment search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }



    @Override
    public ArrayList<Payment> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Payment> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from payment");
        while (rst.next()){
            company.add(new Payment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getString(5)
            ));
        }
        return company;
    }
}
