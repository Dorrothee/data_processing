package Crud;

import Entities.Entity;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CrudInt {

    Entity readEntity();
    void updateEntity(Entity entity);

    Entity watchParse(HttpServletRequest request);
    int getIndexByWatchId(int id, List<Entity> le);
    int getNextId(List<Entity> le);

}
