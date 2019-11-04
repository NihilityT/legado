package io.legado.app.constant

import android.annotation.SuppressLint
import io.legado.app.App
import io.legado.app.R
import io.legado.app.data.entities.BookGroup
import io.legado.app.utils.getPrefBoolean
import io.legado.app.utils.putPrefBoolean
import java.text.SimpleDateFormat
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

@SuppressLint("SimpleDateFormat")
object AppConst {

    const val APP_TAG = "Legado"

    const val channelIdDownload = "channel_download"
    const val channelIdReadAloud = "channel_read_aloud"
    const val channelIdWeb = "channel_web"

    const val UA_NAME = "User-Agent"

    val userAgent: String by lazy {
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36"
    }

    val SCRIPT_ENGINE: ScriptEngine by lazy {
        ScriptEngineManager().getEngineByName("rhino")
    }

    val TIME_FORMAT: SimpleDateFormat by lazy {
        SimpleDateFormat("HH:mm")
    }

    val keyboardToolChars: List<String> by lazy {
        arrayListOf(
            "@", "&", "|", "%", "/", ":", "[", "]", "{", "}", "<", ">", "\\", "$", "#", "!", ".",
            "href", "src", "textNodes", "xpath", "json", "css", "id", "class", "tag"
        )
    }

    val bookGroupAll = BookGroup(-1, App.INSTANCE.getString(R.string.all))
    val bookGroupLocal = BookGroup(-2, App.INSTANCE.getString(R.string.local))
    val bookGroupAudio = BookGroup(-3, App.INSTANCE.getString(R.string.audio))

    var bookGroupLocalShow: Boolean
        get() = App.INSTANCE.getPrefBoolean("bookGroupLocal", false)
        set(value) {
            App.INSTANCE.putPrefBoolean("bookGroupLocal", value)
        }

    var bookGroupAudioShow: Boolean
        get() = App.INSTANCE.getPrefBoolean("bookGroupAudio", false)
        set(value) {
            App.INSTANCE.putPrefBoolean("bookGroupAudio", value)
        }
}