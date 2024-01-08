package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.Custom.ButterflyBO;
import lk.ijse.dao.Custom.ButterflyDAO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.butterflyDto;
import lk.ijse.entity.butterflyvariety;

import java.sql.SQLException;
import java.util.ArrayList;

public class ButterflyBOImpl implements ButterflyBO {
    ButterflyDAO butterflyDAO = (ButterflyDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BUTTERFLY);
    @Override
    public ArrayList<butterflyDto> getAllButterfly() throws SQLException, ClassNotFoundException{
        ArrayList<butterflyvariety> bts = butterflyDAO.getAll();
        ArrayList<butterflyDto> btsDTO = new ArrayList<>();
        for(butterflyvariety bt : bts){
            btsDTO.add(new butterflyDto(bt.getbId(),bt.getName(), bt.getDesc(), bt.getSpecies(),bt.getAvgLifetime(),bt.getCurrentCount()));
        }
        return btsDTO;
    }
    @Override
    public boolean saveButterfly(butterflyDto dto) throws SQLException, ClassNotFoundException{
        return butterflyDAO.save(new butterflyvariety(dto.getBId(),dto.getName(),dto.getDesc(),dto.getSpecies(),dto.getLifeTime(),dto.getCount()));
    }
    @Override
    public boolean updateButterfly(butterflyDto dto) throws SQLException, ClassNotFoundException {
        return butterflyDAO.update(new butterflyvariety(dto.getBId(),dto.getName(),dto.getDesc(),dto.getSpecies(),dto.getLifeTime(),dto.getCount()));
    }

    @Override
    public boolean existButterfly(String id) throws SQLException, ClassNotFoundException {
        return butterflyDAO.exist(id);
    }

    @Override
    public void deleteButterfly(String id) throws SQLException, ClassNotFoundException {
        butterflyDAO.delete(id);
    }
}