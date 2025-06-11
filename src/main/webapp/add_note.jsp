<%@ include file="navbar.jsp" %>
<div class="container mt-4">
    <h2>Add a new note</h2>
    <form action="add-note" method="post">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" name="title" id="title" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="content">Content:</label>
            <textarea name="content" id="content" rows="5" class="form-control" required></textarea>
        </div>
        <button class="btn btn-success">Save Note</button>
    </form>
</div>
