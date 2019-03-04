package welcomePackage;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet(description = "Start servlet with links to other projects from Lab1", urlPatterns = { "/WelcomeServlet" })
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
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
		out.append("<?xml version='1.0' encoding='UTF-8' ?> \n" 
				+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \n" 
				+ "\t		\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> \n" 
				+ "<html lang=\"en\" \n" 
				+ "\t		xmlns=\"http://www.w3.org/1999/xhtml\" \n" 
				+ "\t		xmlns:h=\"http://xmlns.jcp.org/jsf/html\"> \n" 
				+ "<head> \n" 
				+ "\t		<title> Lab1 - welcome </title> \n" 
				+ "\t		<style> \n" 
				+ "\t\t		h1.myClass { \n" 
				+ "\t\t\t			font-size: 12px; \n" 
				+ "\t\t\t			color: red; \n" 
				+ "\t\t		} \n" 
				+ "\t\t		p.white_space { \n" 
				+ "\t\t\t			white-space:pre; \n" 
				+ "\t\t		} \n "
				+ "\t\t		dl { \n " 
				+ "\t\t\t			background-color: #f69333; \n "  
				+ "\t\t\t			counter-reset: myDTCounter; \n "  
				+ "\t\t		}"
				+ "\t\t		dt { \n " 
				+ "\t\t\t			background-color: #f6a633; \n "
				+ "\t\t\t			font-weight: bold; \n "
				+ "\t\t\t			counter-reset: myDDCounter; \n " 
				+ "\t\t		}" 
				+ "\t\t		dt::before { \n " 
				+ "\t\t\t			counter-increment: myDTCounter; \n " 
				+ "\t\t\t			content: counter(myDTCounter) \".\" ; \n " 
				+ "\t\t		}" 
				+ "\t\t		dd { \n " 
				+ "\t\t\t			background-color: #f6b33; \n "
				+ "\t\t\t			font-weight: 100; \n "
				+ "\t\t		}" 
				+ "\t\t		dd::before { \n " 
				+ "\t\t\t			counter-increment: myDDCounter; \n " 
				+ "\t\t\t			content: counter(myDDCounter, lower-alpha) \")\" ; \n " 
				+ "\t\t		}" 
				+ "\t		</style> \n " 
				+ "</head> \n "
				+ "<body> \n "
				+ "<h1>Welcome to Lab1</h1> \n "
				+ "<p> \n "
				+ "Served at: <a href=\"http://localhost:8080/lab1\">http://localhost:8080/lab1</a> \n "
				+ " or <a href=\"http://localhost:8080/lab1/WelcomeServlet\">http://localhost:8080/lab1/WelcomeServlet</a> \n <br></br> \n "
				+ "</p> \n "
				+ "<h3>Deployment info:</h3> \n "
				+ "<p> \n "
				+ "Java 1.8 <br/> \n "
				+ "Wildfly 14.0.1 <br/> \n "
				+ "Config: Full HA (.xml) <br/> \n "
				+ "</p> \n "
				+ "<h3>Project properties:</h3> \n "
				+ "<p> \n "
				+ "Project Properties > Project facets > Java 1.8 <br/> \n "
				+ "Project Properties > Java Compiler > Enable project specific settings > ... <br/> \n "
				+ "&emsp; Compiler compliance level: 1.8, Use default compliance settings: checked <br/> \n "
				+ "Project Properties > Java Build Path > JRE System Library [java-8-openjdk-amd64] > Alternate JRE > Installed JREs > Add > ... <br/> \n "
				+ "&emsp; (Name: java-8-openjdk-amd64; Location: /usr/lib/jvm/java-8-openjdk-amd64; Type: Standard VM) <br/> \n "
				+ "Deployment Assembly > (Source: /src/; Deplyo Path: WEB-INF/classes) <br/> \n "
				+ "Other deployments: <br/> \n "
				+ "&emsp; (Source: Maven Dependencies; WEB-INF/lib ) <br/> \n "
				+ "&emsp; (Source: /src/main/webapp; Deploy path: / ) <br/> \n "
				+ "&emsp; (Source: /target/m2e-wtp/web-resouorces; Deploy path: / ) <br/> \n "
				+ "</p> \n "
				+ "<h3>What to do when *.war file doesn't change name:</h3> \n "
				+ "<p> \n "
				+ "1. Open pom.xml and add: <br/> \n "
				+ "&emsp; &lt;project ...&gt; <br/> \n "
				+ "&emsp; &emsp; ... <br/> \n "
				+ "&emsp; &emsp; &lt;build&gt; <br/> \n "
				+ "&emsp; &emsp; &emsp; &lt;finalName&gt; warName &lt;/finalName&gt; <br/> \n "
				+ "&emsp; &emsp; &lt;/build&gt; <br/> \n "
				+ "&emsp; &lt;/project&gt; <br/> \n "
				+ "2. Go to: <br/> \n "
				+ "&emsp; ~/jboss_dev_studio_workspace/Lab1/Lab1_Task7_hello1/.settings/org.eclipse.wst.common.component <br/> \n "
				+ "&emsp; check line: &lt;wb-module deploy-name=\"hello1\"&gt; <br/> \n "
				+ "&emsp; It should look like this: <br/> \n "
				+ "<code> \n "
				+ "&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;&lt;project-modules id=\"moduleCoreId\" project-version=\"1.5.0\"&gt; <br/> \n "
				+ "&emsp; &lt;wb-module deploy-name=\"Lab1_Task7_hello1\"&gt; <br/> \n"
				+ "&emsp; &emsp; &lt;wb-resource deploy-path=\"/\" source-path=\"/target/m2e-wtp/web-resources\"/&gt; <br/> \n "
				+ "&emsp; &emsp; &lt;wb-resource deploy-path=\"/\" source-path=\"/src/main/webapp\" tag=\"defaultRootSource\"/&gt; <br/> \n "
				+ "&emsp; &emsp; &lt;wb-resource deploy-path=\"/WEB-INF/classes\" source-path=\"/src/main/java\"/&gt; <br/> \n "
				+ "&emsp; &emsp; &lt;property name=\"java-output-path\" value=\"/Lab1_Task7_hello1/target/classes\"/&gt; <br/> \n "
				+ "&emsp; &emsp; &lt;property name=\"context-root\" value=\"Lab1_Task7_hello1\"/&gt; <br/> \n "
				+ "&emsp; &lt;/wb-module&gt; <br/> \n "
				+ "&lt;/project-modules&gt; <br/> \n "
				+ "</code> \n "
				+ "</p> \n "
				+ "<h2>Projects from lab1:</h2> \n"
				+ "<p> \n "
				+ "\t	<a href=\"http://localhost:8080/lab1_task5/task5\"> Lab1 Task 5 </a> or \n"
				+ "\t	<a href=\"http://localhost:8080/lab1_task5/MyFirstServletClass\"> Lab1 Task 5 </a> <br></br> \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task6/task6\"> Lab1 Task 6 </a> or \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task6/htmlServletClass\"> Lab1 Task 6 </a> <br></br> \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task7_hello1/\"> Lab1 Task 7 - hello1 </a> or \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task7_hello1/index.xhtml\"> Lab1 Task 7 - hello1 </a> <br></br> \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task7_hello2/greeting\"> Lab1 Task 7 - hello2 </a> <br></br> \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task7_hello2/directory\"> Lab1 Task 7 - hello 2 - available </a> or \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task7_hello2/directory/available.xhtml\"> Lab1 Task 7 - hello 2 - available </a> <br></br> \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task7_Resource_References/\"> Lab1 Task 7 - Resource references - theory </a> or \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task7_Resource_References/index.xhtml\"> Lab1 Task 7 - Resource references - theory </a> <br></br> \n " 
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task13/Servlet5IntegersAverage\"> Lab1 Task 13 </a> or \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task13/\"> Lab1 Task 13 </a> <br></br> \n " 
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task14/ServletAnyAmountIntegersSort\"> Lab1 Task 14 </a> or \n "
				+ "\t	<a href=\"http://localhost:8080/Lab1_Task14/\"> Lab1 Task 14 </a> <br></br> \n "
				+ "\t	<a href=\"https://access.redhat.com/documentation/en-us/red_hat_developer_studio/12.9/html/getting_started_with_developer_studio_tools/setting_up_and_managing_a_repository_for_your_projects\"> \n "
				+ "\t	Github inside JBoss Dev Studio tutorial (<strong>login required</strong>) </a> \n "
				+ "<br/>"
				+ "<h4>My streamlined tutorial</h4> \n "
				+ "<dl> \n "
				+ "<dt> Opening GIT perspective </dt> \n "
				+ "\t	<dd> Window > Perspective > Open Perspective > Other > Open Perspective > Git </dd> \n "
				+ "<dt> New GIT repository </dt> \n "
				+ "\t	<dd> Click \"Create a new Git Repository ...\" button </dd> \n " 
				+ "\t	<dd> Choose \"Repository directory\" (different than normal workspace): /home/jackdaeel/jboss_dev_studio_git_workspace/lab1_repo </dd> \n "
				+ "\t	<dd> Do not choose \"Create as bare repository option\" </dd> \n "
				+ "\t	<dd> Create REMOTE repository through Github.com </dd> \n " 
				+ "\t	<dd> Example: <a href=\"https://github.com/axal25/Wildfly-SOA-lab1 \"> https://github.com/axal25/Wildfly-SOA-lab1 </a> </dd> \n "
				+ "<dt> Connecting remote repository to local repository </dt> \n "
				+ "\t	<dd> Remote repository - created through Github.com </dd> \n "
				+ "\t	<dd> Local repository - created through JBoss dev studio </dd> \n "
				+ "\t	<dd> lab1_repo[master] > Remotes > Create Remote > New Remote > Configure Push > OK </dd> \n "
				+ "\t	<dd> \"Configure Push\" dialog > Change > URI > \" \n "
				+ "\t	<a href=\"https://github.com/axal25/Wildfly-SOA-lab1 \"> https://github.com/axal25/Wildfly-SOA-lab1 </a> \" </dd> \n "
				+ "\t	<dd> This automatically populates \"Host\" and \"Repository path\" </dd> \n "
				+ "\t	<dd> Connection > Protocol: https, Port: *blank* </dd> \n "
				+ "\t	<dd> Authentication > Username: yourusername, Password: yourpassword, Store in Secure Store: *checked* > Finish </dd> \n "
				+ "\t	<dd> Save </dd> \n "
				+ "\t	<dd> Now in remotes you should have \"origin\" with push and fetch listings </dd> \n "
				+ "\t	<dd> lab1_repo > Remotes > origin > https://github.com/axal25/Wildfly-SOA-lab1 (push - arrow towards cloud) > Right-click </dd> \n "
				+ "\t	<dd> Configure push > Ref mappings > Add > Local branch: master-local, Remote branch: … </dd> \n "
				+ "\t	<dd> Now when you click on \"Remote branch\" text field a quick pop-up search bar should appear (try typing in ‘m’) "
				+ "\t	and list available branches for you to choose for example \"master[branch]\" </dd> \n "
				+ "\t	<dd> After you click on it, it should change to \"refs/heads/master\" and Specification field should populate itself "
				+ "\t	like so \"master-local:refs/heads/master\" </dd> \n "
				+ "\t	<dd> OK > Save </dd> \n "
				+ "\t	<dd> lab1_repo > Remotes > origin > https://github.com/axal25/Wildfly-SOA-lab1 (fetch - arrow away from cloud) > Right-click </dd> \n "
				+ "\t	<dd> Configure fetch > Ref mappings > Add > Remote repository: *unchanged* https://github.com/axal25/Wildfly-SOA-lab1, Source: … </dd> \n "
				+ "\t	<dd> Now when you click on \"Source\" text field a quick pop-up search bar should appear (try typing in ‘m’) \n"
				+ "\t	and list available branches for you to choose for example \"master[branch]\" </dd> \n "
				+ "\t	<dd> After you click on it, it should change to \"refs/heads/master\" </dd> \n "
				+ "\t	<dd> Next > Local repository: *unchanged* lab1_repo, <br/> \n "
				+ "\t	source: *unchanged refs/heads/master, <br/> \n "
				+ "\t	Destination: *unchanged* refs/remotes/origin/master </dd> \n "
				+ "\t	<dd> Finish > Save </dd> \n "
				
				+ "<dt> Creating branches </dt> \n "
				+ "\t	<dd> \n "
				+ "\t	<dl> \n "
				+ "\t	<dt> Creating remote branch </dt> \n "
				+ "\t	<dd> There already should be remote branch created during configuring Remotes (try fetching if not) </dd> \n " 
				+ "\t	<dd> lab1_repo > Branches > Remote Tracking > origin/master #commit_number# Initial commit </dd> \n " 
				+ "\t	<dt> Creating local branch </dt> \n "
				+ "\t	<dd> lab1_repo > Branches > Local > Switch to > New Branch </dd> \n " 
				+ "\t	<dd> Source > Select … > origin/master #commit_number# Initial commit > OK > <br/> \n "
				+ "\t	Branch name: local-master, Check out new branch: checked > Finish </dd> \n " 
				+ "\t	</dl> \n "
				+ "\t	</dd> \n "
				+ "\t	<dd> Remember to check out local branch </dd> \n " 
				+ "\t	<dd> Fetch initiated files from remote repository </dd> \n "
				+ "\t	<dd> They should appear: lab1_repo > Working Tree > .git > README.md </dd> \n " 
				+ "<dt> Adding projects to repository </dt> \n "
				+ "\t	<dd> Window > Perspective > Open perspective > Other > JBoss (default) </dd> \n " 
				+ "\t	<dd> New  > Dynamic Web Project > Project name: Lab1_Test, Add project to working sets: checked </dd> \n " 
				+ "\t	<dd> Working sets > New > Java > Lab1_all_Wildfly14 > Finish > Next > Next > Generate web.xml deployment descriptor: checked > Finish </dd> \n "
				+ "\t	<dd> Window > Perspective > Open Perspective > Other > Open Perspective > Git </dd> \n "
				+ "\t	<dd> here ... </dd> \n "
				
				+ "</dl> \n " 
				+ "</p> \n "
				+ "</body> \n "
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
