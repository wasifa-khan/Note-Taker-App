package com.dao;

import com.entities.Note;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NoteDAO {

    public int saveNote(Note note) {
        Transaction tx = null;
        try (Session session = FactoryProvider.getFactory().openSession()) {
            tx = session.beginTransaction();
            int id = (int) session.save(note);
            tx.commit();
            return id;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return -1;
    }

    public List<Note> getAllNotes() {
        try (Session session = FactoryProvider.getFactory().openSession()) {
            return session.createQuery("from Note", Note.class).list();
        }
    }
}
