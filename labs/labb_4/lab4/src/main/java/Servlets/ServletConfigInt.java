package Servlets;

import Crud.LabCRUDInterface;
import Entities.Watches;

public interface ServletConfigInt {

    public LabCRUDInterface<Watches> getSqlCRUD();
    public void CloseConnection();

}
