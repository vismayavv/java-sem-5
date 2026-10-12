<html>
<body>
    <h2>Student Management</h2>

    <form action="StudentServlet" method="post">
        ID: <input type="number" name="id" required><br><br>

        Name: <input type="text" name="name"><br><br>

        Mark: <input type="number" name="mark"><br><br>

        <button name="action" value="add">Add</button>
        <button name="action" value="update">Update</button>
        <button name="action" value="delete">Delete</button>
    </form>

    <br>
    <a href="StudentServlet">View All Students</a>
</body>
</html>
