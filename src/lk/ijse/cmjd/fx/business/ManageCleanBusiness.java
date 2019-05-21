package lk.ijse.cmjd.fx.business;
import lk.ijse.cmjd.fx.dao.DAOFactory;
import lk.ijse.cmjd.fx.dao.custom.CleanDAO;
import lk.ijse.cmjd.fx.dao.custom.ItemDAO;
import lk.ijse.cmjd.fx.dto.CleanDTO;
import lk.ijse.cmjd.fx.dto.ItemDTO;
import lk.ijse.cmjd.fx.entity.Clean;
import lk.ijse.cmjd.fx.entity.Item;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
public class ManageCleanBusiness {

    static CleanDAO cleanDAO= (CleanDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.CLEAN);

    public static List<CleanDTO> getItems() throws Exception {
        List<Clean> allCustomers = cleanDAO.findAll();
        List<CleanDTO> tmpDTOs = new ArrayList<>();
        for (Clean clean : allCustomers) {
            CleanDTO dto = new CleanDTO(clean.getCode(), clean.getDescription(), clean.getDate().toLocalDate(),clean.getF1());
            tmpDTOs.add(dto);
        }
        return tmpDTOs;
    }
    public static boolean createClean(CleanDTO dto) throws Exception {
        Clean clean = new Clean(dto.getCode(), dto.getDescription(),   Date.valueOf(dto.getDate()),dto.getF1());
        return cleanDAO.save(clean);
    }
    public static boolean updateClean(CleanDTO dto) throws Exception {
        Clean clean = new Clean(dto.getCode(), dto.getDescription(),   Date.valueOf(dto.getDate()),dto.getF1()
        );
        return cleanDAO.update(clean);
    }
    public static boolean deleteClean(String cleanCode) throws Exception {
        return cleanDAO.delete(cleanCode);
    }
    public static CleanDTO findClean(String code) throws Exception {
        Clean clean = cleanDAO.find(code);
        if (clean != null) {

            return new CleanDTO(clean.getCode(),
                    clean.getDescription(),
                    clean.getDate().toLocalDate(),
                    clean.getF1());

        }

        return null;
    }
}
