package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/first1")
public class FirstServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext();
        super.init(config);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var res = req.getHeader("user-agent");
        var headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            var header = headerNames.nextElement();
            System.out.println(req.getHeader(header));
        }
        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("token","12345");
        //resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var writer = resp.getWriter()) {
            writer.write("<h1>Привет с первого сервлета</h1>");
        }
        super.doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}