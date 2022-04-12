import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtil {

    public static String httpPost(String jsonStr, String path) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(path);
        try {
            StringEntity stringEntity = new StringEntity(jsonStr, "application/json", "utf-8");
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String httpGet(String url) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if (code == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
