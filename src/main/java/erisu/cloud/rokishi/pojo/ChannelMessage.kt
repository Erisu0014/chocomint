package erisu.cloud.rokishi.pojo

import kotlinx.serialization.Serializable

@Serializable
data class ChannelMessage(
    val post_type: String,
    val message_type: String,
    val sub_type: String,
    val guild_id: ULong,
    val channel_id: ULong,
    val user_id: ULong,
    val message_id: String,
    val sender: Sender,
    val message: String,
    val time: String? = null
) {
    @Serializable
    data class Sender(
        val nickname: String,
        val user_id: ULong
    )
}
