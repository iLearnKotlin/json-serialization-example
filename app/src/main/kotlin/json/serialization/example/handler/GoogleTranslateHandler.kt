package json.serialization.example.handler

import json.serialization.example.model.google.GoogleTranslateTextResponse
import json.serialization.example.model.google.TranslationLang
import org.apache.hc.core5.net.URIBuilder
import java.io.IOException
import java.net.URISyntaxException
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.function.Supplier

class GoogleTranslateHandler private constructor() {
    private val endPoint = "https://translation.googleapis.com/language/translate/v2"
    private val apiKey = "AIzaSyDzcQV6Xi6h8H4dpXYnqmfoCYhHUo9xdaY"
    private val httpClientBuilder: HttpClient.Builder
        get() {
            return HttpClient.newBuilder()
        }

    @Throws(URISyntaxException::class, IOException::class, InterruptedException::class)
    fun translate(q: String?, source: TranslationLang, target: TranslationLang): String {
        val uriBuilder: URIBuilder = URIBuilder(endPoint)
            .addParameter("q", q)
            .addParameter("source", source.name)
            .addParameter("target", target.name)
            .addParameter("format", "text")
            .addParameter("key", apiKey)
        val request = HttpRequest.newBuilder()
            .uri(uriBuilder.build())
            .version(HttpClient.Version.HTTP_2).GET()
            .header("Accept", "application/json").build()
        val response: HttpResponse<Supplier<GoogleTranslateTextResponse>> = httpClientBuilder.build().send(
            request, JsonBodyHandler(
                GoogleTranslateTextResponse::class.java
            )
        ) ?: throw IOException("HttpClient is null")
        val body: GoogleTranslateTextResponse = response.body().get()
        return body.data?.translations?.get(0)?.translatedText ?: ""
    }

    private object Holder { val INSTANCE = GoogleTranslateHandler() }

    companion object {
        @JvmStatic
        fun getInstance(): GoogleTranslateHandler {
            return Holder.INSTANCE
        }
    }
}

