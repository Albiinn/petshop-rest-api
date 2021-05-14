package mm.petshop.service;

import mm.petshop.domain.Client;
import mm.petshop.domain.Pet;
import mm.petshop.domain.Sales;
import mm.petshop.domain.Worker;
import mm.petshop.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private PetService petService;

    @Autowired
    private ClientService clientService;

    public List<Sales> getAllSales(){
        return salesRepository.findAll();
    }

    public Sales getSalesById(Integer id){
        Optional<Sales> optionalSales = salesRepository.findById(id);
        if(optionalSales.isPresent()){
            return optionalSales.get();
        }
        else{
            throw new RuntimeException("Sale not found!");
        }
    }

    public Sales addSale(Sales sale){
       return salesRepository.save(sale);
    }

    public List<Sales> getSalesByWorker(Integer worker_id){
        Worker worker = workerService.getWorkerById(worker_id);
        return salesRepository.getSalesByWorker(worker);
    }

    public List<Sales> getSalesByPet(Integer pet_id){
        Pet pet = petService.getPetById(pet_id);
        return salesRepository.getSalesByPet(pet);
    }

    public List<Sales> getSalesByClient(@PathVariable Integer client_id){
        Client client = clientService.getClientById(client_id);
        return salesRepository.getSalesByClient(client);
    }

    public void deleteSaleById(Integer id) {
        salesRepository.deleteById(id);
    }
}