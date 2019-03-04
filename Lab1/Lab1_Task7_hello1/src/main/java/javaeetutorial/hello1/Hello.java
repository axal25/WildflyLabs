/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * https://github.com/javaee/tutorial-examples/LICENSE.txt
 */
package javaeetutorial.hello1;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


// source https://javaee.github.io/tutorial/webapp003.html

// Request (@RequestScoped): Request scope persists during a single HTTP request in a web application. 
	// In an application like hello1, in which the application consists of a single request and response, 
	// the bean uses request scope.
// Session (@SessionScoped): Session scope persists across multiple HTTP requests in a web application. 
	// When an application consists of multiple requests and responses where data needs to be maintained, 
	// beans use session scope.
// Application (@ApplicationScoped): Application scope persists across all users' interactions with a web application.

// @Model //instead of @Named and @RequestScoped //a stereotype - encapsulates other annotations
/**
 * 
 * @author jackdaeel
 * 
 * The web page connects to the Hello managed bean through the Expression Language (EL) 
 * value expression #{hello.name}, which retrieves the value of the name property from
 * the managed bean. Note the use of hello to reference the managed bean Hello. 
 * If no name is specified in the @Named annotation of the managed bean, the managed bean 
 * is always accessed with the first letter of the class name in lowercase.
 * 
 */

// Example: @Named("hello")
@Named
@RequestScoped
public class Hello {

    private String name;

    public Hello() {
    	System.out.println("Lab1_Task7_hello1 > public class Hello.Hello(): Yo, created!");
    }

    public String getName() {
    	System.out.println("Lab1_Task7_hello1 > public class Hello.getName(): Yo, the name is " + name + "!");
        return name;
    }

    public void setName(String user_name) {
    	System.out.println("Lab1_Task7_hello1 > public class Hello.setName( " + user_name + " ): Yo, " + user_name + "!");
        this.name = user_name;
    }
}

