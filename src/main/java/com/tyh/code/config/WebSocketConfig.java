package com.tyh.code.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by tyh
 * 2017-07-30 23:17
 */
@Component
public class WebSocketConfig {

    //  todo 这里不注释掉 单元测试就会报错 应该是发生冲突了 暂未解决此问题
    //@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
