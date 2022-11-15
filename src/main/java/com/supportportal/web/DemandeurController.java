package com.supportportal.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.supportportal.dtos.DemandeurDto;
import com.supportportal.services.DemandeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class DemandeurController {

    @Autowired
    private DemandeurService demandeurService;

    @GetMapping("/demandeurs")
    public List<DemandeurDto> getDemandeurs(){

        return demandeurService.listDemandeurs();
    }

    @GetMapping("/demandeurs/search")
    public List<DemandeurDto> getDemandeurs( @RequestParam(name = "keyword", defaultValue = "") String keyword ){
        return demandeurService.searchDemandeur( "%"+keyword+"%");
    }

    @PostMapping("/demandeurs")
    public DemandeurDto saveCustomer( @RequestBody DemandeurDto request){
        return demandeurService.saveDemandeur( request);
    }

    @DeleteMapping("/demandeurs/{id}")
    public void deleteDemandeur(@PathVariable(name="id") String demid){
        demandeurService.deleteDemandeur( demid);
    }



}
