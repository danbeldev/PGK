package ru.pgk63.core_common.api.speciality

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.pgk63.core_common.Constants
import ru.pgk63.core_common.api.speciality.model.Specialization
import ru.pgk63.core_common.api.speciality.model.SpecializationResponse

interface SpecializationApi {

    @GET("/pgk63/api/Speciality")
    suspend fun getAll(
        @Query("search") search:String? = null,
        @Query("pageNumber") pageNumber: Int = 1,
        @Query("pageSize") pageSize: Int = Constants.PAGE_SIZE
    ): SpecializationResponse

    @GET("/pgk63/api/Speciality/{id}")
    suspend fun getById(
        @Path("id") id:Int
    ): Response<Specialization>
}