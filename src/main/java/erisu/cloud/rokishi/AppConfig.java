package erisu.cloud.rokishi;

import erisu.cloud.rokishi.handler.WsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Description websocket config
 * @Author alice
 * @Date 2021/11/24 14:45
 **/
@Configuration
@EnableWebSocket
public class AppConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(wsHandler(), "cqhttp/rokishi");
    }

    @Bean
    public WebSocketHandler wsHandler() {
        return new WsHandler();
    }

}
