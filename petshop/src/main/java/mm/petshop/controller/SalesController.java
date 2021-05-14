package mm.petshop.controller;

import mm.petshop.domain.Pet;
import mm.petshop.domain.Sales;
import mm.petshop.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping("/sales")
    List<Sales> getAllSales(){
        return salesService.getAllSales();
    }

    @GetMapping("/sales/{id}")
    Sales getSalesById(@PathVariable Integer id){
        return salesService.getSalesById(id);
    }

    @PostMapping("/sales")
    Sales addSale(Sales sale){
        return salesService.addSale(sale);
    }

    @GetMapping("/sales/worker/{worker_id}")
    List<Sales> getSalesByWorker(@PathVariable Integer worker_id){
        return salesService.getSalesByWorker(worker_id);
    }

    @GetMapping("sales/pet/{pet_id}")
    List<Sales> getSalesByPet(@PathVariable Integer pet_id){
        return salesService.getSalesByPet(pet_id);
    }

    @GetMapping("/sales/client/{client_id}")
    List<Sales> getSalesByClient(@PathVariable Integer client_id){
        return salesService.getSalesByClient(client_id);
    }

    @DeleteMapping("/sales/{id}")
    void deleteSaleById(@PathVariable Integer id){
        salesService.deleteSaleById(id);
    }
}
