package com.mtr.controller;

import com.mtr.entity.UserChord;
import com.mtr.entity.UserScale;
import com.mtr.persistence.UserChordDao;
import com.mtr.persistence.UserScaleDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * The type View user scales chords.
 */
@WebServlet(name = "viewUserScalesChords", urlPatterns = "/viewUserScalesChords")

public class ViewUserScalesChords extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        // check if user is logged in
        if (session.getAttribute("userName") != null) {
            String username = (String) session.getAttribute("userName");

            // Get a list of the user's userScales using the username from the session
            UserScaleDao userScaleDao = new UserScaleDao();
            List<UserScale> userScaleList = userScaleDao.getUserScalesByUsername(username); // userScaleDao.getUserScalesByUsername(username)
            // add the list of userScales to the request map
            req.setAttribute("userScales", userScaleList);

            // match the userid with the userids in the userChords table.  Get a list of the user's userChords
            UserChordDao userChordDao = new UserChordDao();
            List<UserChord> userChordList = userChordDao.getUserChordsByUsername(username); // userScaleDao.getUserScalesByUsername(username)
            // add the list of userChords to the request map
            req.setAttribute("userChords", userChordList);

            String url = "/viewUserScaleChord.jsp";
            RequestDispatcher dispatcher = req.getRequestDispatcher(url);
            dispatcher.forward(req, resp);

        } else {
            session.setAttribute("unregisteredView", "You must be signed in to view your own scales " +
                    "and chords.");

            String url = "/requestUserLogInView.jsp";
            RequestDispatcher dispatcher = req.getRequestDispatcher(url);
            dispatcher.forward(req, resp);
        }
    }
}
