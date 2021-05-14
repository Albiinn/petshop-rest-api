package mm.petshop.controller;

import mm.petshop.domain.Client;
import mm.petshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    
    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("client")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @GetMapping("clients/{id}")
    public Client getClient(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }
}
