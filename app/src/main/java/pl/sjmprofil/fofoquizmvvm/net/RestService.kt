package pl.sjmprofil.fofoquizmvvm.net

import pl.sjmprofil.fofoquizmvvm.model.QuestionValue
import retrofit2.Response
import java.lang.Exception

open class BaseService {

    suspend fun <T : Any> callApi(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call.invoke()

            //HTTP OK
            if (response.isSuccessful) {
                return Result.Success(response.body() as T)

                //HTTP Error
            } else {
                return Result.Error(response.errorBody().toString())
            }

            //Network Exception
        } catch (e: Exception) {
            return Result.Exception(e)
        }
    }

}

class RestService(private val restApi: RestApi) : BaseService() {

    suspend fun getJokes(): Result<List<QuestionValue>> {
        val result = callApi {
            restApi.getQuestion().await()
        }

        if(result is Result.Success) {
            return Result.Success(result.data.questionValue)
        }else{
            return  result as Result<List<QuestionValue>>
        }
    }
}