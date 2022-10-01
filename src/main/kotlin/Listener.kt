import kotlinx.coroutines.flow.MutableSharedFlow
import java.net.DatagramPacket

class Listener {
    // public shared flow
    var events: MutableSharedFlow<DatagramPacket> = MutableSharedFlow<DatagramPacket>()
        private set // making it read-only

    suspend fun produceEvent(event: DatagramPacket) {
        events.emit(event) // suspends until all subscribers receive it
    }
}
