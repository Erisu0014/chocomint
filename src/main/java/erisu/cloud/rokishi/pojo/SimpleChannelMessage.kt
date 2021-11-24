package erisu.cloud.rokishi.pojo

import kotlinx.serialization.Serializable

@Serializable
data class SimpleChannelMessage(
    val guild_id: ULong,
    val channel_id: ULong,
    val message: String
)
