package servlet;

import dto.CreateUserDto;
import dto.UserDto;
import exception.ValidationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import util.JspHelper;
import util.UrlPath;

import java.io.IOException;

@WebServlet(UrlPath.EDIT)
public class EditServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.get("edit")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if(req.getParameter("password")!=null&&req.getParameter("passwordRep")!=null&&req.getParameter("password").equals(req.getParameter("passwordRep"))){
        if(req.getParameter("newPassword")!=null){
            userService.changePassword(((UserDto)req.getSession().getAttribute("user")).getId(),req.getParameter("newPassword"));
            doGet(req,resp);
        }else {
            req.setAttribute("errors","Password incorrect!");
            doGet(req,resp);
        }
    }
}

//        if(req.getParameter("passwordRep")!=null&&req.getParameter("passwordRep")!=null&&req.getParameter("password").equals(req.getParameter("passwordRep"))){
//            userService.changePassword(((UserDto)req.getSession().getAttribute("user")).getId(),req.getParameter("password"));
//            req.getSession().getAttribute("id");
//            doGet(req,resp);
//        }else {
//            req.setAttribute("errors","Password incorrect!");
//            doGet(req,resp);
//        }
