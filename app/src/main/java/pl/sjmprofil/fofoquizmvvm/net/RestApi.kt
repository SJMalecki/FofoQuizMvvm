package pl.sjmprofil.fofoquizmvvm.net

import kotlinx.coroutines.Deferred
import pl.sjmprofil.fofoquizmvvm.model.Question
import pl.sjmprofil.fofoquizmvvm.model.QuestionValue
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {

    @GET("/json.pl")
    fun getQuestion() : Deferred<Response<Question<List<QuestionValue>>>>
}