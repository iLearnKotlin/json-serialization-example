package json.serialization.example.model.usda

import json.serialization.example.model.usda.Nutrient
import kotlinx.serialization.Serializable

@Serializable
data class FoodNutrient(
    val type: String,
    val id: Long,
    val nutrient: Nutrient,
    val amount: Double,
)
