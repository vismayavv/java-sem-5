<jsp:useBean id="student" class="Student" />

<%
    request.setAttribute("course", "Java");
%>

<html>
<body>
    <h2>Student Details</h2>

    Name: ${student.name} <br>
    Mark: ${student.mark} <br>

    Request Parameter: ${param.username} <br>
    Request Attribute: ${requestScope.course}

</body>
</html>
