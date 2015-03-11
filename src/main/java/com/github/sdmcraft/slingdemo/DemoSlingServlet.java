package com.github.sdmcraft.slingdemo;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import javax.servlet.Servlet;
import java.io.IOException;

/**
 * Created by satyadeep on 3/11/15.
 */
@Component(immediate = true, metatype = true)
@Service(value = Servlet.class)
@Properties({@Property(name = "sling.servlet.resourceTypes",value = "slingdemo/demo")
})
public class DemoSlingServlet extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws IOException {
        response.getWriter().println("Hi from demo sling servlet!!!");
    }
}
