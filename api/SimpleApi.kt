package com.example.retrofitdemo.api

import com.example.retrofitdemo.admin.model.resmattItem
import com.example.retrofitdemo.admin.model.whoreschaiseItem
import com.example.retrofitdemo.model.MaterialItem
import com.example.retrofitdemo.model.PresenceItem
import com.example.retrofitdemo.model.SeanceItem
import com.example.retrofitdemo.model.Seat.Chaise
import com.example.retrofitdemo.model.Seat.SeatItem
import com.example.retrofitdemo.model.delai.DelaiItem
import com.example.retrofitdemo.model.lastreservationchaise.newreservationseatItem
import com.example.retrofitdemo.model.passageCle.passagecleItem
import com.example.retrofitdemo.model.reservationchaise.reservationchaiseItem
import com.example.retrofitdemo.model.reservationmat.reservationmatItem
import com.example.retrofitdemo.model.userssItem

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @POST("api/authentification/login")
    fun login(
        @Body userRequest:UserRequest
    ): Call<UserResponse>


    @POST("api/authentification/register")
    fun create(
        @Body userRequest:CreateUserRequest
    ): Call<CreateUserResponse>

    @POST("api/materiel/store")
    fun createMat(
        @Body userRequest:CreateMatRequest
    ): Call<CreateMatResponse>

    @POST("api/chaise/store")
    fun createChaise(
        @Body userRequest:CreateChaiseRequest
    ): Call<CreateChaiseResponse>



    @GET("/api/passagecle")
    suspend fun getCustomPassage(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<passagecleItem>>


    @GET("/api/reservermateriel")
    suspend fun getCustomReservationmat(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<reservationmatItem>>


    @GET("/api/reservermateriel")
    suspend fun getCustomReservationchaise(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<resmattItem>>


    @GET("/api/notifdelai")
    suspend fun getCustomDelai(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<DelaiItem>>

    @GET("/api/chaise")
    suspend fun getCustomAdminSeats(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Chaise>>

    @GET("/api/seance")
    suspend fun getCustomSeances(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<SeanceItem>>


    @POST("api/notifdelai/store")
    fun delai(
        @Body userRequest: CreateDelaiRequest
    ): Call<CreateChaiseResponse>


    @POST("api/passagecle/store")
    fun passage(
        @Body userRequest: CreatePassageRequest
    ): Call<CreatePassageResponse>


    //api/chaise/store

    @POST("api/passagecle/store")
    fun addChaiseadmin(
        @Body userRequest: CreateChaiseRequest
    ): Call<CreateChaiseResponse>



    @GET("/api/materiel")
    suspend fun getCustomMaterials(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<MaterialItem>>


    @GET("/api/presence")
    suspend fun getCustomPresence(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<PresenceItem>>


    @GET("/api/materiel/updatee/{mat_id}")
    suspend fun updateMatStatue(
        @Path("mat_id") mat_id:String
    )

    @GET("/api/seance/showw/{seance_id}")
    suspend fun getCustomChaises(
        @Path("seance_id") seance_id:String
    ): Response<List<SeatItem>>

    @GET("/api/seance/updatee/{seance_id}/{seat_id}")
    suspend fun updateSeatStatue(
        @Path("seance_id") seance_id:String,
        @Path("seat_id") seat_id:String
    )

//http://localhost:3000/api/reserverchaise/showdata/61ed4ac9177837081725b89d/a1
    //router.get('/showdata/:numseance/:numseatt',ReservationchaiseController.index3)
    @GET("/api/reserverchaise/showdata/{numseance}/{numseatt}")
    suspend fun whoreserved(
        @Path("numseance") numseance:String,
        @Path("numseatt") numseatt:String
    ): Response<List<whoreschaiseItem>>


//http://localhost:3000/api/seance/storee/409/23-12-2021/11/13/1
    /*
    	"": 26,
		"": "23-12-2021",
		"": "11:30",
		"": "13:30",
		"": 1,
     */
    @GET("/api/seance/storee/{num_seance}/{date_seance}/{heure_debut}/{heure_fin}/{duree}")
    suspend fun addSeance(
        @Path("num_seance") num_seance:Int,
        @Path("date_seance") date_seance:String,
        @Path("heure_debut") heure_debut:String,
        @Path("heure_fin") heure_fin:String,
        @Path("duree") duree:Int

        )

   // http://localhost:3000/api/presence/storee/type/description
    @GET("/api/presence/storee/{type}/{description}")
    suspend fun addPresence(
        @Path("type") type:String,
        @Path("description") description:String
    )


    @GET("/api/reserverchaise/storee/{seance_id}/{seat_num}/{user_name}")
    suspend fun reserveSeat(
        @Path("seance_id") seance_id:String,
        @Path("seat_num") seat_num:String,
        @Path("user_name") user_name:String
        )


   // http://localhost:3000/api/reservermateriel/storee/malek/61aecee8d158f871ad637a19
    @GET("/api/reservermateriel/storee/{user_name}/{id_mat}")
    suspend fun reserveMat(
        @Path("user_name") user_name:String,
        @Path("id_mat") id_mat:String
    )


    // http://localhost:3000/api/utilisateur/updatev/54164001/11111111
    @GET("/api/utilisateur/updatev/{phonenumber}/{newpassword}")
    suspend fun updatepassword(
        @Path("phonenumber") phonenumber:String,
        @Path("newpassword") newpassword:String
    )



    @GET("/api/materiel/storee/{typee}/{nom}/{date}/{heured}/{heuref}/{dureee}/{dispo}")
    suspend fun AdddMat(
        @Path("typee") typee:String,
        @Path("nom") nom:String,
        @Path("date") date:String,
        @Path("heured") heured:String,
        @Path("heuref") heuref:String,
        @Path("dureee") dureee:String,
        @Path("dispo") dispo:String
    )


    @GET("/api/utilisateur/showemail/{num}")
    suspend fun getCustomUserss(
        @Path("num") num:String
    ): Response<List<userssItem>>

    //http://localhost:3000/api/utilisateur/showe/test@esprit.tn
    @GET("/api/utilisateur/showe/{email}")
    suspend fun getuserbyemail(
        @Path("email") email:String
    ): Response<List<userssItem>>


    @GET("/api/seance/showdate/{num}")
    suspend fun getCustomseancebydate(
        @Path("num") num:String
    ): Response<List<SeanceItem>>


    @GET("/api/reserverchaise/showemail/{email}")
    suspend fun getCustomreservationbyemail(
        @Path("email") email:String
    ): Response<List<newreservationseatItem>>


    // http://localhost:3000/api/utilisateur/updateall/maryem@esprit.tn/myriam/54164000/44444444
    @GET("/api/utilisateur/updateall/{email}/{name}/{phone}/{password}")
    suspend fun updatealluser(
        @Path("email") email:String,
        @Path("name") name:String,
        @Path("phone") phone:String,
        @Path("password") password:String
    )



    //http://localhost:3000/api/utilisateur/deleteemail/ahmed@seif.tn
    @GET("/api/utilisateur/deleteemail/{email}")
    suspend fun deleteuser(
        @Path("email") email:String
    )

}