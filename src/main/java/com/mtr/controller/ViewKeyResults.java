package com.mtr.controller;

import com.mtr.entity.*; // KeyScaleDao, KeyChordDao, SongDao
import com.mtr.persistence.*;  // KeyScaleDao, KeyChordDao, SongDao

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "viewKeyResults", urlPatterns = "/viewKeyResults")

public class ViewKeyResults extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chosenKey = request.getParameter("key");

        KeyScaleDao keyScaleDao = new KeyScaleDao();
        KeyChordDao keyChordDao = new KeyChordDao();
        SongDao songDao = new SongDao();

        List<KeyScale> keyScales = keyScaleDao.getKeyScalesByKeyName(chosenKey);
        List<KeyChord> keyChords = keyChordDao.getKeyChordsByKeyName(chosenKey);
        List<Song> songs = songDao.getSongsByKey(chosenKey);

        request.setAttribute("chosenKey", chosenKey);
        request.setAttribute("scales", keyScales);
        request.setAttribute("chords", keyChords);
        request.setAttribute("songs", songs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/keyResults.jsp");
        dispatcher.forward(request, response);
    }


}
