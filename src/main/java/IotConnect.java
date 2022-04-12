public class IotConnect {

    private static final String URL_ADDRESS = "http://47.94.163.75:8080/iot-hst";

    // /N2MjzRBSyeMMQEnb/BAYenxJcfQMNY4MCWHSYEjN6/218.108.98.98/10720/CMS-CA-80765
    public static void setConfig(String clientId, String secretKey, String serverHost, String serverPort,
                                 String deviceName) {
        String result = HttpUtil.httpPost("{}", URL_ADDRESS + "/config/" + clientId + "/" + secretKey + "/"
                + serverHost + "/" + serverPort + "/" + deviceName);
        System.out.println(result);
    }

    public static void a001() {
        String result = HttpUtil.httpGet(URL_ADDRESS + "/A001");
        System.out.println(result);
    }

    public static void a002() {
        String result = HttpUtil.httpGet(URL_ADDRESS + "/A002");
        System.out.println(result);
    }

    public static void a003() {
        String result = HttpUtil.httpGet(URL_ADDRESS + "/A003");
        System.out.println(result);
    }

    public static void b001(String str) {
        String jsonStr = "{\"data\":{\"items\":[{\"transition\":1,\"delay\":500,\"param\":0,\"imgCode\":\"\",\"str\"" +
                ":\"" + str + "\",\"color\":\"red\",\"fonttype\":\"s\",\"fontsize\":24,\"charSpacing\": 10}]}}";
        String result = HttpUtil.httpPost(jsonStr, URL_ADDRESS + "/B001");
        System.out.println(result);
    }

    public static void b002(Integer method, Integer light) {
        String jsonStr = "{\"data\": {\"method\":" + method + ",\"light\":" + light + "}}";
        String result = HttpUtil.httpPost(jsonStr, URL_ADDRESS + "/B002");
        System.out.println(result);
    }
}
