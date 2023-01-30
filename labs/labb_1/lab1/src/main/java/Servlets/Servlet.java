package Servlets;

import Entities.Entity;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Entity entity = new Entity("assets/watch1.png", "GARMIN MARQ COMMANDER", 2950);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");

        out.println("["+entity+"]");
    }
}
