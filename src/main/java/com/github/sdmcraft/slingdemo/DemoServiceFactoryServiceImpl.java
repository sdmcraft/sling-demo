package com.github.sdmcraft.slingdemo;

import com.github.sdmcraft.slingdemo.api.DemoServiceFactoryService;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(metatype = true)
@Service(serviceFactory = true)
public class DemoServiceFactoryServiceImpl implements DemoServiceFactoryService {

    private static final Logger log = LoggerFactory.getLogger(DemoServiceFactoryServiceImpl.class);

    static int instances = 0;
    private String instanceVal;


    @Property
    private static final String DEMO_PROP = "demo.prop";

    public DemoServiceFactoryServiceImpl() {
        instances++;
    }

    @Activate
    public void activate(ComponentContext ctx) {
        log.info("Instance count:" + instances);
        log.info("Prop value:" + ctx.getProperties().get(DEMO_PROP));
        log.info("Instance value:" + this.instanceVal);
        log.info("This instance is being used by:" + ctx.getUsingBundle().getSymbolicName());
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
