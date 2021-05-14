package mm.petshop.repository;

import mm.petshop.domain.Client;
import mm.petshop.domain.Pet;
import mm.petshop.domain.Sales;
import mm.petshop.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalesRepository extends JpaRepository<Sales,Integer > {
    List<Sales> getSalesByClient(Client client);
    List<Sales> getSalesByPet(Pet pet);
    List<Sales> getSalesByWorker(Worker worker);
}
