package com.github.sosedvovan.web;

import com.github.sosedvovan.model.Zapis;
import com.github.sosedvovan.repository.SqlStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ZametkiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String dateTime = request.getParameter("dateTime");
        String description1 = request.getParameter("description1");
        String description2 = request.getParameter("description2");

        Zapis z = new Zapis(Integer.parseInt(id) , dateTime, description1, description2);
        SqlStorage sqlStorage = new SqlStorage();
        sqlStorage.save(z);
        response.sendRedirect("zametki");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlStorage sqlStorage = new SqlStorage();
        String action = request.getParameter("action");
        Zapis z;
        switch (action == null ? "all" : action) {
            case "add":
                z = Zapis.EMPTY;
                request.setAttribute("emptyZapis", z);
                request.getRequestDispatcher("/WEB-INF/jsp/newZapis.jsp").forward(request, response);
                break;
            case "delete":
                String id = request.getParameter("id");
                sqlStorage.delete(Integer.parseInt(id));
                request.setAttribute("allZapis", sqlStorage.getAll());
                request.getRequestDispatcher("/WEB-INF/jsp/allZapis.jsp").forward(request, response);
                break;
            case "all":
            default:
                request.setAttribute("allZapis", sqlStorage.getAll());
                request.getRequestDispatcher("/WEB-INF/jsp/allZapis.jsp").forward(request, response);
                break;

        }
    }
}
