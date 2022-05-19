package com.hussain.fluttercommitlist.api

import com.hussain.fluttercommitlist.model.authorReposModel.AuthorInfoModel
import com.hussain.fluttercommitlist.model.commitListModel.CommitModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ServiceInterface {
    @GET("commits")
    fun getCommitList(): Call<CommitModel>

    @GET
    fun getAuthorReposList(@Url loginUrl:  String): Call<AuthorInfoModel>
}