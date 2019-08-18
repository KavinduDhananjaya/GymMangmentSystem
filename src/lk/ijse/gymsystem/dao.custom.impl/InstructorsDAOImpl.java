package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.InstructorsDAO;
import lk.ijse.gymsystem.entity.Instructors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorsDAOImpl  implements InstructorsDAO {
    @Override
    public void CrudTest() {

    }

    @Override
    public boolean add(Instructors ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into Instructors values(?,?,?,?,?,?)", ref.getId(), ref.getName(), ref.getNic(), ref.getAddress(),ref.getEmail(),ref.getTp());
    }

    @Override
    public boolean update(Instructors ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update Instructors set InstructorName=?,InstructorNIC=?,InstructorAddress=? ,InstructorEmail=?,InstructorTp where InsrtuctorId=?",  ref.getName(), ref.getNic(), ref.getAddress(),ref.getEmail(),ref.getTp(),ref.getId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from Instructors where InstructorId=?", id);
    }

    @Override
    public Instructors search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Instructors where InstructorId=?", id);
        if (rst.next()){
            return new Instructors(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        }
        return null;
    }

    @Override
    public Instructors search2(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Instructors where InstructorNIC=?", id);
        if (rst.next()){
            return new Instructors(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Instructors> getAll() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Instructors> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from Instructors");
        while (rst.next()){
            company.add(new Instructors(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return company;
    }
}
