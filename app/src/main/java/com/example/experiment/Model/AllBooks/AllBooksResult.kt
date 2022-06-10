package com.example.experiment.Model.AllBooks

import java.io.Serializable

data class AllBooksResult(
    val copyright: String,
    val num_results: Int,
    val results: Results,
    val status: String
):Serializable