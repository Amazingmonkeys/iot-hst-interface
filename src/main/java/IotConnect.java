public class IotConnect {

    private static final String URL_ADDRESS = "http://47.94.163.75:8080/iot-hst";

    // /N2MjzRBSyeMMQEnb/BAYenxJcfQMNY4MCWHSYEjN6/218.108.98.98/10720/CMS-CA-80765

    /**
     * 配置5个变量
     */
    public static void setConfig(String clientId, String secretKey, String serverHost, String serverPort,
                                 String deviceName) {
        String result = HttpUtil.httpPost("{}", URL_ADDRESS + "/config/" + clientId + "/" + secretKey + "/"
                + serverHost + "/" + serverPort + "/" + deviceName);
        System.out.println(result);
    }

    /**
     * 获取当前显示内容
     *
     * @return result
     */
    public static String a001() {
        return HttpUtil.httpGet(URL_ADDRESS + "/A001");
    }

    /**
     * 获取亮度和调节方式
     *
     * @return result
     */
    public static String a002() {
        return HttpUtil.httpGet(URL_ADDRESS + "/A002");
    }

    /**
     * 下载节目列表
     *
     * @return result
     */
    public static String a003() {
        return HttpUtil.httpGet(URL_ADDRESS + "/A003");
    }

    /**
     * 设置显示内容
     *
     * @param str: 显示内容
     * @return {"result":["ok"],"status":200,"code":"success"}
     */
    public static String b001(String str) {
        String jsonStr = "{\"data\":{\"items\":[{\"transition\":1,\"delay\":500,\"param\":0,\"imgCode\":\"\",\"str\"" +
                ":\"" + str + "\",\"color\":\"red\",\"fonttype\":\"s\",\"fontsize\":24,\"charSpacing\": 10}]}}";
        return HttpUtil.httpPost(jsonStr, URL_ADDRESS + "/B001");
    }

    /**
     * 设置亮度和调节方式
     *
     * @param method: 调节方式
     * @param light:  亮度
     * @return {"result":["ok"],"status":200,"code":"success"}
     */
    public static String b002(Integer method, Integer light) {
        String jsonStr = "{\"data\": {\"method\":" + method + ",\"light\":" + light + "}}";
        return HttpUtil.httpPost(jsonStr, URL_ADDRESS + "/B002");
    }
}
