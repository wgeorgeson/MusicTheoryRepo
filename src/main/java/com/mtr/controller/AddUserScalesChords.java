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

/**
 * The type Add user scales chords.
 */
@WebServlet(name = "addUserScalesChords", urlPatterns = "/addUserScalesChords")

public class AddUserScalesChords extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("userName") != null)  // user is logged in
        {
            String username = (String) session.getAttribute("userName");

            String scaleOrChord = request.getParameter("addType");
            String scaleOrChordName = request.getParameter("addName");
            String scaleOrChordNotes = request.getParameter("addNotes");

            // use the user's username to get the User
            // then get the user's id from the User object
            UserDao userDao = new UserDao();
            User user = userDao.getUserByUserName(username);

            if (scaleOrChord.equals("scale")) {
                UserScale userScale = new UserScale(scaleOrChordName, scaleOrChordNotes, user);
                UserScaleDao userScaleDao = new UserScaleDao();
                userScaleDao.insert(userScale);
            } else {  // chord
                UserChord userChord = new UserChord("User", scaleOrChordName, scaleOrChordNotes, user);
                UserChordDao userChordDao = new UserChordDao();
                userChordDao.insert(userChord);
            }

            session.setAttribute("userConfirmAddition", "Your new " + scaleOrChord + " has been added.");
            session.setAttribute("linkToView", "View my added scales/chords.");
            String url = "./addUserScalesChords.jsp";
            response.sendRedirect(url);

        } else {  // user not logged in
            session.setAttribute("unregisteredAdd", "You must be a registered user to add your own scales " +
                    "and chords to our records.");

            String url = "/requestUserLogInAdd.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }
}
