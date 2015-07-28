package com.github.sdmcraft.slingdemo.child;

import com.github.sdmcraft.slingdemo.api.DemoServiceFactoryService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;

@Component(immediate = true)
public class ChildDemoComponent {

    @Reference
    private DemoServiceFactoryService demoServiceFactoryService;

}
