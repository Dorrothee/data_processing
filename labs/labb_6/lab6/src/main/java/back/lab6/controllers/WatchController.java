package back.lab6.controllers;

import back.lab6.entity.Watch;
import back.lab6.repositories.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("lab6/api/watches")
@CrossOrigin(origins = "*")
public class WatchController {

    @Autowired
    WatchRepository watchRepository;

    @PostMapping("/toadd")
    @ResponseStatus(HttpStatus.CREATED)
    public Watch postWatches(@RequestBody Watch watch){
        return watchRepository.save(watch);
    }

    @GetMapping("/get")
    public List<Watch> getWatches(){
        return watchRepository.findAll();
    }

    @PutMapping ("/update/{id}")
    public Watch putWatch(@PathVariable(name = "id") int id, @RequestBody Watch newWatch){
        Watch updatedWatch = watchRepository.findById(id)
                .orElseThrow(()->new ResourceAccessException("Not found Watch with such id: " + id));
        updatedWatch.setLook(newWatch.getLook());
        updatedWatch.setModel(newWatch.getModel());
        updatedWatch.setPrice(newWatch.getPrice());
        return watchRepository.save(updatedWatch);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWatch(@PathVariable(name = "id") int id){
        watchRepository.deleteById(id);
    }

}
