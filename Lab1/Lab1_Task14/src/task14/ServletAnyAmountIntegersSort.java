package task14;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAnyAmountIntegersSort
 */
@WebServlet(description = "Servlet that accepts any amount of Integer through POST and sorts them", urlPatterns = { "/ServletAnyAmountIntegersSort" })
public class ServletAnyAmountIntegersSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAnyAmountIntegersSort() {
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
		int count = 0;
		
		printMyHead( request, response );
		
		out.append("\t\t			<h2>Sort given integers (GET)</h2> \n ");
		
		count = getCount( request, response );
		
		printMyPostForm( request, response, count );
		
		printMyGetForms( request, response, count );
		
		printMyFoot( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		int count = 0;

		printMyHead( request, response );
		
		out.append("\t\t			<h2>Sort given integers (POST)</h2> \n ");
		
		count = getCount( request, response );
		
		printMyPostForm( request, response, count );
		
		printMyGetForms( request, response, count );
		
		forPostOnly_PrintMySortedParams( request, response, count );
		
		printMyFoot( request, response );
	}
	
	private void printMyHead( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.append("<?xml version='1.0' encoding='UTF-8' ?> \n" 
				+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \n" 
				+ "\t		\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> \n" 
				+ "<html lang=\"en\" \n" 
				+ "\t		xmlns=\"http://www.w3.org/1999/xhtml\" \n" 
				+ "\t		xmlns:h=\"http://xmlns.jcp.org/jsf/html\"> \n" 
				+ "<head> \n" 
				+ "\t		<title> Lab1 - Task14 </title> \n" 
				+ "\t		<style> \n" 
				+ "\t\t		h1.myClass { \n" 
				+ "\t\t\t			font-size: 12px; \n" 
				+ "\t\t\t			color: red; \n" 
				+ "\t\t		} \n" 
				+ "\t\t		p.white_space { \n" 
				+ "\t\t\t			white-space:pre; \n" 
				+ "\t\t		} \n" 
				+ "\t		</style> \n " 
				+ "</head> \n " );

		out.append("<body> \n "
				+ "\t		<h1>Welcome to Lab1 Task14</h1> \n "
				+ "\t		<p> \n "
				+ "\t\t			Served at: <a href=\"http://localhost:8080/Lab1_Task14\">http://localhost:8080/Lab1_Task14</a> \n "
				+ "\t\t\t			or <a href=\"http://localhost:8080/Lab1_Task14/ServletAnyAmountIntegersSort\">http://localhost:8080/Lab1_Task14/ServletAnyAmountIntegersSort</a> <br></br> \n ");
	}
	
	private int getCount( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Enumeration<String> parameters_name_tab = request.getParameterNames();
		int count = 0;
		String current_parameter_name = null;
		String[] current_parameter_values = null;
		
		while( parameters_name_tab.hasMoreElements() ) {
			current_parameter_name = parameters_name_tab.nextElement();
			current_parameter_values = request.getParameterValues( current_parameter_name );
			if( current_parameter_name.compareToIgnoreCase( "count" ) == 0 ) {
				for( String current_parameter_current_value : current_parameter_values ) {
					if( current_parameter_current_value.matches("[0-9]+") ) {
						count = Integer.parseInt( current_parameter_current_value );
						break;
					}
				}
			}
		}
		return count;
	}
	
	private void printMyPostForm( HttpServletRequest request, HttpServletResponse response, int count ) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String cur_param_name = null;
		String[] cur_param_values = null;
		int cur_param_value = 0;
		Random gen = new Random();
		
		if( "POST".compareToIgnoreCase( request.getMethod() ) == 0 ) {
			out.append("<p>request.getMethod(): this request was made to POST</p>");
		}
		else {
			out.append("<p>request.getMethod(): this request was made to GET</p>");
		}
		
