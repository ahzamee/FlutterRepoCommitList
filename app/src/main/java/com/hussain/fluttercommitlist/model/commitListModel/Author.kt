package com.hussain.fluttercommitlist.model.commitListModel

data class Author(
    val avatar_url: String,
    val gists_url: String,
    val id: Int,
    val login: String,
    val repos_url: String,
    val type: String,
    val url: String
)