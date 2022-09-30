package com.example.retrofitdemo.repository

import com.example.retrofitdemo.admin.model.whoreschaiseItem
import com.example.retrofitdemo.api.RetrofitInstance
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
import retrofit2.Response

class Repository {

   /* suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Seat>> {
        return RetrofitInstance.api.getCustomPosts(userId, sort, order)
    }*/
    suspend fun getCustomSeances(userId: Int, sort: String, order: String): Response<List<SeanceItem>> {
        return RetrofitInstance.api.getCustomSeances(userId, sort, order)
    }


    suspend fun getChaises(str:String):Response<List<SeatItem>>{
        return RetrofitInstance.api.getCustomChaises(str)
    }

    suspend fun getreservationbyemail(str:String):Response<List<newreservationseatItem>>{
        return RetrofitInstance.api.getCustomreservationbyemail(str)
    }


    suspend fun getCustomMaterials(userId: Int, sort: String, order: String): Response<List<MaterialItem>> {
        return RetrofitInstance.api.getCustomMaterials(userId, sort, order)
    }

    suspend fun updateMatStatue(str: String) {
        return RetrofitInstance.api.updateMatStatue(str)


    }

    suspend fun updateSeatStatue(str: String,str2: String) {
        return RetrofitInstance.api.updateSeatStatue(str,str2)


    }

    suspend fun whores(str: String,str2: String):Response<List<whoreschaiseItem>>  {
        return RetrofitInstance.api.whoreserved(str,str2)


    }


    suspend fun addSeance(str: Int,str2: String,str3: String,str4: String,str5: Int) {
        return RetrofitInstance.api.addSeance(str,str2,str3,str4,str5)


    }


    suspend fun addPresence(str: String,str2: String) {
        return RetrofitInstance.api.addPresence(str,str2)


    }



    suspend fun reserveSeat(str: String,str2: String,str3: String) {
        return RetrofitInstance.api.reserveSeat(str,str2,str3)


    }

    suspend fun reserverMat(str: String,str2: String) {
        return RetrofitInstance.api.reserveMat(str,str2)


    }

    suspend fun updateuser(str: String,str2: String) {
        return RetrofitInstance.api.updatepassword(str,str2)


    }

    suspend fun updatealluser(str: String,str2: String,str3: String,str4: String) {
        return RetrofitInstance.api.updatealluser(str,str2,str3,str4)


    }

    suspend fun deleteuser(str: String) {
        return RetrofitInstance.api.deleteuser(str)


    }

    suspend fun getuser(str: String): Response<List<userssItem>> {
        return RetrofitInstance.api.getCustomUserss(str)


    }


    suspend fun getuserbyemail(str: String): Response<List<userssItem>> {
        return RetrofitInstance.api.getuserbyemail(str)


    }

    suspend fun getcustomseancebydate(str: String): Response<List<SeanceItem>> {
        return RetrofitInstance.api.getCustomseancebydate(str)


    }
    suspend fun getCustomPassageCle(userId: Int, sort: String, order: String): Response<List<passagecleItem>> {
        return RetrofitInstance.api.getCustomPassage(userId, sort, order)
    }

    suspend fun getCustomDelai(userId: Int, sort: String, order: String): Response<List<DelaiItem>> {
        return RetrofitInstance.api.getCustomDelai(userId, sort, order)
    }

    suspend fun getCustomPresence(userId: Int, sort: String, order: String): Response<List<PresenceItem>> {
        return RetrofitInstance.api.getCustomPresence(userId, sort, order)
    }

    suspend fun getCustomReservationmat(userId: Int, sort: String, order: String): Response<List<reservationmatItem>> {
        return RetrofitInstance.api.getCustomReservationmat(userId, sort, order)
    }


    suspend fun getCustomChaisesAdmin(userId: Int, sort: String, order: String): Response<List<Chaise>> {
        return RetrofitInstance.api.getCustomAdminSeats(userId, sort, order)
    }





}