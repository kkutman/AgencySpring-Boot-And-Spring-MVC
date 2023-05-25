package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.enums.HouseType;
import peaksoft.exception.MyException;
import peaksoft.model.House;
import peaksoft.services.AgencyServices;
import peaksoft.services.HouseServices;

@Controller
@RequestMapping("/houses/{agencyId}")
@RequiredArgsConstructor
public class HouseApi {
    private final HouseServices houseServices;
    private final AgencyServices agencyServices;

    @GetMapping
    public String getAllHouse(@PathVariable Long agencyId, Model model) throws MyException {
        model.addAttribute("houses", houseServices.getAllHouses(agencyId));
        model.addAttribute("agencyId", agencyId);
        model.addAttribute("agency", agencyServices.getAgencyById(agencyId));
        return "house/allHouse";
    }

    @GetMapping("/new")
    public String create(@PathVariable Long agencyId, Model model) {
        model.addAttribute("newHouse", new House());
        model.addAttribute("agencyId", agencyId);
        model.addAttribute("houseTypes", new String[]{"BRICK_HOUSES", "MONOLITHIC_HOUSES", "BLOCK_HOUSES"});
        return "house/newHouse";
    }

    @PostMapping("/saveHouse")
    public String saveAgency(@PathVariable("agencyId") Long agencyId, @ModelAttribute("newHouse") House house, @ModelAttribute("houseTypes") String type) throws MyException {
        house.setHouseType(HouseType.valueOf(house.getHouseTypeString()));
        houseServices.saveHouse(agencyId, house);
        return "redirect:/houses/" + agencyId;
    }

    @GetMapping("/{id}")
    public String getHouseById(@PathVariable Long agencyId, @PathVariable Long id, Model model) throws MyException {
        model.addAttribute("houses", houseServices.getHouseById(id));
        return "house/getByIdHouse";
    }

    @GetMapping("/{houseId}/edit")
    public String edit(@PathVariable Long houseId, Model model, @PathVariable Long agencyId) throws MyException {
        model.addAttribute("house", houseServices.getHouseById(houseId));
        model.addAttribute("houseTypes", new String[]{"BRICK_HOUSES", "MONOLITHIC_HOUSES", "BLOCK_HOUSES"});
        model.addAttribute(agencyId);
        return "house/updateHouse";
    }

    @PostMapping("/{houseId}/update")
    public String update(@ModelAttribute("house") House house, @PathVariable("houseId") Long houseId, @PathVariable("agencyId") Long agencyId) throws MyException {
        house.setHouseType(HouseType.valueOf(house.getHouseTypeString()));
        houseServices.updateHouseById(houseId, house);
        return "redirect:/houses/" + agencyId;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) throws MyException {
        houseServices.deleteHouseById(id);
        return "redirect:/houses/{agencyId}";
    }

}
