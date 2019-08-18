package lk.ijse.gymsystem.bo.custom.impl;

import lk.ijse.gymsystem.bo.custom.MeasurmentBO;
import lk.ijse.gymsystem.dao.DAOFactory;

import lk.ijse.gymsystem.dao.custom.MeasurmentDAO;

import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.dto.MeasurmentDTO;

import lk.ijse.gymsystem.entity.Customer;
import lk.ijse.gymsystem.entity.Measurement;

import java.sql.SQLException;
import java.util.ArrayList;

public class MeasurmentBOImpl implements MeasurmentBO {

   MeasurmentDAO dao = (MeasurmentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEASURMENT);

    @Override
    public boolean addMeasurment(MeasurmentDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Measurement(ref.getId(),ref.getDate(), ref.getHeight(), ref.getWeight(), ref.getChest(),ref.getWaist(),ref.getArm(),ref.getCalf()));
    }

    @Override
    public boolean updateMeasurment(MeasurmentDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Measurement(ref.getId(),ref.getDate(), ref.getHeight(), ref.getWeight(), ref.getChest(),ref.getWaist(),ref.getArm(),ref.getCalf()));
    }

    @Override
    public boolean deleteMeasurment(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public MeasurmentDTO searchMeasurment(String id) throws SQLException, ClassNotFoundException {
        Measurement search = dao.search1(id);
        return new MeasurmentDTO(search.getId(),search.getDate(), search.getHeight(), search.getWeight(),search.getChest(),search.getWaist(),search.getArm(),search.getCalf());

    }

    @Override
    public ArrayList<MeasurmentDTO> getAllMeasurment() throws Exception {
        ArrayList<MeasurmentDTO> dtos = new ArrayList<>();
        ArrayList<Measurement> companies = dao.getAll();
        for (Measurement company: companies){
            dtos.add(new MeasurmentDTO(
                    company.getId(),
                    company.getDate(),
                    company.getHeight(),
                    company.getWeight(),
                    company.getChest(),
                    company.getWaist(),
                    company.getArm(),
                    company.getCalf()
            ));
        }
        return dtos;
    }
}
