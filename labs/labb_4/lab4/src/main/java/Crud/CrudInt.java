package Crud;

import Entities.Watches;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CrudInt {

    Watches readEntity();
    void updateEntity(Watches entity);

    Watches watchParse(HttpServletRequest request);
    int getIndexByWatchId(int id, List<Watches> le);
    int getNextId(List<Watches> le);

}
