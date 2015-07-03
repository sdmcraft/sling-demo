package com.github.sdmcraft.slingdemo;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.jackrabbit.commons.json.JsonParser;
import org.apache.jackrabbit.commons.json.JsonUtil;
import org.apache.sling.commons.testing.integration.HttpTestBase;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by satyadeep on 7/3/15.
 */
public class DemoClientSideTest extends HttpTestBase {

    @Test
    public void test() {
        Map<String, String> map = new HashMap<String, String>();
        try {
            int response = testClient.get(HttpTestBase.HTTP_BASE_URL + "/content/client-test.json");
            if(response == HttpServletResponse.SC_OK) {
                testClient.delete(HttpTestBase.HTTP_BASE_URL + "/content/client-test");
            }
            map.put("jcr:primaryType", "nt:unstructured");
            String randomValue = Double.toString(Math.random() * 1000);
            map.put("prop", randomValue);
            testClient.createNode(HttpTestBase.HTTP_BASE_URL + "/content/client-test", map);

            JSONObject resp = get(HttpTestBase.HTTP_BASE_URL + "/content/client-test.json");
            Assert.assertEquals(randomValue, resp.getString("prop"));

        } catch (IOException e) {
            Assert.fail();
        }
    }

    private JSONObject get(String url) throws HttpException, IOException {
        final GetMethod get = new GetMethod(url);
        get.getParams().setContentCharset("UTF-8");
        httpClient.executeMethod(get);
        String response = get.getResponseBodyAsString();
        JSONObject jsonObject = new JSONObject(response);
        return jsonObject;
    }

}
