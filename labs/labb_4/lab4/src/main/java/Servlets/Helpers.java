package Servlets;

import Entities.Watches;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Helpers {
    public static JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    public static Watches watchParse(HttpServletRequest request){
        Watches watch = new Watches();
        JsonElement jsonElement = bodyParse(request);
        watch.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        watch.setLook(jsonElement.getAsJsonObject().get("look").getAsString());
        watch.setModel(jsonElement.getAsJsonObject().get("model").getAsString());
        watch.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        return watch;
    }

    public static int getNextId(List<Watches> list) {
        int maxId = 0;

        Iterator<Watches> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public static int getIndexByWatchId(int id, List<Watches> list) {
        int listId = id;

        Iterator<Watches> iterator = list.iterator();
        while(iterator.hasNext()) {
            Watches temp = iterator.next();
            if(temp.getId() == listId) {
                listId = list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
}