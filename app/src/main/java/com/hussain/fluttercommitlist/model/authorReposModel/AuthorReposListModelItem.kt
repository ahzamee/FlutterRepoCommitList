package com.hussain.fluttercommitlist.model.authorReposModel

data class AuthorReposListModelItem(
    val default_branch: String,
    val description: Any,
    val full_name: String,
    val html_url: String,
    val id: Int,
    val name: String,
    val node_id: String,
    val owner: Owner,
    val `private`: Boolean,
    val url: String,
    val visibility: String
)