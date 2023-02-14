package Crud;

import Entities.Entity;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import fileIO.FileIO;
import fileIO.FileIOInt;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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


    public JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    @Override
    public Entity watchParse(HttpServletRequest request){
        Entity watch = new Entity();
        JsonElement jsonElement = bodyParse(request);
        watch.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        watch.setLook(jsonElement.getAsJsonObject().get("look").getAsString());
        watch.setModel(jsonElement.getAsJsonObject().get("model").getAsString());
        watch.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        return watch;
    }

    public int getNextId(List<Entity> list) {
        int maxId = 0;

        Iterator<Entity> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public int getIndexByWatchId(int id, List<Entity> list) {
        int listId = id;

        Iterator<Entity> iterator = list.iterator();
        while(iterator.hasNext()) {
            Entity temp = iterator.next();
            if(temp.getId() == listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }

}
