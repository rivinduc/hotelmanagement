package lk.ijse.cmjd.fx.business;

import lk.ijse.cmjd.fx.dao.custom.CustomerDAO;
import lk.ijse.cmjd.fx.dao.DAOFactory;
import lk.ijse.cmjd.fx.dto.CustomerDTO;
import lk.ijse.cmjd.fx.entity.Customer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ManageCustomersBusiness {

    static CustomerDAO customerDAO= (CustomerDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.CUSTOMER);

    public static List<CustomerDTO> getCustomers() throws Exception {
        List<Customer> allCustomers = customerDAO.findAll();
        List<CustomerDTO> tmpDTOs = new ArrayList<>();
        for (Customer customer : allCustomers) {
            CustomerDTO dto = new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getEmail(),
                    customer.getDays(),
                    customer.getDate2().toLocalDate(),
                    customer.getDate1().toLocalDate(),
                    customer.getRn(),
                    customer.getDaysi(),
                    customer.getF1(),
                    customer.getF3(),
                    customer.getF2(),
                    customer.getLabel31()
            );
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }

    public static boolean createCustomer(CustomerDTO dto) throws Exception {
        Customer customer = new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getDays(),
                Date.valueOf(dto.getDate2()),
                Date.valueOf(dto.getDate1()),
                dto.getRn(),
                dto.getDaysi(),
                dto.getF1(),
                dto.getF3(),
                dto.getF2(),
                dto.getLabel31()
        );
        return customerDAO.save(customer);
    }

    public static boolean updateCustomer(CustomerDTO dto) throws Exception {
        Customer customer = new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getDays(),
                Date.valueOf(dto.getDate2()),
                Date.valueOf(dto.getDate1()),
                dto.getRn(),
                dto.getDaysi(),
                dto.getF1(),
                dto.getF3(),
                dto.getF2(),
                dto.getLabel31()

        );
        return customerDAO.update(customer);
    }

    public static boolean deleteCustomer(String customerID) throws Exception {
        return customerDAO.delete(customerID);
    }

    public static CustomerDTO findCustomer(String id) throws Exception {
        Customer customer = customerDAO.find(id);
        if (customer != null) {
            return new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getEmail(),
                    customer.getDays(),
                    customer.getDate2().toLocalDate(),
                    customer.getDate1().toLocalDate(),
                    customer.getRn(),
                    customer.getDaysi(),
                    customer.getF1(),
                    customer.getF3(),
                    customer.getF2(),
                    customer.getLabel31()
            );
        }
        return null;
    }

}
