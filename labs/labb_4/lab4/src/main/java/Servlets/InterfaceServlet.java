package Servlets;

import Crud.CrudInt;
import Crud.LabCRUDInterface;
import Crud.SqlCRUD;
import Entities.Watches;
import com.google.gson.Gson;
import data.dataList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.Connect;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/interface/*")
public class InterfaceServlet extends HttpServlet {
    ServletConfigInt servletConfig;
    LabCRUDInterface<Watches> crud = new SqlCRUD();

    public void init(ServletConfig config) throws ServletException {
        //this.servletConfig = new ServletConfig();
        //this.crud = servletConfig.getSqlCRUD();
        crud = new SqlCRUD();
    }

    public void destroy() {
        try{
            ((SqlCRUD) crud).getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //this.servletConfig.CloseConnection();
    }

    public InterfaceServlet() {
        super();
        this.servletConfig = new ServletConfig();
        this.crud = servletConfig.getSqlCRUD();
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);

//        ArrayList<Entity> data = new ArrayList<Entity>();
//        data.add(crud.readEntity());
//
        String mydata = new Gson().toJson(crud.read());
//
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(mydata);
        out.flush();
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        Watches watch = Helpers.watchParse(request);
//        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.update(watch.getId(), watch);
//        int index = crud.getIndexByWatchId(id, le);
//        le.set(index, watch);
        doGet(request, response);

//        String look = request.getParameter("look");
//        String model = request.getParameter("model");
//        int price = Integer.parseInt(request.getParameter("price"));
//
//        crud.updateEntity(new Entity(look,model,price));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        Watches watch = Helpers.watchParse(request);
        crud.create(watch);
//        watch.setId(crud.getNextId(le));
//        le.add(watch);
        doGet(request, response);

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.delete(id);
//        int index = crud.getIndexByWatchId(id, le);
//        le.remove(index);
        doGet(request, response);
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
    }
}
