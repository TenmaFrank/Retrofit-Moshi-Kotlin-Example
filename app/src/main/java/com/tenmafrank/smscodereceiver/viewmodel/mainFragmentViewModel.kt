package com.tenmafrank.smscodereceiver.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tenmafrank.smscodereceiver.model.CodeRequest
import com.tenmafrank.smscodereceiver.model.CodeResponse
import com.tenmafrank.smscodereceiver.model.TestGetResponse
import com.tenmafrank.smscodereceiver.model.singeUserResponse
import com.tenmafrank.smscodereceiver.network.RequestAPITest
import com.tenmafrank.smscodereceiver.network.RequestCodeApi
import com.tenmafrank.smscodereceiver.network.RequestSingleUserApi
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Body

enum class CodeApiStatus { LOADING, ERROR, DONE }

class mainFragmentViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<CodeApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<CodeApiStatus> = _status

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    /*init {
        getSMSCode("sms", "+52", "")
    }*/

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    fun getSMSCode( mail: String, pass: String) {
        viewModelScope.launch {
            _status.value = CodeApiStatus.LOADING
            val response: Response<CodeResponse> = try {
                 RequestCodeApi.requestSMSRetrofitService.getCode(CodeRequest(mail, pass))
            } catch (e: Exception) {
                return@launch
            }
            val body3 : CodeResponse = response.body()!!
            Log.v("response","${body3}")
        }
    }

    fun getSingleUser(id : String){
        viewModelScope.launch {
            val response : Response<singeUserResponse> = try {
                RequestSingleUserApi.requestSingleUserRetrofitService.getSingleUser(id)
            }catch (e: Exception){
                return@launch
            }
            val body3 : singeUserResponse = response.body()!!
            Log.v("response","${body3}")
        }
    }

    fun getAPITest(){
        viewModelScope.launch {
            val response : Response<TestGetResponse> = try {
                RequestAPITest.requestAPITestService.getTest()
            }catch (e: Exception){
                return@launch
            }
            val body3 : TestGetResponse = response.body()!!
            Log.v("response","${body3}")
        }
    }

}