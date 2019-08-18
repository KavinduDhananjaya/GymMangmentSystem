package lk.ijse.gymsystem.bo.custom.impl;

import lk.ijse.gymsystem.bo.custom.AttendanceBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.AccessoriesDAO;
import lk.ijse.gymsystem.dao.custom.AttendanceDAO;
import lk.ijse.gymsystem.dto.AccessoriesDTO;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import lk.ijse.gymsystem.entity.Accessories;
import lk.ijse.gymsystem.entity.Attendance;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceBOImpl implements AttendanceBO {

    AttendanceDAO dao = (AttendanceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ATTENDANCE);

       @Override
    public boolean addAttendance(AttendanceDTO ref) throws ClassNotFoundException, SQLException {
           return dao.add(new Attendance(ref.getAttendanceId(), ref.getDate(), ref.getArrivaltime(), ref.getDepatureTime()));
    }

    @Override
    public boolean updateAttendance(AttendanceDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Attendance(ref.getAttendanceId(), ref.getDate(), ref.getArrivaltime(), ref.getDepatureTime()));
    }

    @Override
    public boolean deleteAttendance(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public AttendanceDTO searchAttendance(String id) throws SQLException, ClassNotFoundException {
        Attendance search = dao.search1(id);
        return new AttendanceDTO(search.getAttendanceId(), search.getDate(),search.getArrivaltime(),search.getDepatureTime());
    }

    @Override
    public ArrayList<AttendanceDTO> getAllAttendance() throws Exception {
        ArrayList<AttendanceDTO> dtos = new ArrayList<>();
        ArrayList<Attendance> accessory = dao.getAll();
        for (Attendance acc: accessory){
            dtos.add(new AttendanceDTO(
                    acc.getAttendanceId(),
                    acc.getDate(),
                    acc.getArrivaltime(),
                    acc.getDepatureTime()

            ));
        }
        return dtos;    }
}
