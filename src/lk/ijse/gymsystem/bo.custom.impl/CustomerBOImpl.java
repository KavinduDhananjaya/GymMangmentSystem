package lk.ijse.gymsystem.bo.custom.impl;

import lk.ijse.gymsystem.bo.custom.CustomerBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.CustomerDAO;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {



    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);



    @Override
    public boolean addCustomer(CustomerDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Customer(ref.getId(), ref.getName(), ref.getAddress(), ref.getEmail(),ref.getTel()));

    }

    @Override
    public boolean updateCustomer(CustomerDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Customer(ref.getId(), ref.getName(), ref.getAddress(), ref.getEmail(),ref.getTel()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer search = dao.search1(id);
        return new CustomerDTO(search.getId(), search.getName(), search.getAddress(),search.getEmail(),search.getTel());
    }


    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        ArrayList<Customer> companies = dao.getAll();
        for (Customer company: companies){
            dtos.add(new CustomerDTO(
                    company.getId(),
                    company.getName(),
                    company.getAddress(),
                    company.getEmail(),
                    company.getTel()
            ));
        }
        return dtos;
    }



}
