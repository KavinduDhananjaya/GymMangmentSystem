package lk.ijse.gymsystem.bo.custom.impl;

import lk.ijse.gymsystem.bo.custom.AccessoriesBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.AccessoriesDAO;
import lk.ijse.gymsystem.dao.custom.CustomerDAO;
import lk.ijse.gymsystem.dto.AccessoriesDTO;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.entity.Accessories;
import lk.ijse.gymsystem.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccessoriesBOImpl implements AccessoriesBO {


    AccessoriesDAO dao = (AccessoriesDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ACCESSORIES);

    @Override
    public boolean addItem(AccessoriesDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Accessories(ref.getType(), ref.getId(), ref.getBrand(),ref.getDate()));

    }

    @Override
    public boolean updateItem(AccessoriesDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Accessories(ref.getType(), ref.getId(), ref.getBrand(),ref.getDate()));
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public AccessoriesDTO searchItem(String id) throws SQLException, ClassNotFoundException {
        Accessories search = dao.search1(id);
        return new AccessoriesDTO(search.getType(), search.getId(),search.getBrand(),search.getDate());

    }

    @Override
    public ArrayList<AccessoriesDTO> getAllAccessories() throws Exception {
        ArrayList<AccessoriesDTO> dtos = new ArrayList<>();
        ArrayList<Accessories> accessory = dao.getAll();
        for (Accessories acc: accessory){
            dtos.add(new AccessoriesDTO(
                    acc.getType(),
                    acc.getId(),
                    acc.getBrand(),
                    acc.getDate()
            ));
        }
        return dtos;
    }

}
