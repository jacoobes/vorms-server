import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt

class VormsAuth : CliktCommand() {
    val userName: String by option(help="Enter Username for vorms")
        .prompt("Username ")
    val password: String by option(help = "Enter password for vorms")
        .prompt(hideInput = true)
    override fun run() {
        val pubsub = Publisher();

        val server = UdpServer()
    }
}