package com.demo.project.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall : suspend () -> Response<T>
    ): Flow<Result<T>> = flow {
        emit(Result.Loading)
        val response = apiCall()
        val successResponse = response.body()
        if (successResponse != null) {
            emit(Result.Success(successResponse))
        } else {
            val errorResponse = response.errorBody()
            if (errorResponse != null) {
                emit(Result.Failure(IOException(errorResponse.toString())))
            } else {
                emit(Result.Failure(IOException("Something went wrong")))
            }
        }
    }.catch { exception -> exception.printStackTrace()
        emit(Result.Failure(Exception(exception)))
    }.flowOn(dispatcher)
}