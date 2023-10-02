package vn.nutrilife.tool.food.data.converter.model.nutrilife

import kotlinx.serialization.Required
import kotlinx.serialization.Serializable

@Serializable
data class NutriLifeFoodPortion(
    @Required val amount: Double,
    @Required val name: String,
    @Required val modifier: String?,
    @Required val value: Double,
)