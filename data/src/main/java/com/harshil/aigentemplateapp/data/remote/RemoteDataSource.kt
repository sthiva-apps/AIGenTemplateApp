package com.harshil.aigentemplateapp.data.remote

import com.harshil.aigentemplateapp.data.DataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) : DataSource {
    // Implement data source methods here
}
