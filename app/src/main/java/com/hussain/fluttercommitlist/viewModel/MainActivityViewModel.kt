package com.hussain.fluttercommitlist.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hussain.fluttercommitlist.api.ApiInstance.Companion.getApiInstance
import com.hussain.fluttercommitlist.api.ServiceInterface
import com.hussain.fluttercommitlist.model.commitListModel.CommitModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    var liveDataList: MutableLiveData<CommitModel> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<CommitModel>{
        return liveDataList
    }

    fun makeApiCall(baseUrl: String){
        val apiInstance = getApiInstance(baseUrl)
        val apiService = apiInstance.create(ServiceInterface::class.java)

        val call = apiService.getCommitList()

        call.enqueue(object : Callback<CommitModel>{
            override fun onResponse(
                call: Call<CommitModel>,
                response: Response<CommitModel>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<CommitModel>, t: Throwable) {
                Log.d("aaaaaaaaa", t.message.toString())
                liveDataList.postValue(null)
            }

        })
    }
}