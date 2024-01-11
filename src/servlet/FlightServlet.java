package servlet;

import entity.Flight;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.FlightService;
import util.FlightVariants;
import util.JspHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("flights",flightService.findAll());
        req.getRequestDispatcher(JspHelper.get("flights")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var from = req.getParameter("from");
        var to = req.getParameter("to");
        if(from!=null&&to!=null&& FlightVariants.get().contains(from)&&FlightVariants.get().contains(to)){
            var res = flightService.getAllFlightsFromTo(from,to);
            if(res!=null){
                req.setAttribute("flights",flightService.getAllFlightsFromTo(from,to));
            }
        }
        req.getRequestDispatcher(JspHelper.get("flights")).forward(req,resp);
        //doGet(req,resp);
    }
}