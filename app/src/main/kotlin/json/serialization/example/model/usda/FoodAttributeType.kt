package json.serialization.example.model.usda

import kotlinx.serialization.Serializable

@Serializable
data class FoodAttributeType(
    val id: Long,
    val name: String,
    val description: String,
)
