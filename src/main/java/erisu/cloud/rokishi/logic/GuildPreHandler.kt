package erisu.cloud.rokishi.logic

import com.alibaba.fastjson.JSONObject
import erisu.cloud.rokishi.pojo.ChannelMessage
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Component

/**
 *@Description 频道消息预处理
 *@Author alice
 *@Date 2021/11/24 15:46
 **/
@OptIn(ExperimentalSerializationApi::class)
@Component
class GuildPreHandler {
    fun isGuildMessage(messageResponse: String): Boolean {
        val res = JSONObject.parseObject(messageResponse)
        val messageType = res.getString("message_type")
        return messageType == "guild"
    }

    fun buildGuildMessage(messageResponse: String): ChannelMessage {
        return JSONObject.parseObject(messageResponse, ChannelMessage::class.java)
    }
}