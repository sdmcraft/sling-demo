package com.github.sdmcraft.slingdemo;


import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.servlets.post.Modification;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component(metatype = true, immediate = true)
@Service
@Properties({@Property(name = "sling.servlet.resourceTypes",value = "slingdemo")})
public class ResourceTypePostProcessorImpl implements  ResourceTypePostProcessor {

    private static final Logger log = LoggerFactory.getLogger(ResourceTypePostProcessorImpl.class);
    private String resourceType;

    @Activate
    public void activate(ComponentContext ctx) {
        resourceType = (String)ctx.getProperties().get("sling.servlet.resourceTypes");
    }

    @Override public void process(SlingHttpServletRequest request,
            List<Modification> list) throws Exception {
        log.info(">>>>>>>>>Inside ResourceTypePostProcessorImpl");
    }

    public String getResourceType() {
        return resourceType;
    }

}
