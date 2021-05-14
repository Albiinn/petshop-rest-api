package mm.petshop.service;

import mm.petshop.domain.Client;
import mm.petshop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }


    public Client addClient(Client client){
        return clientRepository.save(client);
    }

    public Client getClientById(Integer id)  {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()){
            return optionalClient.get();
        }
        else{
            throw new RuntimeException("Client not found!");
        }
    }
}
