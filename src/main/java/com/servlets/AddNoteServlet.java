package com.servlets;

import com.dao.NoteDAO;
import com.entities.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/add-note")
public class AddNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Note note = new Note(title, content, new Date());

        int id = new NoteDAO().saveNote(note);
        HttpSession session = req.getSession();
        if (id > 0) {
            session.setAttribute("message", "Note added successfully! ID = " + id);
        } else {
            session.setAttribute("message", "Error adding note. Try again.");
        }

        resp.sendRedirect("view_notes.jsp");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("add_note.jsp");
    }
}
