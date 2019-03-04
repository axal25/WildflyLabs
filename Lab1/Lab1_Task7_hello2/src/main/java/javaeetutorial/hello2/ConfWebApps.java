package javaeetutorial.hello2;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfWebApps
 */
@WebServlet(
		description = "Configuring Web Applications", 
		urlPatterns = { "/ConfWebApps" }, 
		initParams = { 
				@WebInitParam(name = "source-url", value = "https://javaee.github.io/tutorial/webapp005.html", description = "Sourcer url to tutorial"), 
				@WebInitParam(name = "source-url2", value = "https://javatutorial.net/java-init-parameters", description = "Source url to additional tutorial")
		})
public class ConfWebApps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfWebApps() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath()); 
		PrintWriter out = response.getWriter();
		
		ServletConfig servletConfig = this.getServletConfig();
		
		String initParameter1 = servletConfig.getInitParameter("source-url");
		String initParameter2 = servletConfig.getInitParameter("source-url2");
		

    	out.println(" <h1 class=\"green\"> ConfWebApps.doGet( request, response ) \\/ </h1> ");
		out.println(" <h1 class=\"myClass\"> servlet init param #1 (name = \"source-url\"): " + initParameter1 + " <br> \n "
				+ 	" servlet init param #2 (name = \"source-url2\"): " + initParameter2 + " <br> </h1> ");
		
		ServletContext servletContext = this.getServletContext();
		String contextParam1 = servletContext.getInitParameter("javax.faces.PROJECT_STAGE");
		String contextParam2 = servletContext.getInitParameter("Context Parameter #2 name");
		out.println(" <br> \n "
				+ " <p> servlet context param #1 (name = \"avax.faces.PROJECT_STAGE\"): " + contextParam1 + " <br> \n "
				+ 	  " servlet context param #2 (name = \"Context Parameter #2 name\"): " + contextParam2 + " <br> </p> ");
		out.println(" <h1 class=\"green\"> ConfWebApps.doGet( request, response ) /\\ </h1> ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
