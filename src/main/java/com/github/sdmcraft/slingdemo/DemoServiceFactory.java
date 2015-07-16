package com.github.sdmcraft.slingdemo;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(metatype = true)
@Service(serviceFactory = true)
public class DemoServiceFactory implements DemoService2 {

    private static final Logger log = LoggerFactory.getLogger(DemoServiceFactory.class);

    static int instances = 0;
    final int instanceId;

    @Property
    private static final String DEMO_PROP = "demo.prop";

    public DemoServiceFactory() {
        instances++;
        instanceId = instances;
        log.info("DemoServiceFactory Instance count:" + instances);
    }

    @Activate
    public void activate(ComponentContext ctx) {
        log.info("DemoServiceFactory Prop value:" + ctx.getProperties().get(DEMO_PROP));
    }

    @Override
    public String demo() {
        return null;
    }
}
