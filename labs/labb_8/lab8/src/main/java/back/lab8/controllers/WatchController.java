package back.lab8.controllers;

import back.lab8.entity.Watch;
import back.lab8.repositories.WatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/api/watches")
@Slf4j
public class WatchController {
    @Autowired
    WatchRepository watchRepository;

    @PostMapping("/toadd")
    @ResponseStatus(HttpStatus.CREATED)
    public Watch postWatches(@RequestBody Watch watch){
        log.info("[WATCH CONTROLLER] | POST method");
        watchRepository.save(watch);
        log.info("[WATCH CONTROLLER] after POST method: added {} watch", watch.getModel());
        return watch;
    }

    @GetMapping("/get")
    public List<Watch> getWatches(){
        List<Watch> list;
        log.info("[WATCH CONTROLLER] | GET method");
        list = watchRepository.findAll();
        log.info("[WATCH CONTROLLER] after GET method: found {} watches", list.size());
        return list;
    }

    @PutMapping ("/update/{id}")
    public Watch putWatch(@PathVariable(name = "id") int id, @RequestBody Watch newWatch){
        log.info("[WATCH CONTROLLER] | PUT method");
        Watch updatedWatch = watchRepository.findById(id)
                .orElseThrow(()->{
                    log.error("[WATCH CONTROLLER] | PUT method was failed: not found watch with such id - {}", id);
                    return new ResourceAccessException("Not found Watch with such id: " + id);
                });
        updatedWatch.setLook(newWatch.getLook());
        updatedWatch.setModel(newWatch.getModel());
        updatedWatch.setPrice(newWatch.getPrice());
        watchRepository.save(updatedWatch);
        log.info("[WATCH CONTROLLER] after PUT method: watch with {} id was changed", id);
        return updatedWatch;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWatch(@PathVariable(name = "id") int id){
        log.info("[WATCH CONTROLLER] | DELETE method");
        Watch deletedwatch = watchRepository.findById(id)
                .orElseThrow(()->{
                    log.error("[WATCH CONTROLLER] | DELETE method was failed: not found watch with such id - {}", id);
                    return new ResourceAccessException("Not found Watch with such id: " + id);
                });
        watchRepository.deleteById(id);
        log.info("[WATCH CONTROLLER] after DELETE method: {} watch with {} id was deleted", deletedwatch.getModel(), id);
    }
}
