package mm.petshop.controller;

import mm.petshop.domain.Client;
import mm.petshop.domain.Pet;
import mm.petshop.domain.PetType;
import mm.petshop.domain.Worker;
import mm.petshop.service.PetService;
import mm.petshop.service.PetTypeService;
import mm.petshop.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {
    private PetService petService;
    private WorkerService workerService;
    private PetTypeService petTypeService;

    @Autowired
    public PetController(PetService petService, WorkerService workerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.workerService = workerService;
        this.petTypeService = petTypeService;
    }

    @GetMapping("/pets")
    public List<Pet> getAllPets(){
        return petService.getAllPets();
    }

    @PostMapping("pets")
    public Pet addPet(@RequestBody Pet pet){
        return petService.addPet(pet);
    }

    @GetMapping("pets/{id}")
    public Pet getPet(@PathVariable Integer id)  {
        return petService.getPetById(id);
    }

    @GetMapping("pets/worker/{worker_id}")
    public List<Pet> getPetsByWorker(@PathVariable Integer worker_id) {
        return petService.getPetsByWorker(worker_id);
    }

    @GetMapping("pets/type/{type_id}")
    public List<Pet> getPetsByType(@PathVariable Integer type_id) {
        return petService.getPetsByType(type_id);
    }

    @DeleteMapping("pets/{id}")
    public void deletePetById(@PathVariable Integer id){
        petService.deletePetById(id);
    }

}
