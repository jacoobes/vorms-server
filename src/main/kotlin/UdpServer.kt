import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.net.DatagramSocket
import kotlin.coroutines.CoroutineContext

class UdpServer(
    private val port: Int = 8080,
) : CoroutineScope, Runnable {
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.IO
    val datagramSocket = DatagramSocket(port)
    var running = true


    override fun run() {
        while (running) {

        }
    }
}
