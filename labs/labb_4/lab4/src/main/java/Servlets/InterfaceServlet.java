package Servlets;

import Crud.CrudInt;
import Entities.Entity;
import com.google.gson.Gson;
import data.dataList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.List;

@WebServlet("/interface/*")
public class InterfaceServlet extends HttpServlet {

    private List<Entity> le = new dataList().getData();

    ServletConfigInt servletConfig;
    CrudInt crud;

    public InterfaceServlet(){
        super();
        this.servletConfig = new ServletConfig();
        this.crud = servletConfig.getCrud();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        ArrayList<Entity> data = new ArrayList<Entity>();
//        data.add(crud.readEntity());
//
        String mydata = new Gson().toJson(le);
//
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
        out.print(mydata);
        out.flush();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

    Entity watch = crud.watchParse(request);
    int id = Integer.parseInt(request.getPathInfo().substring(1));
    response.setContentType("application/json");
    int index = crud.getIndexByWatchId(id, le);
    le.set(index, watch);
    doGet(request, response);

//        String look = request.getParameter("look");
//        String model = request.getParameter("model");
//        int price = Integer.parseInt(request.getParameter("price"));
//
//        crud.updateEntity(new Entity(look,model,price));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Entity watch = crud.watchParse(request);
        watch.setId(crud.getNextId(le));
        le.add(watch);
        doGet(request, response);

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = crud.getIndexByWatchId(id, le);
        le.remove(index);
        doGet(request, response);
    }
}
