package lk.ijse.gymsystem.bo.custom.impl;

import lk.ijse.gymsystem.bo.custom.PaymentBO;
import lk.ijse.gymsystem.dao.DAOFactory;
import lk.ijse.gymsystem.dao.custom.CustomerDAO;
import lk.ijse.gymsystem.dao.custom.PaymentDAO;
import lk.ijse.gymsystem.dto.CustomerDTO;
import lk.ijse.gymsystem.dto.PaymentDTO;
import lk.ijse.gymsystem.entity.Customer;
import lk.ijse.gymsystem.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO dao = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);

    @Override
    public boolean addPayment(PaymentDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Payment(ref.getPid() , ref.getCid(), ref.getDate(), ref.getAmount(),ref.getDiscroption()));

    }

    @Override
    public boolean updatePayment(PaymentDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Payment(ref.getPid(), ref.getCid(), ref.getDate(), ref.getAmount(),ref.getDiscroption()));
    }

    @Override
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public PaymentDTO searchPayment(String id) throws SQLException, ClassNotFoundException {
        Payment search = dao.search1(id);
        return new PaymentDTO(search.getPid(), search.getCid(), search.getDate(),search.getAmount(),search.getDiscroption());
    }

    @Override
    public ArrayList<PaymentDTO> getAllCustomers() throws Exception {
        ArrayList<PaymentDTO> dtos = new ArrayList<>();
        ArrayList<Payment> companies = dao.getAll();
        for (Payment company: companies){
            dtos.add(new PaymentDTO(
                    company.getPid(),
                    company.getCid(),
                    company.getDate(),
                    company.getAmount(),
                    company.getDiscroption()
            ));
        }
        return dtos;
    }
}


