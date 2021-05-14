package mm.petshop.service;

import mm.petshop.domain.PetType;
import mm.petshop.repository.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetTypeService {
    @Autowired
    PetTypeRepository petTypeRepository;

    public List<PetType> getAllPetTypes(){
        return petTypeRepository.findAll();
    }

    public PetType getPetTypeByID(Integer id)  {
        Optional<PetType> optionalPetType = petTypeRepository.findById(id);
        if(optionalPetType.isPresent()){
            return optionalPetType.get();
        }
        else{
            throw new RuntimeException("Pet Type not found!");
        }
    }

    public PetType addPetType(PetType petType){
        return petTypeRepository.save(petType);
    }
}