		out.append("<h3> " + count + " parameters to sort: </h3> \n ");
		if( count > 0 ) {
			out.append("<form method=\"POST\" action=\"\"> \n ");
			for(int i=1; i<=count; i++) {
				cur_param_name = "param" + i;
				if( "POST".compareToIgnoreCase( request.getMethod() ) == 0 ) {
					cur_param_values = request.getParameterValues( cur_param_name );
					for( String tmp_cur_param_value : cur_param_values ) {
						if( tmp_cur_param_value.matches("[0-9]+") ) {
							cur_param_value = Integer.parseInt( tmp_cur_param_value );
							break;
						}
					}
				}
				else {
					cur_param_value = gen.nextInt( Integer.MAX_VALUE );
					cur_param_value = cur_param_value /(int)( (float)Integer.MAX_VALUE/10000.0 );
				}
				out.append("<input size=\"1\" type=\"text\" name=\""+ cur_param_name +"\" title=\"param" + i + "\" value=\"" + cur_param_value + "\" /> \n ");
			}
			out.append("<br/> <input type=\"submit\" value=\"Sort this mess!\"/> <br/> \n ");
			out.append("</form> \n ");
		}
	}
	
	private void printMyGetForms( HttpServletRequest request, HttpServletResponse response, int count ) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.append("<form method=\"GET\" action=\"\"> \n ");
		out.append("<input type=\"hidden\" name=\"count\" value=\"" + (count+1) + "\"/> \n "
				+ "<input type=\"submit\" value=\"Increment amount of params!\"/> \n "
				+ "</form> \n ");
		
		out.append("<form method=\"GET\" action=\"\"> \n ");
		if( count > 0 ) {
			out.append("<input type=\"hidden\" name=\"count\" value=\"" + (count-1) + "\"/> \n "
					+ "<input type=\"submit\" value=\"Decrement amount of params!\"/> <br/> \n "
					+ "</form> \n ");			
		}
		else {
			out.append("<input type=\"hidden\" name=\"count\" value=\"" + count + "\"/> \n "
					+ "<input type=\"submit\" value=\"Decrement amount of params!\"/> <br/> \n "
					+ "</form> \n ");	
		}		
	}
	
	private void printMyFoot( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.append("\t		</p> \n "
				+ "</body> \n "
				+ "</html> \n ");		
	}
	
	private void forPostOnly_PrintMySortedParams( HttpServletRequest request, HttpServletResponse response, int count ) throws ServletException, IOException {
		if( "POST".compareToIgnoreCase( request.getMethod() ) == 0 ) {
			int arrayOfParamsValues[] = new int[ count ];
			Enumeration<String> paramsNames= request.getParameterNames();
			String cur_param_name = null;
			String[] cur_param_values = null;
			String order = "ASC"; /** "DESC"/"ASC" **/
			
			/** !!! Do not use FOR EACH to do substitution !!! 
			 * 
			 * for( int paramValue : arrayOfParamsValues ) {
			 * 		paramValue = 1529012345;
			 * }
			 *
			 * \"int paramValue\" creates new object and copies the values from old one
			 * it's not reference to old object 
			 * 
			 * **/
			for( int i=0; i < arrayOfParamsValues.length; i++ ) {
				if( paramsNames.hasMoreElements() ) {
					cur_param_name = paramsNames.nextElement();
					cur_param_values = request.getParameterValues( cur_param_name );
					for( String cur_param_value : cur_param_values ) {
						if( cur_param_value.matches( "[0-9]+" ) ) {
							arrayOfParamsValues[i] = Integer.parseInt( cur_param_value );
							break;
						}
						else {
							throw new ParameterIsNotIntegerException("!!! Parameter " + cur_param_name + " = " + cur_param_value +  " <--- is NOT integer !!!");
						}
					}
				}
			}
			
			Integer[] ArrayOfIntegers1 = Arrays.stream( arrayOfParamsValues ).boxed().toArray( Integer[]::new );
			Integer[] ArrayOfIntegers2 = IntStream.of( arrayOfParamsValues ).boxed().toArray( Integer[]::new );
			
			Arrays.sort( arrayOfParamsValues );
			
			Comparator<Integer> c = new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
			}};
			Arrays.sort( ArrayOfIntegers1, c );
			
			Arrays.sort( ArrayOfIntegers2, new Comparator<Integer>() {
				@Override
				public int compare( Integer o1, Integer o2 ) {
					return o2.compareTo( o1 );
				}
			});
			
			if( order.compareToIgnoreCase("ASC")==0 ) {
				arrayOfParamsValues = Arrays.stream( ArrayOfIntegers1 ).mapToInt( Integer::intValue ).toArray();				
			}
			if( order.compareToIgnoreCase("DESC")==0 ) {
				arrayOfParamsValues = Arrays.stream( ArrayOfIntegers2 ).mapToInt( Integer::intValue ).toArray();
			}
			
			myPrintArray( response, arrayOfParamsValues );
		}
	}
	
	private void myPrintArray( HttpServletResponse response, int[] anArray ) throws javax.servlet.ServletException, IOException {
		PrintWriter out = response.getWriter();
		for( int i=0; i < anArray.length; i++ ) {
			if( i==0 ) {
				out.println("<table>");
				out.println("\t	<caption>Array</caption>");
			}
			out.println("\t	<tr> ");
			out.println("\t\t	<td>" + (i+1) + ". </td> <td>" + anArray[i] + "</td>");
			out.println("\t	</tr> ");
			if( i==(anArray.length-1) ) {
				out.println("</table>");
			}
		}
	}

}
