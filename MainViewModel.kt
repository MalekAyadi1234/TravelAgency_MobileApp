package com.example.retrofitdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdemo.admin.model.resmattItem
import com.example.retrofitdemo.admin.model.whoreschaiseItem
import com.example.retrofitdemo.model.*
import com.example.retrofitdemo.model.Seat.SeatItem
import com.example.retrofitdemo.model.delai.DelaiItem
import com.example.retrofitdemo.model.lastreservationchaise.newreservationseatItem
import com.example.retrofitdemo.model.passageCle.passagecleItem
import com.example.retrofitdemo.model.reservationchaise.reservationchaiseItem
import com.example.retrofitdemo.model.reservationmat.reservationmatItem

import com.example.retrofittest.model.Seat
import com.example.retrofitdemo.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    
    var myResponse: MutableLiveData<Response<Seat>> = MutableLiveData()
    var myCustomPosts: MutableLiveData<Response<List<SeanceItem>>> = MutableLiveData()
    var myCustomSeats: MutableLiveData<Response<List<SeatItem>>> = MutableLiveData()
    var myCustomChaise: MutableLiveData<Response<List<com.example.retrofitdemo.model.Seat.Chaise>>> = MutableLiveData()
    var myResponse2: MutableLiveData<Response<List<Chaise>>> = MutableLiveData()
    var myResponse3: MutableLiveData<Response<List<MaterialItem>>> = MutableLiveData()
    var myResponse4: MutableLiveData<Response<List<MaterialItem>>> = MutableLiveData()
    var myCustomPassage: MutableLiveData<Response<List<passagecleItem>>> = MutableLiveData()
    var myCustomDelai: MutableLiveData<Response<List<DelaiItem>>> = MutableLiveData()
    var myCustomReservationmat: MutableLiveData<Response<List<reservationmatItem>>> = MutableLiveData()
    var myCustomuserss: MutableLiveData<Response<List<userssItem>>> = MutableLiveData()
    var myCustomReservationmatt: MutableLiveData<Response<List<resmattItem>>> = MutableLiveData()
    var myCustomReservationchaise: MutableLiveData<Response<List<reservationchaiseItem>>> = MutableLiveData()
    var myCustomPresence: MutableLiveData<Response<List<PresenceItem>>> = MutableLiveData()
    var myCustomPosts2: MutableLiveData<Response<List<Seat>>> = MutableLiveData()
    var myCustomreservationbyemail: MutableLiveData<Response<List<newreservationseatItem>>> = MutableLiveData()
    var who: MutableLiveData<Response<List<whoreschaiseItem>>> = MutableLiveData()



    fun getCustomPosts(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomSeances(userId, sort, order)
            myCustomPosts.value = response
        }
    }

    fun getwhoPosts(str:String,str1:String) {
        viewModelScope.launch {
            val response= repository.whores(str,str1)
            who.value=response
        }
    }

    fun getChaises(str:String){
        viewModelScope.launch {
            val response= repository.getChaises(str)
            myCustomSeats.value=response
        }

    }


    fun getreservationbyemail(str:String){
        viewModelScope.launch {
            val response= repository.getreservationbyemail(str)
            myCustomreservationbyemail.value=response
        }

    }

    fun getuserss(str:String){
        viewModelScope.launch {
            val response= repository.getuser(str)
            myCustomuserss.value=response
        }

    }


    fun getseancesbydate(str:String){
        viewModelScope.launch {
            val response= repository.getcustomseancebydate(str)
            myCustomPosts.value=response
        }

    }

   //getCustomChaisesAdmin

    fun getCustomChaisesAdmin(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomChaisesAdmin(userId, sort, order)
            myCustomChaise.value = response
        }
    }

    fun updateMatStatue(str:String){
        viewModelScope.launch {
            val response= repository.updateMatStatue(str)
            //myResponse4.value=response
        }

    }

    fun reserveMat(str:String,str1:String){
        viewModelScope.launch {
            val response= repository.reserverMat(str,str1)
            //myResponse4.value=response
        }

    }

    fun updateuser(str:String,str1:String){
        viewModelScope.launch {
            val response= repository.updateuser(str,str1)
            //myResponse4.value=response
        }

    }


    fun updatealluser(str:String,str1:String,str2:String,str3:String){
        viewModelScope.launch {
            val response= repository.updatealluser(str,str1,str2,str3)
            //myResponse4.value=response
        }

    }

    fun deleteuser(str:String){
        viewModelScope.launch {
            val response= repository.deleteuser(str)
            //myResponse4.value=response
        }

    }


    fun getuserbyemail(str:String){
        viewModelScope.launch {
            val response= repository.getuserbyemail(str)
            //myResponse4.value=response
        }

    }

    fun updateSeatStatue(str:String,str2:String){
        viewModelScope.launch {
            val response= repository.updateSeatStatue(str, str2)
            //myResponse4.value=response
        }

    }


    //*****
    fun addSeance(str: Int,str2: String,str3: String,str4: String,str5: Int){
        viewModelScope.launch {
            val response= repository.addSeance(str,str2,str3,str4,str5)
            //myResponse4.value=response
        }

    }
    //*****


    fun addPresence(str:String,str2:String){
        viewModelScope.launch {
            val response= repository.addPresence(str, str2)
            //myResponse4.value=response
        }

    }

    fun reserveSeat(str:String,str2:String,str3:String){
        viewModelScope.launch {
            val response= repository.reserveSeat(str, str2,str3)
            //myResponse4.value=response
        }

    }
    
    fun getCustomMaterials(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomMaterials(userId, sort, order)
            myResponse3.value = response
        }
    }

    fun getCustomPassage(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomPassageCle(userId, sort, order)
            myCustomPassage.value = response
        }
    }

    fun getCustomPresence(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomPresence(userId, sort, order)
            myCustomPresence.value = response
        }
    }



    fun getCustomDelai(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomDelai(userId, sort, order)
            myCustomDelai.value = response
        }
    }

    fun getCustomReservationmat(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomReservationmat(userId, sort, order)
            myCustomReservationmat.value = response
        }
    }

    fun getCustomReservationchaise(i: Int, s: String, s1: String) {

    }


    /* fun getCustomReservationchaise(userId: Int, sort: String, order: String) {
         viewModelScope.launch {
             val response = repository.getCustomReservationchaise(userId, sort, order)
             myCustomReservationchaise.value = response
         }
     }*/



}