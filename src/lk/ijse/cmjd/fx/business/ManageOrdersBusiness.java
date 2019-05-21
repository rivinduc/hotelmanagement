package lk.ijse.cmjd.fx.business;

import lk.ijse.cmjd.fx.dao.DAOFactory;
import lk.ijse.cmjd.fx.dao.custom.CustomerDAO;
import lk.ijse.cmjd.fx.dao.custom.OrderDAO;
import lk.ijse.cmjd.fx.dto.CustomerDTO;
import lk.ijse.cmjd.fx.dto.OrderDTO;
import lk.ijse.cmjd.fx.entity.Customer;
import lk.ijse.cmjd.fx.entity.Order;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static lk.ijse.cmjd.fx.business.ManageCustomersBusiness.customerDAO;

public class ManageOrdersBusiness {

    static OrderDAO orderDAO= (OrderDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.ORDER);

    public static List<OrderDTO> getOrder() throws Exception {
        List<Order> allOrder = orderDAO.findAll();
        List<OrderDTO> tmpDTOs = new ArrayList<>();
        for (Order order : allOrder) {
            OrderDTO dto = new OrderDTO(
                    order.getId(),
                    order.getCustomerId(),
                    order.getItemCode(),
                    order.getQtyOnHand(),
                    order.getDate1().toLocalDate(),
                    order.getCustomerName(),
                    order.getDiscription(),
                   order.getUnitePrice(),
                    order.getQty(),
                    order.getTotal()

            );
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }
    public static boolean createOrder(OrderDTO dto) throws Exception {
        Order order = new Order(
                dto.getId(),
                dto.getCustomerId(),
                dto.getItemCode(),
                dto.getQtyOnHand(),
                Date.valueOf(dto.getDate1()),
                dto.getCustomerName(),
                dto.getDiscription(),
                dto.getUnitePrice(),
                dto.getQty(),
                dto.getTotal()
        );
        return orderDAO.save(order);
    }
    public static boolean updateOrder(OrderDTO dto) throws Exception {
        Order order = new Order(
                dto.getId(),
                dto.getCustomerId(),
                dto.getItemCode(),
                dto.getQtyOnHand(),
                Date.valueOf(dto.getDate1()),
                dto.getCustomerName(),
                dto.getDiscription(),
                dto.getUnitePrice(),
                dto.getQty(),
                dto.getTotal()

        );
        return orderDAO.update(order);
    }



    public static boolean deleteOrder(String id) throws Exception {
        return orderDAO.delete(id);
    }

    public static OrderDTO findOrder(String id) throws Exception {
        Order order = orderDAO.find(id);
        if (order != null) {
            return new OrderDTO(
                    order.getId(),
                    order.getCustomerId(),
                    order.getItemCode(),
                    order.getQtyOnHand(),
                    order.getDate1().toLocalDate(),
                    order.getCustomerName(),
                    order.getDiscription(),
                    order.getUnitePrice(),
                    order.getQty(),
                    order.getTotal()
            );
        }
        return null;
    }
}