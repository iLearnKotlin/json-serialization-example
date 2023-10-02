package json.serialization.example.model.nutrilife

import kotlinx.serialization.Required
import kotlinx.serialization.Serializable

@Serializable
class NutriLifeNutrient(
    val id: Long?,
    val name: String,
    val desc: String?,
    val unit: String,
    val value: Double,
) {
    @Serializable
    data class NutrientDictionary(
        @Required val id: Long? = null,
        @Required val vi: String,
        @Required val nuti: String,
        @Required val usda: String,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as NutrientDictionary

            if (id != other.id) return false
            if (vi != other.vi) return false
            if (nuti != other.nuti) return false
            if (usda != other.usda) return false

            return true
        }

        override fun hashCode(): Int {
            var result = id.hashCode()
            result = 31 * result + vi.hashCode()
            result = 31 * result + nuti.hashCode()
            result = 31 * result + usda.hashCode()
            return result
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NutriLifeNutrient

        if (id != other.id) return false
        if (name != other.name) return false
        if (desc != other.desc) return false
        if (unit != other.unit) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + (desc?.hashCode() ?: 0)
        result = 31 * result + unit.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }

    override fun toString(): String {
        return "NutriLifeNutrient(id=$id, name='$name', desc=$desc, unit='$unit', value=$value)"
    }

}