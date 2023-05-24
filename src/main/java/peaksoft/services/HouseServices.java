package peaksoft.services;

import peaksoft.exception.MyException;
import peaksoft.model.House;

import java.util.List;

public interface HouseServices {
    void saveHouse(Long agencyId, House house) throws MyException;
    List<House> getAllHouses(Long agencyId);
    House getHouseById(Long id) throws MyException;
    void updateHouseById(Long id, House house) throws MyException;
    void deleteHouseById(Long id) throws MyException;

    List<House> sortHouseByHouseType(String ascOrDesc);
    List<House> searchHouse(String word);
}
