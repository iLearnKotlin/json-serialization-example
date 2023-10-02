package json.serialization.example.model.usda

import kotlinx.serialization.Serializable

@Serializable
data class Nutrient(
    val id: Long,
    val number: String,
    val name: String,
    val rank: Long,
    val unitName: String,
)
