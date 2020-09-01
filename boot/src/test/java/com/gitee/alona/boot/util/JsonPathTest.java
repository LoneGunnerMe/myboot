package com.gitee.alona.boot.util;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-28 15:16
 */
public class JsonPathTest {

    @Test
    public void test1(){
        String json = "{\n" +
                "    \"errNo\": \"0\",\n" +
                "    \"data\": {\n" +
                "        \"weather\": {\n" +
                "            \"setting\": {\n" +
                "                \"city\": \"青岛\"\n" +
                "            },\n" +
                "            \"content\": {\n" +
                "                \"week\": \"周二 07月28日\",\n" +
                "                \"city\": \"青岛\",\n" +
                "                \"today\": {\n" +
                "                    \"time\": \"周二 07月28日 (实时: 25℃)\",\n" +
                "                    \"date\": \"07月28日\",\n" +
                "                    \"img\": [\n" +
                "                        \"\",\n" +
                "                        \"\"\n" +
                "                    ],\n" +
                "                    \"condition\": \"晴\",\n" +
                "                    \"wind\": \"南风3-4级\",\n" +
                "                    \"temp\": \"25℃\",\n" +
                "                    \"link\": \"http://www.weather.com.cn/weather/101120201.shtml#7d\",\n" +
                "                    \"imgs\": {\n" +
                "                        \"0\": \"a0\",\n" +
                "                        \"1\": \"a0\"\n" +
                "                    },\n" +
                "                    \"pm25\": \"32\",\n" +
                "                    \"pollution\": \"0\",\n" +
                "                    \"pm25url\": \"//www.baidu.com/s?wd=%E9%9D%92%E5%B2%9B%E7%A9%BA%E6%B0%94%E8%B4%A8%E9%87%8F%E6%8C%87%E6%95%B0&tn=baidutop10&rsv_idx=2\"\n" +
                "                },\n" +
                "                \"tomorrow\": {\n" +
                "                    \"time\": \"周三\",\n" +
                "                    \"date\": \"07月29日\",\n" +
                "                    \"img\": [\n" +
                "                        \"\",\n" +
                "                        \"\"\n" +
                "                    ],\n" +
                "                    \"condition\": \"晴转阴\",\n" +
                "                    \"wind\": \"南风3-4级\",\n" +
                "                    \"temp\": \"23 ~ 27\",\n" +
                "                    \"link\": \"http://www.weather.com.cn/weather/101120201.shtml#7d\",\n" +
                "                    \"imgs\": {\n" +
                "                        \"0\": \"a0\",\n" +
                "                        \"1\": \"a0\"\n" +
                "                    },\n" +
                "                    \"pm25\": \"32\",\n" +
                "                    \"pollution\": \"0\",\n" +
                "                    \"pm25url\": \"//www.baidu.com/s?wd=%E9%9D%92%E5%B2%9B%E7%A9%BA%E6%B0%94%E8%B4%A8%E9%87%8F%E6%8C%87%E6%95%B0&tn=baidutop10&rsv_idx=2\"\n" +
                "                },\n" +
                "                \"thirdday\": {\n" +
                "                    \"time\": \"周四\",\n" +
                "                    \"date\": \"07月30日\",\n" +
                "                    \"img\": [\n" +
                "                        \"\",\n" +
                "                        \"\"\n" +
                "                    ],\n" +
                "                    \"condition\": \"小雨\",\n" +
                "                    \"wind\": \"南风3-4级\",\n" +
                "                    \"temp\": \"23 ~ 26\",\n" +
                "                    \"link\": \"http://www.weather.com.cn/weather/101120201.shtml#7d\",\n" +
                "                    \"imgs\": {\n" +
                "                        \"0\": \"a7\",\n" +
                "                        \"1\": \"a7\"\n" +
                "                    },\n" +
                "                    \"pm25\": \"//www.baidu.com/s?wd=%E9%9D%92%E5%B2%9B%E7%A9%BA%E6%B0%94%E8%B4%A8%E9%87%8F%E6%8C%87%E6%95%B0&tn=baidutop10&rsv_idx=2\",\n" +
                "                    \"pollution\": \"0\",\n" +
                "                    \"pm25url\": \"\"\n" +
                "                },\n" +
                "                \"fourthday\": {\n" +
                "                    \"time\": \"周五\",\n" +
                "                    \"date\": \"07月31日\",\n" +
                "                    \"img\": [\n" +
                "                        \"\",\n" +
                "                        \"\"\n" +
                "                    ],\n" +
                "                    \"condition\": \"小雨转中雨\",\n" +
                "                    \"wind\": \"南风3-4级\",\n" +
                "                    \"temp\": \"24 ~ 28\",\n" +
                "                    \"link\": \"http://www.weather.com.cn/weather/101120201.shtml#7d\",\n" +
                "                    \"imgs\": {\n" +
                "                        \"0\": \"a7\",\n" +
                "                        \"1\": \"a7\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"fifthday\": {\n" +
                "                    \"time\": \"周六\",\n" +
                "                    \"date\": \"08月01日\",\n" +
                "                    \"img\": [\n" +
                "                        \"\",\n" +
                "                        \"\"\n" +
                "                    ],\n" +
                "                    \"condition\": \"小雨转中雨\",\n" +
                "                    \"wind\": \"南风3-4级\",\n" +
                "                    \"temp\": \"24 ~ 28\",\n" +
                "                    \"link\": \"http://www.weather.com.cn/weather/101120201.shtml#7d\",\n" +
                "                    \"imgs\": {\n" +
                "                        \"0\": \"a7\",\n" +
                "                        \"1\": \"a7\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"linkseven\": \"http://www.weather.com.cn/weather/101120201.shtml#7d\",\n" +
                "                \"source\": {\n" +
                "                    \"name\": \"中国气象频道\",\n" +
                "                    \"url\": \"http://www.mywtv.cn/\"\n" +
                "                },\n" +
                "                \"cityname\": \"青岛\",\n" +
                "                \"calendar\": {\n" +
                "                    \"time\": \"1595920203469\",\n" +
                "                    \"lunar\": \"六月初八\",\n" +
                "                    \"festival\": false,\n" +
                "                    \"weatherSourceUrl\": \"http://www.weather.com.cn/weather/101120201.shtml#7d\"\n" +
                "                },\n" +
                "                \"currenttemp\": \"25℃\",\n" +
                "                \"pslink\": \"//www.baidu.com/s?tn=baidutop10&rsv_idx=2&wd=%E9%9D%92%E5%B2%9B%E5%A4%A9%E6%B0%94%E9%A2%84%E6%8A%A5\",\n" +
                "                \"weatherType\": \"aladdin\",\n" +
                "                \"isauto\": false,\n" +
                "                \"ipcity\": \"青岛\",\n" +
                "                \"province\": \"山东\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        Object read = JsonPath.read(json, "$.data.weather.setting.city");
        System.out.println(read);
    }
}
