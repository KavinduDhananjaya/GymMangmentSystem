package lk.ijse.gymsystem.bo.custom.impl;

import lk.ijse.gymsystem.bo.custom.QueryBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.SuperDAO;
import lk.ijse.gymsystem.dao.custom.AttendanceDAO;
import lk.ijse.gymsystem.dao.custom.QueryDAO;
import lk.ijse.gymsystem.dto.AttendanceDTO;
import lk.ijse.gymsystem.entity.Attendance;
import lk.ijse.gymsystem.tableModel.AttendendTM;

import java.util.ArrayList;
import java.util.List;

public class QueryBOImpl implements QueryBO {
    QueryDAO queryDAO;

    public QueryBOImpl() {
        queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERYDAO);
    }

    @Override
    public List<AttendendTM> getAllAttendence(String memberID) throws Exception {
        return  queryDAO.getAllAttendence(memberID);

    }
}
