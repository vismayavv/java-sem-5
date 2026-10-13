<html>
<body>
    <%
        String name = request.getParameter("name");
        session.setAttribute("username", name);
    %>

    Name: <%= name %> <br>

    Session: <%= session.getAttribute("username") %>
</body>
</html>
