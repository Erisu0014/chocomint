package erisu.cloud.rokishi.logic

import erisu.cloud.rokishi.pojo.ChannelMessage
import erisu.cloud.rokishi.pojo.SimpleChannelMessage
import org.springframework.stereotype.Component
import javax.annotation.Resource

/**
 *@Description hello world
 *@Author alice
 *@Date 2021/11/24 16:12
 **/
@Component
class HelloLogic {
    @Resource
    private lateinit var messageHandler: MessageHandler
    fun hello(channelMessage: ChannelMessage) {
        if (channelMessage.message == "test") {
            val message = SimpleChannelMessage(
                channelMessage.guild_id,
                channelMessage.channel_id,
                "hello world"
            )
            messageHandler.sendGuildChannelMsg(message)
        }
    }
}