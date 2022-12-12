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

@WebServlet(name = "RemoveUserScalesChords", value = "/removeUserScalesChords")
public class RemoveUserScalesChords extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        UserScaleDao userScaleDao = new UserScaleDao();
        UserChordDao userChordDao = new UserChordDao();

        // Get the value of the button that was clicked
        String deleteBtnValue = request.getParameter("deleteBtn");

        /* Split the value (a string) at the underscore, creating two tokens.  The first token will be either "scale"
        *  or "chord".  The second token will be the name of the scale/chord.
        */
        String[] values = deleteBtnValue.split("_");

        /* get the userId of the user from the username in the session
        String username = session.getAttribute("username");
        User user = userDao.getUserByUserName(username);
        int userId = user.getUserId();
        */

        // temporary using hardcoded username
        User user = userDao.getUserByUserName("markyK");  // gibbons47
        int userId = user.getUserId();

        // if the first token is "scale"
        if (values[0].equals("scale")) {
            // use the other token to get the name of the scale
            String scaleName = values[1];

            // call UserScaleDao's getUserScalesByName() sending the scale name.  A list of userScales will be returned.
            List<UserScale> userScales = userScaleDao.getUserScalesByName(scaleName);

            // loop through the list of scales
            for (UserScale scale : userScales) {
                User loopUser = scale.getUser();

                // if the user id of the scale equals the userId of the current logged-in user
                if (loopUser.getUserId() == userId) {
                    // call UserScaleDao's delete() sending the UserScale to delete
                    userScaleDao.delete(scale);
                }
            }
        } else { // (values[0].equals("chord"))
            // use the other token to get the name of the chord
            String chordName = values[1];

            // call UserChordDao's getUserChordsByName() sending the chord name.  A list of userChords will be returned.
            List<UserChord> userChords = userChordDao.getUserChordsByName(chordName);

            // loop through the list of scales
            for (UserChord chord : userChords) {
                User loopUser = chord.getUser();

                // if the user id of the scale equals the userId of the current logged-in user
                if (loopUser.getUserId() == userId) {
                    // call UserScaleDao's delete() sending the UserScale to delete
                    userChordDao.delete(chord);
                }
            }
        }

        // get the list of userScales in the DB for current user, using the user's username
        List<UserScale> userScaleList = userScaleDao.getUserScalesByUsername(user.getUserName());
        // add the list of userScales to the session map
        request.setAttribute("userScales", userScaleList);

        // get the list of userChords in the DB for current user, using the user's username
        List<UserChord> userChordList = userChordDao.getUserChordsByUsername(user.getUserName());
        // add the list of userChords to the session map
        request.setAttribute("userChords", userChordList);

        request.setAttribute("userConfirmDeletion", "Your scale/chord has been removed.");
        String url = "./viewUserScaleChord.jsp";
        response.sendRedirect(url);
    }
}
