package lk.ijse.cmjd.fx.business;
import lk.ijse.cmjd.fx.dao.custom.BanquetDAO;
import lk.ijse.cmjd.fx.dao.custom.CustomerDAO;
import lk.ijse.cmjd.fx.dao.DAOFactory;
import lk.ijse.cmjd.fx.dto.BanquetDTO;
import lk.ijse.cmjd.fx.dto.CustomerDTO;
import lk.ijse.cmjd.fx.entity.Banquet;
import lk.ijse.cmjd.fx.entity.Customer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
public class ManageBanquetBusiness {

    static BanquetDAO banquetDAO= (BanquetDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.BANQUET);

    public static List<BanquetDTO> getBanquet() throws Exception {
        List<Banquet> allBanquet = banquetDAO.findAll();
        List<BanquetDTO> tmpDTOs = new ArrayList<>();
        for (Banquet banquet : allBanquet) {
            BanquetDTO dto = new BanquetDTO(
                   banquet.getId(),
                    banquet.getName(),
                    banquet.getAddress(),
                    banquet.getEmail(),
                    banquet.getDate2().toLocalDate(),
                    banquet.getPpl(),
                    banquet.getTypec(),
                    banquet.getChair(),
                    banquet.getF1(),
                    banquet.getF2(),
                    banquet.getTxtCustomerId12()
            );
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }

    public static boolean createBanquet(BanquetDTO dto) throws Exception {
       Banquet banquet = new Banquet(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                Date.valueOf(dto.getDate2()),
                dto.getPpl(),
                dto.getTypec(),
                dto.getChair(),
                dto.getF1(),
                dto.getF2(),
                dto.getTxtCustomerId12()
        );
        return banquetDAO.save(banquet);
    }
    public static boolean updateBanquet(BanquetDTO dto) throws Exception {
        Banquet banquet = new Banquet(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                Date.valueOf(dto.getDate2()),
                dto.getPpl(),
                dto.getTypec(),
                dto.getChair(),
                dto.getF1(),
                dto.getF2(),
                dto.getTxtCustomerId12()
        );
        return banquetDAO.update(banquet);
    }


//    public static boolean deleteBanquet(String banquetID) throws Exception {
//        return BanquetDAO.delete(banquetID);
//    }


    public static BanquetDTO findBanquet(String id) throws Exception {
        Banquet banquet = banquetDAO.find(id);
        if (banquet != null) {
            return new BanquetDTO(
                    banquet.getId(),
                    banquet.getName(),
                    banquet.getAddress(),
                    banquet.getEmail(),
                    banquet.getDate2().toLocalDate(),
                    banquet.getPpl(),
                    banquet.getTypec(),
                    banquet.getChair(),
                    banquet.getF1(),
                    banquet.getF2()
                    ,banquet.getTxtCustomerId12()
            );
        }
        return null;
    }

    public static boolean deleteBanquet(String del_id) throws Exception {
        return banquetDAO.delete2(del_id);
    }
}
