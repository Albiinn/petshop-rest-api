package mm.petshop.repository;

import mm.petshop.domain.Pet;
import mm.petshop.domain.PetType;
import mm.petshop.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {
   List<Pet> findAllByWorker(Worker worker);
   List<Pet> findAllByPetType(PetType petType);

    //List<Pet> findAllByWorker_Id(Integer id);
}
