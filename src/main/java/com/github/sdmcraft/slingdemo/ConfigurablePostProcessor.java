package com.github.sdmcraft.slingdemo;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.servlets.post.Modification;
import org.apache.sling.servlets.post.SlingPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service
@Reference(name = "resourceTypePostProcessors",referenceInterface = ResourceTypePostProcessor.class, policy = ReferencePolicy.DYNAMIC, bind = "bindResourceTypePostProcessor",
        unbind = "unbindResourceTypePostProcessor", cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE)
public class ConfigurablePostProcessor
        implements SlingPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(ConfigurablePostProcessor.class);
    Map<String, ResourceTypePostProcessor> resourceTypePostProcessorMap = new HashMap<String, ResourceTypePostProcessor>();

    @Override
    public void process(
            SlingHttpServletRequest slingHttpServletRequest,
            List<Modification> list) throws Exception {
        String requestResourceType = slingHttpServletRequest.getResource().getResourceType();
        if(resourceTypePostProcessorMap.containsKey(requestResourceType)) {
            resourceTypePostProcessorMap.get(requestResourceType).process(slingHttpServletRequest, list);
        }
    }

    public void bindResourceTypePostProcessor(ResourceTypePostProcessor resourceTypePostProcessor) {
        resourceTypePostProcessorMap.put(resourceTypePostProcessor.getResourceType(), resourceTypePostProcessor);
        log.info("Bounded post processor for resource type:" + resourceTypePostProcessor.getResourceType());
    }

    public void unbindResourceTypePostProcessor(ResourceTypePostProcessor resourceTypePostProcessor) {
        resourceTypePostProcessorMap.remove(resourceTypePostProcessor.getResourceType());
        log.info("Unbounded post processor for resource type:" + resourceTypePostProcessor.getResourceType());
    }

}
