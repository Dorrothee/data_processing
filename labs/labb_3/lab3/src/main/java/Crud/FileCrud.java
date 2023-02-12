package Crud;

import Entities.Entity;
import fileIO.FileIO;
import fileIO.FileIOInt;

public class FileCrud implements CrudInt {

    FileIOInt fio;

    public FileCrud() {
        this.fio = new FileIO();
    }

    @Override
    public Entity readEntity() {
        return (Entity) fio.loadfromfile();
    }
    @Override
    public void updateEntity(Entity entity) {
        fio.savetofile(entity);
    }
}
