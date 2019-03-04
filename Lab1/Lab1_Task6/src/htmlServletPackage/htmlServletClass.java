package htmlServletPackage;

import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class htmlServletClass
 */
@WebServlet(description = "htmlServletClass Description", urlPatterns = { "/htmlServletClass" })
public class htmlServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htmlServletClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String queryString = request.getQueryString();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if( queryString == null
				// http://localhost:8080/Lab1_Task6_Servlet_Html_HelloWorld_14_0_1_F_HA/task6
				|| queryString.length() == 0 
				|| queryString.compareTo("") == 0 
				|| queryString.isEmpty() 
				|| queryString.equals("") ) {
			out.println("<html><body><p>");
			out.println("<h1> doGet </h1>");
			response.getWriter().append("Served at: ").append( request.getRequestURI() ).append(" <br> \n <br> \n"
					+ "avalaible at: http://localhost:8080/Lab1_Task6/task6 <br> \n "
					+ "or: http://localhost:8080/Lab1_Task6/htmlServletClass");
			out.println("</p>");
			out.println("\n"
					+ "<form method=\"POST\" action=\"http://localhost:8080/Lab1_Task6_Servlet_Html_HelloWorld_14_0_1_F_HA/task6\"> \n"
					+ "\t x: <input type=\"text\" name=\"paramX\"> <br> \n"
					+ "\t y: <input type=\"text\" name=\"paramY\"> <br> \n"
					+ "\t <input type=\"submit\" value=\"Dodaj\"> <br> \n"
					+ "</form> \n");
			out.println("</body></html>");
			out.close();
		} 
		else {
			if( request.getParameter( "paramX" ) == null || request.getParameter( "paramY" ) == null ) {
				// http://localhost:8080/Lab1_Task6_Servlet_Html_HelloWorld_14_0_1_F_HA/task6
				// ?paramZ=123
				out.println("<html> \n" + 
						"\t <head> \n" + 
						"\t <meta http-equiv=\"refresh\" content=\"3;url= http://localhost:8080" + 
						request.getRequestURI() +
						"\" /> \n" + 
						"\t </head> \n" + 
						"\t <body> \n" + 
						"\t\t <h1>Redirecting in 3 seconds...</h1> \n" + 
						"<p> !!! bad query string !!! <br> no paramX or paramY </p>" +
						"<p> queryString: " + queryString + "</p> \n" +
						"\t </body> \n" + 
						"</html>");
			}
			else {
				if( request.getParameter( "paramFlag_doPost" ) == null ) {
					// http://localhost:8080/Lab1_Task6_Servlet_Html_HelloWorld_14_0_1_F_HA/task6
					// ?paramX=1&paramY=2
					out.println("<html><head>"
							+ "<meta http-equiv=\"refresh\" content=\"3;url= http://localhost:8080" 
							+ request.getRequestURI() + "?" + request.getQueryString() + "&paramFlag_doPost=true" 
							+ "\" /> \n"
							+ "</head> \n"
							+ "<body> \n");
					out.println("Redirecting in 3 seconds to doPost");
					out.println("</body> \n"
							+ "</html>");					
				}
				else {
					// http://localhost:8080/Lab1_Task6_Servlet_Html_HelloWorld_14_0_1_F_HA/task6
					// ?paramX=1&paramY=2&paramFlag_doPost=true
					
	//					try {
	//						java.util.concurrent.TimeUnit.SECONDS.sleep( 5 );
	//					} catch (InterruptedException e) {
	//						// TODO Auto-generated catch block
	//						e.printStackTrace();
	//					}
					doPost( request, response );					
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1> doPost </h1>");
		String s_paramX = request.getParameter("paramX");
		String s_paramY = request.getParameter("paramY");
		if( s_paramX.matches("[0-9]+") && s_paramY.matches("[0-9]+") ) {
			out.println("<p> paramX = " + s_paramX + " <br> "
					+ " paramY = " + s_paramY + " <br> "
					+ " paramX + paramY = " + ( Integer.parseInt( s_paramX ) + Integer.parseInt( s_paramY ) ) + " </p>");
			out.println("</body></html>");
			out.close();
		}
		else {
			out.println("<p> paramY = " + s_paramY + " <br> paramX = " + s_paramX + " <br> these are not integers </p>");
		}
	}
}
