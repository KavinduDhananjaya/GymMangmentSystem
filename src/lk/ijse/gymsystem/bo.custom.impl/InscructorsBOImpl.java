package lk.ijse.gymsystem.bo.custom.impl;

import lk.ijse.gymsystem.bo.custom.InstructorsBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.CustomerDAO;
import lk.ijse.gymsystem.dao.custom.InstructorsDAO;
import lk.ijse.gymsystem.dto.AccessoriesDTO;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.dto.InstructorsDTO;
import lk.ijse.gymsystem.entity.Customer;
import lk.ijse.gymsystem.entity.Instructors;

import java.sql.SQLException;
import java.util.ArrayList;

public class InscructorsBOImpl implements InstructorsBO {

    InstructorsDAO dao = (InstructorsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INSTRUCTOR);

    @Override
    public boolean addInstructor(InstructorsDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Instructors(ref.getId(), ref.getName(), ref.getNic(), ref.getAddress(),ref.getEmail(),ref.getTp()));
    }

    @Override
    public boolean updateInstructor(InstructorsDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Instructors(ref.getId(), ref.getName(), ref.getNic(), ref.getAddress(),ref.getEmail(),ref.getTp()));
    }

    @Override
    public boolean deleteInstructor(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public InstructorsDTO searchInstructor1(String id) throws SQLException, ClassNotFoundException {
        Instructors search = dao.search1(id);
        return new InstructorsDTO(search.getId(), search.getName(), search.getNic(), search.getAddress(),search.getEmail(),search.getTp());
    }

    @Override
    public InstructorsDTO searchInstructor2(String id) throws SQLException, ClassNotFoundException {
        Instructors search = dao.search2(id);
        return new InstructorsDTO(search.getId(), search.getName(), search.getNic(), search.getAddress(),search.getEmail(),search.getTp());

    }

    @Override
    public ArrayList<InstructorsDTO> getAllInstructor() throws Exception {
        ArrayList<InstructorsDTO> dtos = new ArrayList<>();
        ArrayList<Instructors> companies = dao.getAll();
        for (Instructors company: companies){
            dtos.add(new InstructorsDTO(
                    company.getId(),
                    company.getName(),
                    company.getNic(),
                    company.getAddress(),
                    company.getEmail(),
                    company.getTp()
            ));
        }
        return dtos;
    }
}
