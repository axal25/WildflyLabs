package task13;

import java.io.PrintWriter;
import java.util.Enumeration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet5IntegersAverage
 */
@WebServlet(description = "Servlet that gets 5 Integers as parameters using GET method and returns average", urlPatterns = { "/Servlet5IntegersAverage" })
public class Servlet5IntegersAverage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet5IntegersAverage() {
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
		Enumeration<String> parameters_name_tab = request.getParameterNames();
		String current_parameter_name = null;
		String[] current_parameter_values = null;
		int sum = 0;
		int count = 0;
		String AND = "&amp;";
		
		out.append("<?xml version='1.0' encoding='UTF-8' ?> \n" 
			+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \n" 
			+ "\t		\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> \n" 
			+ "<html lang=\"en\" \n" 
			+ "\t		xmlns=\"http://www.w3.org/1999/xhtml\" \n" 
			+ "\t		xmlns:h=\"http://xmlns.jcp.org/jsf/html\"> \n" 
			+ "<head> \n" 
			+ "\t		<title> Lab1 - Task13 </title> \n" 
			+ "\t		<style> \n" 
			+ "\t\t		h1.myClass { \n" 
			+ "\t\t\t			font-size: 12px; \n" 
			+ "\t\t\t			color: red; \n" 
			+ "\t\t		} \n" 
			+ "\t\t		p.white_space { \n" 
			+ "\t\t\t			white-space:pre; \n" 
			+ "\t\t		} \n" 
			+ "\t		</style> \n " 
			+ "</head> \n "
			+ "<body> \n "
			+ "\t		<h1>Welcome to Lab1 Task13</h1> \n "
			+ "\t		<p> \n "
			+ "\t\t			Served at: <a href=\"http://localhost:8080/Lab1_Task13\">http://localhost:8080/Lab1_Task13</a> \n "
			+ "\t\t\t			or <a href=\"http://localhost:8080/Lab1_Task13/Servlet5IntegersAverage\">http://localhost:8080/Lab1_Task13/Servlet5IntegersAverage</a> <br></br> \n "
			+ "\t\t			<h2>Average from 5 integers:</h2> \n");

		while( parameters_name_tab.hasMoreElements() ) {
			current_parameter_name = parameters_name_tab.nextElement();
			current_parameter_values = request.getParameterValues( current_parameter_name );
			for( String current_parameter_value : current_parameter_values ) {
				if( current_parameter_value.matches("[0-9]+") ) {
					out.append( "\t\t		Parameter #" + (count+1) + " = " + current_parameter_value + "<br></br> \n " );
					sum = sum + Integer.parseInt( current_parameter_value );
					count++;
				}
				else {
					//do nothing
				}
			}
		}
		if( count > 0 ) {
			if( count != 5 ) {
				out.append( "\t\t		Nie podano 5 integerow, podano " + count + " integerow <br></br> \n " );
			}
			out.append( "\t\t		" + sum + "[suma] / " + count + "[licznik] = " + ((float)sum/(float)count) + "[srednia] <br></br> \n " );			
		}
		else {
			out.append( "\t\t			No parameters sent. <br></br> \n ");
		}
		out.append("\t\t	</p> \n ");

		out.append("<h3>Test sent ints = [1,2,3,4,5]</h3>");
		
        out.append("\t\t\t	<br></br> \n  ");
		out.append("<table style=\"width=1%\"> <tr> \n "
				+ "\t\t\t		<form method=\"get\" action=\"\"> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param1\" title=\"param1\" value=\"1\" /> </th> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param2\" title=\"param2\" value=\"2\" /> </th> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param3\" title=\"param3\" value=\"3\" /> </th> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param4\" title=\"param4\" value=\"4\" /> </th> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param5\" title=\"param5\" value=\"5\" /> </th> \n "
	    		+ "\t\t\t\t			<th> <input type=\"submit\" value=\"Use this\"/> </th> \n "
	    		+ "\t\t\t		</form> \n "
	    		// doesn't work - for JSF
//	    		+ "<th> \n "
//	    		+ "<h:form> \n "
//	    		+ "\t	<h:link value=\"Test sen ints = [1,2,3,4,5]\" outcome=\"login.html\"> \n "
//	    		+ "\t\t		<h:param name=\"param1\" value=\"1\"/> \n "
//	    		+ "\t\t		<h:param name=\"param2\" value=\"2\"/> \n "
//	    		+ "\t\t		<h:param name=\"param3\" value=\"3\"/> \n "
//	    		+ "\t\t		<h:param name=\"param4\" value=\"4\"/> \n "
//	    		+ "\t\t		<h:param name=\"param5\" value=\"5\"/> \n "
//	    		+ "\t	</h:link> \n"
//	    		+ "</h:form> \n "
//	    		+ "</th> \n "
	    		+ "<th> \n "
	    		+ "<a href=\"?param1=1" + AND + "param2=2"+ AND + "param3=3" + AND + "param4=4" + AND + "param5=5 \"> or This </a> \n "
	    		+ "</th> \n "
	    		+ "</tr> </table> \n ");
		
		out.append("<table style=\"width=1%\"> <tr> \n "
				+ "\t\t\t		<form method=\"get\" action=\"\"> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param1\" title=\"param1\" value=\"1\" /> </th> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param2\" title=\"param2\" value=\"2\" /> </th> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param3\" title=\"param3\" value=\"3\" /> </th> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param4\" title=\"param4\" value=\"4\" /> </th> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param5\" title=\"param5\" value=\"5\" /> </th> \n "
				+ "\t\t\t\t			<th> <input size=\"1\" type=\"text\" name=\"param6\" title=\"param6\" value=\"6\" /> </th> \n "
	    		+ "\t\t\t\t			<th> <input type=\"submit\" value=\"Use this\"/> </th> \n "
	    		+ "\t\t\t		</form> \n "
	    		+ "<th> \n "
	    		+ "<a href=\"?param1=1" + AND + "param2=2"+ AND + "param3=3" + AND + "param4=4" + AND + "param5=5" + AND + "param6=6 \"> or This </a> \n "
	    		+ "</th> \n "
	    		+ "</tr> </table> \n ");
	
		out.append("</body> \n "
				+ "</html> \n ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
