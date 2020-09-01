package com.gitee.alona.boot.manager.api;

import com.dtflys.forest.annotation.DataParam;
import com.dtflys.forest.annotation.Request;

import java.util.Map;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-27 9:14
 */
public interface MyClient {
    /**
     * 简单的请求百毒
     *
     * @return
     */
    @Request(url = "http://baidu.com")
    String simpleRequest();

    /**
     * 经纬度信息
     *
     * @param longitude
     * @param latitude
     * @return
     */
    @Request(
            url = "http://ditu.amap.com/service/regeo",
            dataType = "json"
    )
    Map getLocation(@DataParam("longitude") String longitude, @DataParam("latitude") String latitude);

}