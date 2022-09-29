import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class UDPClient : CoroutineScope {
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.IO
}