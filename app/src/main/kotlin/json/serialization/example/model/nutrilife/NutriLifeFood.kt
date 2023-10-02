package json.serialization.example.model.nutrilife

import kotlinx.serialization.Required
import kotlinx.serialization.Serializable

@Serializable
data class NutriLifeFood(
    @Required val id: Long? = null,
    @Required val refId: Long? = null,
    @Required val name: String = "undefined",
    @Required val en: String = "undefined",
    @Required val unit: String = "g",
    @Required val value: Double = 100.00,
    @Required val calories: Double? = null,
    @Required val carbs: Double? = null,
    @Required val protein: Double? = null,
    @Required val fat: Double? = null,
    @Required val image: String = "unknown",
    @Required val verified: Boolean = false,
    @Required var nutrients: List<NutriLifeNutrient> = emptyList(),
    @Required val foodCategory: String = "uncategorized",
)
