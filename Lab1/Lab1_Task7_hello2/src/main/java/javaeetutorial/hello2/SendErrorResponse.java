package javaeetutorial.hello2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendErrorResponse
 */
@WebServlet(
		description = "Send Error Response to test default error page", 
		urlPatterns = { "/SendErrorResponse" }, 
		initParams = { 
				@WebInitParam(name = "errorCode", value = "600", description = "error code to send back to user via response")
		})
public class SendErrorResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendErrorResponse() {
        super();
    	System.out.println("public class SendErrorResponse.SendErrorResponse()");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	System.out.println("public class SendErrorResponse.doGet( request, response )");
    	int errorCode = 1;
    	String errorCode_s = this.getInitParameter("errorCode");
    	if( errorCode_s.matches("[0-9]+") ) {
    		errorCode = Integer.parseInt( errorCode_s );
    	}
		response.sendError(errorCode, "SendErrorResponse to test default error page");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
