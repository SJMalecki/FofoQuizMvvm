package pl.sjmprofil.fofoquizmvvm.repository

import pl.sjmprofil.fofoquizmvvm.model.QuestionValue
import pl.sjmprofil.fofoquizmvvm.net.RestService
import pl.sjmprofil.fofoquizmvvm.net.Result

class MyRepository(private val restService: RestService) {

    suspend fun getJokes(): Result<List<QuestionValue>> = restService.getJokes()
}