package json.serialization.example.model.usda

import json.serialization.example.model.usda.FoodAttributeType
import kotlinx.serialization.Serializable

@Serializable
data class FoodAttribute(
    val id: Long,
    val name: String? = null,
    val value: String,
    val foodAttributeType: FoodAttributeType,
)
