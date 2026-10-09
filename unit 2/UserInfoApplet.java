import java.applet.Applet;
import java.awt.Graphics;

public class UserInfoApplet extends Applet {

    String name;
    String regNo;
    String course;
    String semester;

    public void init() {

        name = getParameter("name");
        regNo = getParameter("regno");
        course = getParameter("course");
        semester = getParameter("semester");
    }

    public void paint(Graphics g) {

        g.drawString("Student Information", 50, 50);
        g.drawString("Name: " + name, 50, 80);
        g.drawString("Register No: " + regNo, 50, 110);
        g.drawString("Course: " + course, 50, 140);
        g.drawString("Semester: " + semester, 50, 170);
    }
}
/*
<html>
<body>

<applet code="UserInfoApplet.class" width="500" height="250">

<param name="name" value="Vismaya">
<param name="regno" value="101">
<param name="course" value="Computational Science">
<param name="semester" value="4">

</applet>

</body>
</html>
*/
