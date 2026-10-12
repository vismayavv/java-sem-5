import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class MyTag extends SimpleTagSupport {
    public void doTag()
            throws JspException, IOException {
        getJspContext().getOut().println("Hello Student");
    }
}
