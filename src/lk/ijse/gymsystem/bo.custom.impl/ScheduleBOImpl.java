package lk.ijse.gymsystem.bo.custom.impl;

import lk.ijse.gymsystem.bo.custom.ScheduleBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.ScheduleDAO;
import lk.ijse.gymsystem.dto.ScheduleDTO;
import lk.ijse.gymsystem.entity.Schedule;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleBOImpl implements ScheduleBO {

    ScheduleDAO dao = (ScheduleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SCHEDULE);


    @Override
    public boolean addSchedule(ScheduleDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Schedule(ref.getScheduleId(), ref.getMeasurmentId(), ref.getInstructorId(), ref.getCustomerId(),ref.getDescription()));
    }

    @Override
    public boolean updateSchedule(ScheduleDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Schedule(ref.getScheduleId(), ref.getMeasurmentId(), ref.getInstructorId(), ref.getCustomerId(),ref.getDescription()));
    }

    @Override
    public boolean deleteSchedule(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public ScheduleDTO searchSchedule(String id) throws SQLException, ClassNotFoundException {
        Schedule search = dao.search1(id);
        return new ScheduleDTO(search.getScheduleId(),search.getMeasurmentId(), search.getInstructorId(), search.getCustomerId(),search.getDescription());
    }

    @Override
    public ArrayList<ScheduleDTO> getAllSchedule() throws Exception {
        ArrayList<ScheduleDTO> dtos = new ArrayList<>();
        ArrayList<Schedule> companies = dao.getAll();
        for (Schedule company: companies){
            dtos.add(new ScheduleDTO(
                    company.getScheduleId(),
                    company.getMeasurmentId() ,
                    company.getInstructorId(),
                    company.getCustomerId(),
                    company.getDescription()

            ));
        }
        return dtos;    }
}
