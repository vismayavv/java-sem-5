<%! 
    public void jspInit() {
        System.out.println("JSP Initialized");
    }

    public void jspDestroy() {
        System.out.println("JSP Destroyed");
    }
%>

<html>
<body>
    <h2>JSP Life Cycle</h2>
    <%
        out.println("JSP Service Method");
    %>
</body>
</html>
