package peaksoft.services;

import peaksoft.exception.MyException;
import peaksoft.model.Agency;

import java.util.List;

public interface AgencyServices {
    void saveAgency(Agency agency);
    Agency getAgencyById(Long id) throws MyException;
    List<Agency> getAllAgencies();
    void updateAgency(Long id,Agency agency) throws MyException;
    void deleteAgencyById(Long id) throws MyException;
    List<Agency> searchAgency(String word);
}
