package com.example.experiment.Model.category

import java.io.Serializable

data class CategoryResult(
    val copyright: String,
    val last_modified: String,
    val num_results: Int,
    val results: Results,
    val status: String
):Serializable