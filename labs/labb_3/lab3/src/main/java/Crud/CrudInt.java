package Crud;

import Entities.Entity;

public interface CrudInt {

    Entity readEntity();
    void updateEntity(Entity entity);

}
