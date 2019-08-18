package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.CustomerDAO;
import lk.ijse.gymsystem.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public void CrudTest() {

    }

    @Override
    public boolean add(Customer ref) throws ClassNotFoundException, SQLException {

        return CrudUtil.executeUpdate("Insert into Customer values(?,?,?,?,?)", ref.getId(), ref.getName(), ref.getAddress(), ref.getEmail(),ref.getTel());
    }

    @Override
    public boolean update(Customer ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update Customer set customerName=?,customerAddress=?,customerEmail=? ,customerTel=? where customerId=?",  ref.getName(), ref.getAddress(), ref.getEmail(),ref.getTel(),ref.getId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from Customer where CustomerId=?", id);
    }

    @Override
    public Customer search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Customer where CustomerId=?", id);
        if (rst.next()){
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }
        return null;
    }

    @Override
    public Customer search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }


    @Override
    public ArrayList<Customer> getAll() throws Exception {
            ArrayList<Customer> company = new ArrayList<>();
            ResultSet rst = CrudUtil.executeQuery("Select * from customer");
            while (rst.next()){
                company.add(new Customer(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5)
                ));
            }
            return company;
    }
}
