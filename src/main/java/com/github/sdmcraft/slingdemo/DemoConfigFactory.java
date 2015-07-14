package com.github.sdmcraft.slingdemo;

import com.github.sdmcraft.slingdemo.DemoService;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;

@Component(configurationFactory = true, metatype = true, immediate = true)
@Service
public class DemoConfigFactory implements DemoService {

    private static final Logger log = LoggerFactory.getLogger(DemoConfigFactory.class);

    static int instances = 0;
    final int instanceId;

    @Property
    private static final String DEMO_PROP = "demo.prop";

    public DemoConfigFactory() {
        instances++;
        instanceId = instances;
    }

    @Activate
    public void activate(ComponentContext ctx) {
        log.info("Instance count:" + instances);
        log.info("Prop value:" + ctx.getProperties().get(DEMO_PROP));
    }

    @Override
    public String demo() {
        return null;
    }
}
