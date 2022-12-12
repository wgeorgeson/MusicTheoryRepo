package com.mtr.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.mtr.entity.User;
import com.mtr.entity.UserScale;
import com.mtr.entity.UserChord;
import com.mtr.persistence.UserChordDao;
import com.mtr.persistence.UserDao;
import com.mtr.persistence.UserScaleDao;

@WebServlet(name = "addUserScalesChords", urlPatterns = "/addUserScalesChords")

public class AddUserScalesChords extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        runRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        runRequest(request, response);
    }

    private void runRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // If user is signed in
            String scaleOrChord = request.getParameter("addType");
            String scaleOrChordName = request.getParameter("addName");
            String scaleOrChordNotes = request.getParameter("addNotes");

            // use the user's username to get the User
            // then get the user's id from the User object
            UserDao userDao = new UserDao();
            User user = userDao.getUserById(1);

            if (scaleOrChord.equals("scale")) {
                UserScale userScale = new UserScale(scaleOrChordName, scaleOrChordNotes, user);
                UserScaleDao userScaleDao = new UserScaleDao();
                userScaleDao.insert(userScale);
            } else {  // chord
                UserChord userChord = new UserChord("User", scaleOrChordName, scaleOrChordNotes, user);
                UserChordDao userChordDao = new UserChordDao();
                userChordDao.insert(userChord);
            }

            HttpSession session = request.getSession();

            session.setAttribute("userConfirmAddition", "Your new " + scaleOrChord + " has been added.");
            String url = "./addUserScalesChords.jsp";
            response.sendRedirect(url);
    /* else
           session.setAttribute("unregisteredUser", "You must be a registered user to access this page.");

           String url = "Login page";
           RequestDispatcher dispatcher = req.getRequestDispatcher(url);
           dispatcher.forward(req, resp);
     */
    }
}
