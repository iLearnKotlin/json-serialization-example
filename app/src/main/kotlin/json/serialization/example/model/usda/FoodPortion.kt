package json.serialization.example.model.usda

import json.serialization.example.model.usda.MeasureUnit
import kotlinx.serialization.Serializable

@Serializable
data class FoodPortion(
    val id: Long,
    val measureUnit: MeasureUnit,
    val modifier: String,
    val gramWeight: Double,
    val sequenceNumber: Long,
    val portionDescription: String,
)
