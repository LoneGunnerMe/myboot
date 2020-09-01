package com.gitee.alona.boot.manager.api;

import com.gitee.alona.boot.web.rest.response.Result;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import org.springframework.stereotype.Service;
import retrofit2.http.GET;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-28 14:57
 */
@Service
@RetrofitClient(baseUrl = "http://www.baidu.com")
public interface BaiduApi {

    @GET("/home/other/data/weatherInfo?city=%E9%9D%92%E5%B2%9B")
    Result<String> weather();
}
