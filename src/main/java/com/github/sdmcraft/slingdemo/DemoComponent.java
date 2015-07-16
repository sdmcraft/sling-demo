package com.github.sdmcraft.slingdemo;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;

@Component(immediate = true)
public class DemoComponent {

    @Reference
    private DemoService2 demoService2;

    @Reference
    private DemoService2 demoService2a;

    @Reference
    private DemoService demoService;

}
