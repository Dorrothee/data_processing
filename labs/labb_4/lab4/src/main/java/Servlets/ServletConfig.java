package Servlets;

import Crud.SqlCRUD;
import Crud.LabCRUDInterface;
import Entities.Watches;
import jdbc.Connect;

public class ServletConfig implements ServletConfigInt{
    LabCRUDInterface<Watches> sqlCRUD;
    Connect con;

    public LabCRUDInterface<Watches> getSqlCRUD() {
        return sqlCRUD;
    }

    public void setSqlCRUD(LabCRUDInterface<Watches> sqlCRUD) {
        this.sqlCRUD = sqlCRUD;
    }

    public void CloseConnection(){
        this.con.closeCon();
    }

    /*public ServletConfig(){
        this.con = new Connect();
        this.sqlCRUD = new SqlCRUD(this.con.getCon());
    }*/
}
