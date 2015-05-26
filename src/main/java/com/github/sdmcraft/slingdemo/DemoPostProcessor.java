package com.github.sdmcraft.slingdemo;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.servlets.post.Modification;
import org.apache.sling.servlets.post.SlingPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by satyadeep on 5/26/15.
 */
@Component
@Service
public class DemoPostProcessor implements SlingPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(DemoPostProcessor.class);


    @Override public void process(
            SlingHttpServletRequest request,
            List<Modification> list) throws Exception {
        log.info(">>>>>>>>>Inside DemoPostProcessor.process");
        log.info(">>>>>>>>>>" + request.getResource().getResourceType());
    }
}
