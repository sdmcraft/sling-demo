package com.github.sdmcraft.slingdemo;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.servlets.post.Modification;

import java.util.List;

public interface ResourceTypePostProcessor {
    public void process(
            SlingHttpServletRequest request,
            List<Modification> list) throws Exception;

    public String getResourceType();
}
