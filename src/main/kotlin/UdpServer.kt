import kotlinx.coroutines.*
import java.net.DatagramPacket
import java.net.DatagramSocket
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

class UdpServer(
    port: Int = 8080,
) : CoroutineScope, Subscriber<String>, java.lang.Runnable {
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.IO
    private val datagramSocket = DatagramSocket(port)
    private var running = true

    override fun send(data: String) {
        launch {

        }
    }

    override fun receive(packet: DatagramPacket) {
        datagramSocket.receive(packet)
        println(String(packet.data, 0, packet.length))
    }

    override fun run() {
        val buffer = ByteArray(2048)
        thread {
            while(running) {
                val packet = DatagramPacket(buffer,buffer.size)
                receive(packet)
            }
        }
    }
}