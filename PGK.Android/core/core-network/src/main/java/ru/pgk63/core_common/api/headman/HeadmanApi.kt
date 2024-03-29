package ru.pgk63.core_common.api.headman

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import ru.pgk63.core_common.api.headman.model.HeadmanRegistrationBody
import ru.pgk63.core_common.api.headman.model.HeadmanUpdateRaportichkaRowBody
import ru.pgk63.core_common.api.user.model.UserRegistrationResponse

interface HeadmanApi {

    @POST("/pgk63/api/Headman/Registration")
    suspend fun registration(
        @Body body: HeadmanRegistrationBody
    ): Response<UserRegistrationResponse>

    @POST("/pgk63/api/Headman/Deputy/Registration")
    suspend fun registrationDeputy(
        @Body body: HeadmanRegistrationBody
    ): Response<UserRegistrationResponse>

    @PUT("/pgk63/api/Headman/Raportichka/Row/{id}")
    suspend fun updateRaportichkaRow(
        @Path("id") rowId:Int,
        @Body body: HeadmanUpdateRaportichkaRowBody
    ): Response<Unit?>

    @POST("/pgk63/api/Headman/Raportichka")
    suspend fun createRaportichka(): Response<Unit?>
}