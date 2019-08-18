package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.AccessoriesDAO;
import lk.ijse.gymsystem.entity.Accessories;
import lk.ijse.gymsystem.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccessoriesDAOImpl implements AccessoriesDAO {
    @Override
    public void CrudTest() {

    }

    @Override
    public boolean add(Accessories ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into Accessories values(?,?,?,?)", ref.getType(), ref.getId(), ref.getBrand(),ref.getDate());
    }

    @Override
    public boolean update(Accessories ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update Accessories set AccessoryType=?,AccessoryBrand=?,date=?  where AccessoryId=?",  ref.getType(), ref.getBrand(),ref.getDate(),ref.getId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from Accessories where AccessoryId=?", id);
    }

    @Override
    public Accessories search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Accessories where AccessoryId=?", id);
        if (rst.next()){
            return new Accessories(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)

            );
        }
        return null;
    }


    @Override
    public Accessories search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<Accessories> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Accessories> acc = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from Accessories");
        while (rst.next()){
            acc.add(new Accessories(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ));
        }
        return acc;
    }
}
