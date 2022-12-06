package com.mtr.controller;

import com.mtr.entity.*; // KeyScaleDao, KeyChordDao, SongDao
import com.mtr.persistence.*;  // KeyScaleDao, KeyChordDao, SongDao

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<String, List> keyMap = new HashMap<>();
        keyMap.put("scales", keyScales);
        keyMap.put("chords", keyChords);
        keyMap.put("songs", songs);

        request.setAttribute("keyMap", keyMap);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/keyResults.jsp");
        dispatcher.forward(request, response);
    }


}
