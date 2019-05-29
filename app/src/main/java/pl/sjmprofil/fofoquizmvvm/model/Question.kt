package pl.sjmprofil.fofoquizmvvm.model

import com.google.gson.annotations.SerializedName

data class Question<T>(

    @SerializedName("value")
    val questionValue: T
)