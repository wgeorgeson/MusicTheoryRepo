package com.mtr.controller;

import com.mtr.entity.User;
import com.mtr.entity.UserChord;
import com.mtr.entity.UserScale;
import com.mtr.persistence.UserChordDao;
import com.mtr.persistence.UserDao;
import com.mtr.persistence.UserScaleDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "viewUserScalesChords", urlPatterns = "/viewUserScalesChords")

public class ViewUserScalesChords extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        runRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        runRequest(request, response);
    }

    private void runRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // IF USER IS LOGGED IN

            /* UNCOMMENT THE NEXT LINE WHEN LOGIN FUNCTIONALITY WORKING */
            // String username = session.getAttribute("username");

            // Get a list of the user's userScales using the username from the session
            UserScaleDao userScaleDao = new UserScaleDao();
            List<UserScale> userScaleList = userScaleDao.getUserScalesByUsername("markyK"); // userScaleDao.getUserScalesByUsername(username)
            // add the list of userScales to the request map
            req.setAttribute("userScales", userScaleList);

            // match the userid with the userids in the userChords table.  Get a list of the user's userChords
            UserChordDao userChordDao = new UserChordDao();
            List<UserChord> userChordList = userChordDao.getUserChordsByUsername("markyK"); // userScaleDao.getUserScalesByUsername(username)
            // add the list of userChords to the request map
            req.setAttribute("userChords", userChordList);

            String url = "/viewUserScaleChord.jsp";
            RequestDispatcher dispatcher = req.getRequestDispatcher(url);
            dispatcher.forward(req, resp);

        /* ELSE
               session.setAttribute("unregisteredUser", "You must be a registered user to access this page.");

               String url = "Login page";
               RequestDispatcher dispatcher = req.getRequestDispatcher(url);
               dispatcher.forward(req, resp);
        */
    }
}
