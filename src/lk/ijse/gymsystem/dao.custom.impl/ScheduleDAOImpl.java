package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.ScheduleDAO;
import lk.ijse.gymsystem.entity.Attendance;
import lk.ijse.gymsystem.entity.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleDAOImpl implements ScheduleDAO {



    @Override
    public void CrudTest() {

    }

    @Override
    public boolean add(Schedule ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into Shedule values(?,?,?,?,?)", ref.getScheduleId(), ref.getMeasurmentId(), ref.getInstructorId(), ref.getCustomerId(),ref.getDescription());
    }

    @Override
    public boolean update(Schedule ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update Shedule set MeasurmentId =?,InstructorId =?,CustomerId =? ,Discription =? where SheduleId =?",  ref.getMeasurmentId(), ref.getInstructorId(), ref.getCustomerId(),ref.getDescription(),ref.getScheduleId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from Shedule where ScheduleId=?", id);
    }

    @Override
    public Schedule search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Shedule where ScheduleId =?", id);
        if (rst.next()){
            return new Schedule(
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
    public Schedule search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<Schedule> getAll() throws ClassNotFoundException, SQLException, Exception {

        ArrayList<Schedule> acc = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from Shedule");
        while (rst.next()){
            acc.add(new Schedule(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            ));
        }
        return acc;
    }

}
