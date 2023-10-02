package json.serialization.example.model.usda

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(@SerialName("SurveyFoods") val surveyFoods: List<SurveyFood>)
