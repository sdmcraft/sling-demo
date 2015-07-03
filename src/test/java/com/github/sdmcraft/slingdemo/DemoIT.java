package com.github.sdmcraft.slingdemo;

import org.apache.sling.testing.tools.sling.SlingClient;
import org.apache.sling.testing.tools.sling.SlingTestBase;
import org.junit.Test;

/**
 * Created by satyadeep on 7/3/15.
 */
public class DemoIT extends SlingTestBase {



    @Test
    public void test() {
        SlingClient slingClient = new SlingClient(this.getServerBaseUrl(), this.getServerUsername(), this.getServerPassword());
    }
}
