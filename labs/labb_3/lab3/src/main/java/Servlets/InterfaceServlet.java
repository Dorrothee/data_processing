package Servlets;

import Crud.CrudInt;
import Entities.Entity;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/interface")
public class InterfaceServlet extends HttpServlet {

    ServletConfigInt servletConfig;
    CrudInt crud;

    public InterfaceServlet(){
        super();
        this.servletConfig = new ServletConfig();
        this.crud = servletConfig.getCrud();
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<Entity> data = new ArrayList<Entity>();
        data.add(crud.readEntity());

        String mydata = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.print(mydata);
        out.flush();
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String look = request.getParameter("look");
        String model = request.getParameter("model");
        int price = Integer.parseInt(request.getParameter("price"));

        crud.updateEntity(new Entity(look,model,price));
    }
}
