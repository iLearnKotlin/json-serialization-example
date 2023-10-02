package json.serialization.example.model.usda

import kotlinx.serialization.Serializable

@Serializable
data class InputFood(
    val id: Long,
    val portionCode: String,
    val foodDescription: String,
    val sequenceNumber: Long,
    val ingredientDescription: String,
    val ingredientWeight: Double,
    val amount: Double,
    val ingredientCode: Long,
)
