package com.dave.materialdesignsample.utilities;

import org.apache.http.params.HttpParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by osingh on 20-Jan-17.
 */
public class HttpUtilities {

    public static String execDynamicRequest(String url, Map<String, String> paramsMap) throws Exception {

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        HttpParams params = httpClient.getParams();
        List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
        Set keySet = paramsMap.keySet();
        Iterator itr = keySet.iterator();
        String content = "";
        try {
            while (itr.hasNext()) {
                String key = itr.next().toString();
                String value = String.valueOf(paramsMap.get(key));
                nameValuePairs.add(new BasicNameValuePair(key, value));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity respEntity = response.getEntity();

            if (respEntity != null) {
                content = EntityUtils.toString(respEntity);
                return content;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
