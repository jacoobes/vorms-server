import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.net.DatagramPacket
import java.net.DatagramSocket

class Listener {
    private val _events = MutableSharedFlow<DatagramPacket>() // private mutable shared flow
    val events = _events.asSharedFlow() // publicly exposed as read-only shared flow

    suspend fun produceEvent(event: DatagramPacket) {
        _events.emit(event) // suspends until all subscribers receive it
    }
}