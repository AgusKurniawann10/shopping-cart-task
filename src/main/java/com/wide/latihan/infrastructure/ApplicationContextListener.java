package com.wide.latihan.infrastructure;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ApplicationContextListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext ctx = sce.getServletContext();
         String dbUrl = ctx.getInitParameter("jdbcUrl");
         String dbUser = ctx.getInitParameter("jdbcUser");
         String dbPass = ctx.getInitParameter("jdbcPass");
         
         DBUtils.setJdbcUrl(dbUrl);
         DBUtils.setJdbcUser(dbUser);
         DBUtils.setJdbcPassword(dbPass);
    }
	
}
