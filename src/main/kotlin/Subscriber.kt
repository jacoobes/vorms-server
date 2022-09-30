import java.net.DatagramPacket

interface Subscriber<T> {
    fun send(data: T)
    fun recieve(packet : DatagramPacket)
}