/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * https://github.com/javaee/tutorial-examples/LICENSE.txt
 */
package javaeetutorial.hello2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a simple example of an HTTP Servlet. It responds to the GET method of
 * the HTTP protocol.
 */

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html> \n "
                    + " \t <head> \n "
                    + " \t \t <title> Servlet Hello </title> \n "
                    + " \t </head>");
            out.println("\t <style>\n"  
            		+ "     h1.myClass { \n "  
            		+ "    	font-size: 14px; \n "  
            		+ "    	color: red; \n " 
            		+ "     } \n "   
            		+ "     h1.green { \n "  
            		+ "    	font-size: 10px; \n "  
            		+ "    	color: green; \n " 
            		+ "     } \n "   
            		+ "     h1.blue { \n "  
            		+ "    	font-size: 10px; \n "  
            		+ "    	color: blue; \n " 
            		+ "     } \n " 
            		+ " 	h6.green { \n "
            		+ "			font-size: 8px;"
            		+ "			color: green;"
            		+ "		} \n "
            		+ " 	h6.blue { \n "
            		+ "			font-size: 8px;"
            		+ "			color: blue;"
            		+ "		} \n "  
            		+ "\t </style> \n ");
            
            // then write the data of the response
            out.println(" <body  bgcolor=\"#ffffff\"> \n " );
//            String username1st = request.getParameter("username");
//            if (username1st == null || username1st.length() <= 0) {
	            out.println(" <h1> GreetingServlet.doGet( request, response ) \\/ </h1> "
	            		+ "   <h1 class=\"myClass\"> <a href=\"https://javaee.github.io/tutorial/webapp004.html\">tutorial</a> </h1> \n "
	            		+ "   <a href=\"https://github.com/javaee/tutorial-examples\">code source</a> <br>"
	                    + "   <img src=\"resources/images/duke.waving.gif\" alt=\"Duke waving his hand\"> \n "
	                    + "   <form method=\"get\"> \n "
	                    + "   	\t <h2> Hello, my name is Duke. What's yours? </h2> \n "
	                    + "   	\t <input title=\"My name is: \" type=\"text\" name=\"username\" size=\"25\"/> \n "
	                    + "   	\t <p></p> "
	                    + "   	\t <input type=\"submit\" value=\"Submit\"/> \n "
	                    + "   	\t <input type=\"reset\" value=\"Reset\"/> \n "
	                    + "   </form> \n ");
//            }
            
            String username = request.getParameter("username");
            if (username != null && username.length() > 0) {
//            	out.println("<h2>Hello, " + username + "!</h2>");
            	
                RequestDispatcher dispatcher =
                        getServletContext().getRequestDispatcher("/response");
                
                if (dispatcher != null) {
                	out.println("<h6 class=\"blue\"> dispatcher.include(request, response) \\/ </h6>");
                    dispatcher.include(request, response);
                    out.println("<h6 class=\"blue\"> dispatcher.include(request, response) /\\ </h6>");
                }
            }
            
            RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher("/ConfWebApps");
            out.println("<h6 class=\"green\"> dispatcher2.include(request, response) \\/ </h6>");
            dispatcher2.include(request, response);
            out.println("<h6 class=\"green\"> dispatcher2.include(request, response) /\\ </h6>");
            
            out.println(" <br> \n "
            		+ " <form method=\"get\" action=\"ThrowException\" /> \n "
            		+ " <input type=\"submit\" value=\"Test Unhandled Exceptions\" /> <br> \n "
            		+ " </form> \n ");
            
            out.println(" <br> \n "
            		+ " <form method=\"get\" action=\"non_existent_page\" /> \n "
            		+ " <input type=\"submit\" value=\"Test 404 error page\" /> <br> \n "
            		+ " </form> \n ");
            
            out.println(" <br> \n "
            		+ " <form method=\"get\" action=\"SendErrorResponse\" /> \n "
            		+ " <input type=\"submit\" value=\"Test default error page\" /> <br> \n "
            		+ " </form> \n ");
            
            out.println("<h1> GreetingServlet.doGet( request, response ) /\\ </h1>");
            out.println("</body> \n "
            		+ " </html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "GreetingServlet.getServletInfo: The Hello servlet says hello.";
    }
}
