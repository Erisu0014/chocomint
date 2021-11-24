package erisu.cloud.rokishi.logic

import cn.hutool.http.HttpRequest
import com.alibaba.fastjson.JSON
import erisu.cloud.rokishi.pojo.SimpleChannelMessage
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Component

/**
 *@Description TODO
 *@Author alice
 *@Date 2021/11/24 16:03
 **/
@Component
class MessageHandler {
    fun sendGuildChannelMsg(message: SimpleChannelMessage) {
        HttpRequest.post("127.0.0.1:5700/send_guild_channel_msg")
            .timeout(2000)
            .body(Json.encodeToString(message))
            .execute().body()
    }
}