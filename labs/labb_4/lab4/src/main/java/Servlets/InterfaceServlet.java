package Servlets;

import Crud.LabCRUDInterface;
import Crud.SqlCRUD;
import Entities.Watches;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/interface/*")
public class  InterfaceServlet extends HttpServlet {
    ServletConfigInt servletConfig;
    LabCRUDInterface<Watches> crud;

    public void destroy() {
        try{
            ((SqlCRUD) crud).getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public InterfaceServlet() {
        super();
        this.servletConfig = new ServletConfig();
        this.crud = servletConfig.getSqlCRUD();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.getWriter().println(crud.read());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Watches watch = Helpers.watchParse(request);
        crud.create(watch);
        doGet(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Watches watch = Helpers.watchParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.update(id, watch);
        doGet(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.delete(id);
        doGet(request, response);
    }

/*
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        String mydata = new Gson().toJson(crud.read());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(mydata);
        out.flush();
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        Watches watch = Helpers.watchParse(request);
        response.setContentType("application/json");
        crud.update(watch.getId(), watch);
        doGet(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        Watches watch = Helpers.watchParse(request);
        crud.create(watch);
        doGet(request, response);

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.delete(id);
        doGet(request, response);
    }*/

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
