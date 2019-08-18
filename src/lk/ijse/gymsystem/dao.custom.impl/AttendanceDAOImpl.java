package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.AttendanceDAO;
import lk.ijse.gymsystem.entity.Accessories;
import lk.ijse.gymsystem.entity.Attendance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAOImpl implements  AttendanceDAO{

    @Override
    public void CrudTest() {

    }

    @Override
    public boolean add(Attendance ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into Attendance values(?,?,?,?)", ref.getAttendanceId(), ref.getDate(), ref.getArrivaltime(), ref.getDepatureTime());
    }

    @Override
    public boolean update(Attendance ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update Attendance set Date=?,ArrivalTime =?,DepartureTime  =?  where AttendanceId =?",  ref.getAttendanceId(), ref.getDate(), ref.getArrivaltime(),ref.getDepatureTime());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from Attendance where AttendanceId =?", id);
    }

    @Override
    public Attendance search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Attendance where AttendanceId =?", id);
        if (rst.next()){
            return new Attendance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)

            );
        }
        return null;    }

    @Override
    public Attendance search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<Attendance> getAll() throws ClassNotFoundException, SQLException, Exception {

        ArrayList<Attendance> acc = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from Attendance");
        while (rst.next()){
            acc.add(new Attendance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ));
        }
        return acc;
    }

    @Override
    public List<Attendance> getAllAttendendces() throws Exception {

        return null;
    }
}
