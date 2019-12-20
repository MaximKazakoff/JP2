package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UpdateServlet 2");
        System.out.println(request.getParameter("EditType"));
        if ("AddStart".equals(request.getParameter("EditType"))) {
            request.setAttribute("EditType", "AddStart");
            request.setAttribute("id", "id");
            request.setAttribute("name", "name");
            request.setAttribute("password", "password");
            request.setAttribute("money", "money");
            request.getRequestDispatcher("WEB-INF/update.jsp").forward(request, response);

        } else if ("AddEnd".equals(request.getParameter("EditType"))) {
            UserService.getInstance().addUser( new User(
                    request.getParameter("name"),
                    request.getParameter("password"),
                    Long.parseLong(request.getParameter("money"))
                    ));
            request.setAttribute("lists" , UserService.getInstance().getAllUsers());
            request.getRequestDispatcher("WEB-INF/userTable.jsp").forward(request, response);

        } else if ("UpdateStart".equals(request.getParameter("EditType"))) {
            request.setAttribute("EditType", "UpdateStart");
            request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("name", request.getParameter("name"));
            request.setAttribute("password", request.getParameter("password"));
            request.setAttribute("money", request.getParameter("money"));
            request.getRequestDispatcher("WEB-INF/update.jsp").forward(request, response);

        } else if ("UpdateEnd".equals(request.getParameter("EditType"))) {
            System.out.println("UpdateEnd");
            UserService.getInstance().updateUser( new User(
                            Long.parseLong(request.getParameter("id")),
                            request.getParameter("name"),
                            request.getParameter("password"),
                            Long.parseLong(request.getParameter("money"))
                    ));
            request.setAttribute("lists" , UserService.getInstance().getAllUsers());
            request.getRequestDispatcher("WEB-INF/userTable.jsp").forward(request, response);

        } else if ("Delete".equals(request.getParameter("EditType"))) {
            UserService.getInstance().deleteUser(new User(
                    Long.parseLong(request.getParameter("id")),
                    request.getParameter("name"),
                    request.getParameter("password"),
                    Long.parseLong(request.getParameter("money"))
            ));
            request.setAttribute("lists" , UserService.getInstance().getAllUsers());
            request.getRequestDispatcher("WEB-INF/userTable.jsp").forward(request, response);
        }
    }
}
