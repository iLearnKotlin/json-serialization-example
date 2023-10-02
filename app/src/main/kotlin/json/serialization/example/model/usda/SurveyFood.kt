package json.serialization.example.model.usda

import kotlinx.serialization.Serializable

@Serializable
data class SurveyFood(
    val foodClass: String? = null,
    val description: String,
    val foodNutrients: List<FoodNutrient>,
    val foodAttributes: List<FoodAttribute>,
    val foodPortions: List<FoodPortion>,
    val publicationDate: String,
    val inputFoods: List<InputFood>,
    val fdcId: Long,
    val dataType: String,
)
