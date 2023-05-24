package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.exception.MyException;
import peaksoft.model.Agency;
import peaksoft.services.AgencyServices;

import java.util.List;

@Controller
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyApi {
    private final AgencyServices agencyServices;
    @GetMapping
    public String getAllAgency(Model model) {
        model.addAttribute("getAllAgency",agencyServices.getAllAgencies());
        return "agencies/index";
    }
    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("agency", new Agency());
        return "agencies/newAgency";
    }

    @PostMapping("/saveAgency")
    public String saveAgency(@ModelAttribute("agency") Agency agency) {
        agencyServices.saveAgency(agency);
        return "redirect:/agencies";
    }

    @GetMapping("/{id}")
    public String getAgencyById(@PathVariable("id") Long id, Model model) throws MyException {
        model.addAttribute("agencies", agencyServices.getAgencyById(id));
        return "agencies/getByIdAgency";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") Long id,
                         Model model) throws MyException {
        model.addAttribute("edit", agencyServices.getAgencyById(id));
        return "agencies/updateAgency";
    }

    @PostMapping("/update/{id}")
    public String saveUpdate(@ModelAttribute("edit") Agency agency,
                             @PathVariable("id") Long id) {
        try {
            agencyServices.updateAgency(id, agency);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/agencies";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        try {
            agencyServices.deleteAgencyById(id);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/agencies";
    }


}
