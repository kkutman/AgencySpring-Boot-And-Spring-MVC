package peaksoft.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.exception.MyException;
import peaksoft.model.Agency;
import peaksoft.repository.AgencyRepository;
import peaksoft.services.AgencyServices;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyServices {
    private final AgencyRepository agencyRepository;

    @Override
    public void saveAgency(Agency agency) {
        if (!agency.getName().isBlank()) {
            if (!agency.getCountry().isBlank()) {
                if (agency.getPhoneNumber().startsWith("+996") || agency.getPhoneNumber().length() == 13) {
                    if (!agency.getEmail().isBlank() || agency.getEmail().contains("@gmail.com")) {
                        if (!agency.getPhoto().isBlank()) {
                            agencyRepository.save(agency);
                        } else {
                            try {
                                throw new MyException("Agency name is blank");
                            } catch (MyException e) {
                                System.err.println(e.getMessage());
                            }
                        }
                    } else {
                        try {
                            throw new MyException("Agency email contains @gmail.com");
                        } catch (MyException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                } else {
                    try {
                        throw new MyException("Agency phone +996 and length=13");
                    } catch (MyException e) {
                        System.err.println(e.getMessage());
                    }
                }
            } else {
                try {
                    throw new MyException("Agency country is blank");
                } catch (MyException e) {
                    System.err.println(e.getMessage());
                }
            }
        } else {
            try {
                throw new MyException("Agency name is blank");
            } catch (MyException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public Agency getAgencyById(Long id) throws MyException {
        return agencyRepository.findById(id).orElseThrow(() -> new MyException("Agency by id: " + id + " is not found!!!"));
    }

    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }

    @Override
    public void updateAgency(Long id, Agency agency) throws MyException {
        Agency agency1 = agencyRepository.findById(id).orElseThrow(() -> new MyException("Agency by id: " + id + " is not found!!!"));
        if (!agency.getName().isBlank()) {
            agency1.setName(agency.getName());
            if (!agency.getCountry().isBlank()) {
                agency1.setCountry(agency.getCountry());
                if (agency.getPhoneNumber().startsWith("+996") || agency.getPhoneNumber().length() == 13) {
                    agency1.setPhoneNumber(agency.getPhoneNumber());
                    if (!agency.getEmail().isBlank() || agency.getEmail().contains("@gmail.com")) {
                        agency1.setEmail(agency.getEmail());
                        if (!agency.getPhoto().isBlank()) {
                            agency1.setPhoto(agency.getPhoto());
                            agencyRepository.save(agency);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void deleteAgencyById(Long id) throws MyException {
        Agency agency = agencyRepository.findById(id).orElseThrow(() -> new MyException("Agency by id: " + id + " is not found!!!"));
        agencyRepository.deleteById(agency.getId());
    }

    @Override
    public List<Agency> searchAgency(String word) {
        return agencyRepository.searchAgenciesByNameAndCountry(word,word);
    }
}
