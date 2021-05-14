package mm.petshop.service;

import mm.petshop.domain.Pet;
import mm.petshop.domain.PetType;
import mm.petshop.domain.Worker;
import mm.petshop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    @Autowired
    WorkerService workerService;

    @Autowired
    PetTypeService petTypeService;

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Pet addPet(Pet pet){
        return petRepository.save(pet);
    }

    public Pet getPetById(Integer id) {
        Optional<Pet> optionalPet = petRepository.findById(id);
        if(optionalPet.isPresent()){
            return optionalPet.get();
        }
        else {
            throw new RuntimeException("Pet not found!");
        }
    }

    public List<Pet> getPetsByWorker(Integer worker_id) {
        Worker worker = workerService.getWorkerById(worker_id);
        return petRepository.findAllByWorker(worker);

    }

    public List<Pet> getPetsByType(Integer type_id) {
        PetType petType = petTypeService.getPetTypeByID(type_id);
        return petRepository.findAllByPetType(petType);

    }
    public void deletePetById(Integer id){
        petRepository.deleteById(id);
    }

}
