package com.mtr.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ApplicationStartup",
        urlPatterns = {"/ApplicationStartup"},
        loadOnStartup = 1   // causes this Servlet to be loaded at startup and its init() to be run
)

public class ApplicationStartup extends HttpServlet {

    public void init() throws ServletException {
        ServletContext application = getServletContext();

        application.setAttribute("title", "Home - Music Theory Repo");
    }
}
