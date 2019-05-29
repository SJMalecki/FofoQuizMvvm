package pl.sjmprofil.fofoquizmvvm.model

import com.google.gson.annotations.SerializedName

data class QuestionValue(
    val id: String,
    val question: String,
    val ansA: String,
    val ansB: String,
    val ansC: String,
    val ansD: String,
    val rightAns: String,

    @SerializedName("picture_name")
    val pictureName: String
)