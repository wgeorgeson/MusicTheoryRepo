package com.mtr.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "logOut", urlPatterns = "/logOut")

public class LogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.removeAttribute("userName");
        String url = "./index.jsp";
        response.sendRedirect(url);
    }
}
