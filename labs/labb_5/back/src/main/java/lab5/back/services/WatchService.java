package lab5.back.services;

import lab5.back.entity.Watch;
import lab5.back.repositories.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchService {

    @Autowired
    private WatchRepository repo;

    public List<Watch> listAll(){
        return repo.findAll();
    }

    public void save(Watch watch){
        repo.save(watch);
    }

    public Watch get(int id){
        return repo.findById(id).get();
    }

    public void delete(int id){
        repo.deleteById(id);
    }
}
