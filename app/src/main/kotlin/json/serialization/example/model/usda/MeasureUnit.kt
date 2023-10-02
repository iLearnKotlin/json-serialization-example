package json.serialization.example.model.usda

import kotlinx.serialization.Serializable

@Serializable
data class MeasureUnit(
    val id: Long,
    val name: String,
    val abbreviation: String,
)
