import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import kotlin.coroutines.CoroutineContext

class UDPClient(val host: String, val port : Int, publisher: Listener) : CoroutineScope, Subscriber<String> {
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.IO
    private val datagramSocket = DatagramSocket()
    private val addr = InetAddress.getByName(host)
    override fun send(data: String) {
        val bytes = data.toByteArray()
        val packet = DatagramPacket(data.toByteArray(), bytes.size, addr, port)
        datagramSocket.send(packet)
    }

    override fun recieve(packet: DatagramPacket) {

    }

}