package mm.petshop.controller;

import mm.petshop.domain.Client;
import mm.petshop.domain.PetType;
import mm.petshop.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetTypeController {

    @Autowired
    PetTypeService petTypeService;

    @GetMapping("/types")
    public List<PetType> getAllPetTypes(){
        return petTypeService.getAllPetTypes();
    }

    @PostMapping("type")
    public PetType addPetType(@RequestBody PetType petType){
        return petTypeService.addPetType(petType);
    }

    @GetMapping("types/{id}")
    public PetType getPetType(@PathVariable Integer id) throws Exception {
        return petTypeService.getPetTypeByID(id);
    }

}
