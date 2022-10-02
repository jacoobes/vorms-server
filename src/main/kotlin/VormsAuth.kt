import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import java.net.Inet4Address

class VormsAuth : CliktCommand() {
    val userName: String by option(help = "Enter Username for vorms")
        .prompt("Username")
    val password: String by option(help = "Enter password for vorms")
        .prompt(hideInput = true)
    val hostname: String by option(help = "The host of your server")
        .prompt("Hostname")
    override fun run() {
        val addr = Inet4Address.getAllByName(hostname)
        println("Now on " + addr[0])
        val port = 8080
        UdpServer(port).run()
        val client = UDPClient(hostname, port)
        client.send("pooba")
    }
}