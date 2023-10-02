package json.serialization.example.model.google

import kotlinx.serialization.Serializable
import java.util.*
@Serializable
class Dictionary (var key: String, var en: String, var vi: String){
    override fun hashCode(): Int {
        return Objects.hash(en, key, vi)
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Dictionary
        return Objects.equals(en, other.en) && Objects.equals(key, other.key) && Objects.equals(vi, other.vi)
    }
}


