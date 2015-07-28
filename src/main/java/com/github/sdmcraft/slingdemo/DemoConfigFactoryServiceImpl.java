package com.github.sdmcraft.slingdemo;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;

@Component(configurationFactory = true, metatype = true)
@Service
public class DemoConfigFactoryServiceImpl implements DemoConfigFactoryService {

    private static final Logger log = LoggerFactory.getLogger(DemoConfigFactoryServiceImpl.class);

    static int instances = 0;
    private String instanceVal;


    @Property
    private static final String DEMO_PROP = "demo.prop";

    public DemoConfigFactoryServiceImpl() {
        instances++;
    }

    @Activate
    public void activate(ComponentContext ctx) {
        log.info("Instance count:" + instances);
        log.info("Prop value:" + ctx.getProperties().get(DEMO_PROP));
        log.info("Instance value:" + this.instanceVal);
    }

    @Override
    public void setVal(String val) {
        this.instanceVal = val;
    }

    @Override
    public String getVal() {
        return this.instanceVal;
    }
}
