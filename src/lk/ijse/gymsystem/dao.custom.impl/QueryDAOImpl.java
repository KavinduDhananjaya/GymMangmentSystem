package lk.ijse.gymsystem.dao.custom.impl;

import lk.ijse.gymsystem.dao.CrudUtil;
import lk.ijse.gymsystem.dao.custom.QueryDAO;
import lk.ijse.gymsystem.entity.CustomEntity;
import lk.ijse.gymsystem.tableModel.AttendendTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<AttendendTM> getAllAttendence(String memberID) throws Exception {

        ResultSet rst = CrudUtil.executeQuery("SELECT a.DATE ,a.ArrivalTime, " +
                "a.DepartureTime FROM attendance a,customer c WHERE c.CustomerId = ?", memberID);


        ArrayList<AttendendTM> allDetails = new ArrayList<>();
        while (rst.next()) {
            allDetails.add(new AttendendTM(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)

            ));
        }
        return allDetails;
    }
}
