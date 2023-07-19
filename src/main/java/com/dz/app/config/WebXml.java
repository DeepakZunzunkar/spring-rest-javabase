package com.dz.app.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXml implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		System.out.println("Loading...WebXml");
		AnnotationConfigWebApplicationContext webcontext=new AnnotationConfigWebApplicationContext();
		webcontext.register(SpringBeanXml.class);
		webcontext.setServletContext(servletContext);
		ServletRegistration.Dynamic servlet=servletContext.addServlet("springmvc", new DispatcherServlet(webcontext));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
	}
}
