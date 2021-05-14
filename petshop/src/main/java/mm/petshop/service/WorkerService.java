package mm.petshop.service;

import mm.petshop.domain.Worker;
import mm.petshop.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository workerRepository;

    public List<Worker> getAllWorkers(){
        return workerRepository.findAll();
    }

    public Worker addWorker(Worker worker){
        return workerRepository.save(worker);
    }

    public Worker getWorkerById(Integer id) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        if(optionalWorker.isPresent()){
            return optionalWorker.get();
        }
        else{
            throw new RuntimeException("Worker not found!");
        }
    }

}
