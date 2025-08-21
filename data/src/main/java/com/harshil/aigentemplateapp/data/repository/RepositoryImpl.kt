package com.harshil.aigentemplateapp.data.repository

import com.harshil.aigentemplateapp.data.DataSource
import com.harshil.aigentemplateapp.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: DataSource) : Repository {
    // Implement repository methods here
}
