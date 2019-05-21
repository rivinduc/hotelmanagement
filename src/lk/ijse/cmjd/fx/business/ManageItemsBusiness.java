package lk.ijse.cmjd.fx.business;

import lk.ijse.cmjd.fx.dao.DAOFactory;
import lk.ijse.cmjd.fx.dao.custom.ItemDAO;
import lk.ijse.cmjd.fx.dto.ItemDTO;
import lk.ijse.cmjd.fx.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ManageItemsBusiness {
    static ItemDAO itemDAO= (ItemDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.ITEM);

    public static List<ItemDTO> getItems() throws Exception {
        List<Item> allCustomers = itemDAO.findAll();
        List<ItemDTO> tmpDTOs = new ArrayList<>();
        for (Item item : allCustomers) {
            ItemDTO dto = new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(),item.getQtyOnHand());
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }

    public static boolean createItem(ItemDTO dto) throws Exception {
        Item item = new Item(dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
        return itemDAO.save(item);
    }

    public static boolean updateItem(ItemDTO dto) throws Exception {
        Item item = new Item(
                dto.getCode(),
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQtyOnHand()
        );
        return itemDAO.update(item);
    }

    public static boolean deleteItem(String itemCode) throws Exception {
        return itemDAO.delete(itemCode);
    }

    public static ItemDTO findItem(String code) throws Exception {
        Item item = itemDAO.find(code);
        if (item != null) {
            return new ItemDTO(item.getCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQtyOnHand());

        }
        return null;
    }
}
