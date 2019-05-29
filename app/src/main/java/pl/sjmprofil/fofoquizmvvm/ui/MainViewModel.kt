package pl.sjmprofil.fofoquizmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.sjmprofil.fofoquizmvvm.model.QuestionValue
import pl.sjmprofil.fofoquizmvvm.repository.MyRepository
import pl.sjmprofil.fofoquizmvvm.net.Result

class MainViewModel(private val repository: MyRepository) : ViewModel() {

    private val question: MutableLiveData<Result<List<QuestionValue>>> by lazy {
        MutableLiveData<Result<List<QuestionValue>>>().also { getQuestion() }
    }

    fun getJokes(): LiveData<Result<List<QuestionValue>>> {
        return question
    }

    fun getQuestion() = viewModelScope.launch {

        question.value = Result.Loading()

        val response = repository.getJokes()

        withContext(Dispatchers.Main) {
            question.value = response
        }
    }

}