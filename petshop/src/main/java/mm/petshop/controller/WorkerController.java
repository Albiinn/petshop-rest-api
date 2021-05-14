package mm.petshop.controller;

import mm.petshop.domain.Client;
import mm.petshop.domain.Worker;
import mm.petshop.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @GetMapping("/workers")
    public List<Worker> getAllWorkers(){
        return workerService.getAllWorkers();
    }

    @PostMapping("worker")
    public Worker addWorker(@RequestBody Worker worker){
        return workerService.addWorker(worker);
    }

    @GetMapping("workers/{id}")
    public Worker getWorker(@PathVariable Integer id) throws Exception {
        return workerService.getWorkerById(id);

    }
}
