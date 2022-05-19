package com.hussain.fluttercommitlist.model.authorReposModel


import com.google.gson.annotations.SerializedName

data class AuthorInfoModel(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("blog")
    val blog: String,
    @SerializedName("email")
    val email: Any,
    @SerializedName("hireable")
    val hireable: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("public_gists")
    val publicGists: Int,
    @SerializedName("public_repos")
    val publicRepos: Int
)