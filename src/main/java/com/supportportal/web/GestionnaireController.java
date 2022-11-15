package com.supportportal.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.supportportal.dtos.GestionnaireDto;
import com.supportportal.services.GestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping(value =  "/gestionnaire")
public class GestionnaireController {

    @Autowired
    private GestionnaireService gestionnaireService;

    @GetMapping("/gestionnaires")
    public List<GestionnaireDto> getGestionnaires(){

        return gestionnaireService.listGestionnaire();
    }

    @GetMapping("/gestionnaires/search")
    public List<GestionnaireDto> getGestionnaires( @RequestParam(name = "keyword", defaultValue = "") String keyword ){
        return gestionnaireService.searchGestionnaire( "%"+keyword+"%");
    }

    @PostMapping("/gestionnaires")
    public GestionnaireDto saveGestionnaire( @RequestBody GestionnaireDto request){
        return gestionnaireService.saveGestionnaire( request);
    }

    @DeleteMapping("/gestionnaires/{id}")
    public void deleteGestionnairer(@PathVariable(name="id") String demid){
        gestionnaireService.deleteGestionnaire( demid);
    }


}
