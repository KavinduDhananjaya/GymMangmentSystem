package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.MeasurmentDAO;
import lk.ijse.gymsystem.dto.MeasurmentDTO;
import lk.ijse.gymsystem.entity.Customer;
import lk.ijse.gymsystem.entity.Measurement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MeasurmentDAOImpl implements MeasurmentDAO {

    @Override
    public void CrudTest() {

    }

    @Override
    public boolean add(Measurement ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into Measurment values(?,?,?,?,?,?,?,?)", ref.getId(),ref.getDate(), ref.getHeight(),ref.getWeight(), ref.getChest(),ref.getWaist(),ref.getArm(),ref.getCalf());
    }

    @Override
    public boolean update(Measurement ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update Measurment set Date=? height=?,weight=?,chest=? ,waist=? ,waist=? ,arm=? ,calf=? where MeasurmentId=?", ref.getDate(),  ref.getHeight(),ref.getWeight(), ref.getChest(),ref.getWaist(),ref.getArm(),ref.getCalf(),ref.getId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from Measurment where MeasurmentId=?", id);
    }

    @Override
    public Measurement search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Measurment where MeasurmentId=?", id);
        if (rst.next()){
            return new Measurement(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getInt(5),
                    rst.getInt(6),
                    rst.getInt(7),
                    rst.getInt(8)
            );
        }
        return null;
    }

    @Override
    public Measurement search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<Measurement> getAll() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Measurement> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from Measurment");
        while (rst.next()){
            company.add(new Measurement(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getInt(4),
                    rst.getInt(5),
                    rst.getInt(6),
                    rst.getInt(7),
                    rst.getInt(8)
            ));
        }
        return company;
    }

    }

