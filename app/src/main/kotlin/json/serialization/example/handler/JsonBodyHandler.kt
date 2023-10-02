package json.serialization.example.handler

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException
import java.io.InputStream
import java.io.UncheckedIOException
import java.net.http.HttpResponse
import java.util.function.Function
import java.util.function.Supplier


class JsonBodyHandler<W>(private val wClass: Class<W>) : HttpResponse.BodyHandler<Supplier<W>> {
    override fun apply(responseInfo: HttpResponse.ResponseInfo?): HttpResponse.BodySubscriber<Supplier<W>> {
        return asJSON(wClass)
    }

}
fun <W> asJSON(targetType: Class<W>?): HttpResponse.BodySubscriber<Supplier<W>> {
    val upstream = HttpResponse.BodySubscribers.ofInputStream()
    return HttpResponse.BodySubscribers.mapping<InputStream, Supplier<W>>(upstream,
        Function<InputStream, Supplier<W>> { inputStream: InputStream ->
            toSupplierOfType(
                inputStream,
                targetType
            )
        })
}
fun <W> toSupplierOfType(inputStream: InputStream, targetType: Class<W>?): Supplier<W> {
    return Supplier {
        try {
            inputStream.use { stream ->
                val objectMapper =
                    ObjectMapper()
                return@Supplier objectMapper.readValue<W>(stream, targetType)
            }
        } catch (e: IOException) {
            throw UncheckedIOException(e)
        }
    }
}