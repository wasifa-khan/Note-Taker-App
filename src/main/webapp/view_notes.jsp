<%@ page import="java.util.List, com.dao.NoteDAO, com.entities.Note" %>
<%@ include file="navbar.jsp" %>
<div class="container mt-4">
    <h2>Your Notes</h2>
    <%
        List<Note> notes = new NoteDAO().getAllNotes();
        String msg = (String) session.getAttribute("message");
        if (msg != null) {
    %>
    <div class="alert alert-info"><%= msg %></div>
    <%
            session.removeAttribute("message");
        }
    %>
    <%
        if (notes.isEmpty()) {
    %>
    <p>No notes found. <a href="add_note.jsp">Add one!</a></p>
    <%
    } else {
    %>
    <ul class="list-group">
        <% for (Note n : notes) { %>
        <li class="list-group-item">
            <h5><%= n.getTitle() %></h5>
            <p><%= n.getContent() %></p>
            <small>Added on: <%= n.getAddedDate() %></small>
        </li>
        <% } %>
    </ul>
    <% } %>
</div>
