package Servlets;

import Crud.CrudInt;
import Crud.FileCrud;

public class ServletConfig implements ServletConfigInt{
    CrudInt cri;

    public ServletConfig(){
        this.cri = new FileCrud();
    }

    public void setCri(CrudInt cri) {
        this.cri = cri;
    }

    @Override
    public CrudInt getCrud(){
        return new FileCrud();
    }

}
