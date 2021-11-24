package erisu.cloud.rokishi.handler

import erisu.cloud.rokishi.logic.GuildPreHandler
import erisu.cloud.rokishi.logic.HelloLogic
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import java.util.logging.Logger
import javax.annotation.Resource

/**
 * @Description wshandler
 * @Author alice
 * @Date 2021/11/24 14:46
 */
@Slf4j
class WsHandler : WebSocketHandler {
    companion object {
        val Log = Logger.getLogger(WsHandler::class.java.name)
    }

    @Resource
    private lateinit var guildPreHandler: GuildPreHandler

    @Resource
    private lateinit var helloLogic: HelloLogic

    @Value("\${botId}")
    private var botId: ULong = 0U

    @Throws(Exception::class)
    override fun afterConnectionEstablished(session: WebSocketSession) {
    }

    @Throws(Exception::class)
    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        val rawMessage = message.payload.toString()
        if (guildPreHandler.isGuildMessage(rawMessage)) {
            val channelMessage = guildPreHandler.buildGuildMessage(rawMessage)
            // 不自我回复
            if (channelMessage.sender.user_id != botId) {
                helloLogic.hello(channelMessage)
            }
        }
        Log.info(rawMessage)
    }

    @Throws(Exception::class)
    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
    }

    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, closeStatus: CloseStatus) {
    }

    override fun supportsPartialMessages(): Boolean {
        return false
    }
}