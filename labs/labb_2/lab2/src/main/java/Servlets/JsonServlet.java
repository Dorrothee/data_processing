package Servlets;

import Entities.Entity;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/json")
public class JsonServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        Entity entity = new Entity("assets/watch1.png", "GARMIN MARQ COMMANDER", 2950);


        ArrayList<Entity> data = new ArrayList<Entity>();
        data.add(entity);

        String mydata = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.print(mydata);
        out.flush();
    }
}
