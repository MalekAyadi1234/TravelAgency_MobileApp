package com.example.retrofitdemo.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.reservationchaise.reservationchaiseItem

import kotlinx.android.synthetic.main.row_material.view.*

class MyReservationChaiseAdapter(): RecyclerView.Adapter<MyReservationChaiseAdapter.MyViewHolder>(){

    private var myList = emptyList<reservationchaiseItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_material, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {




            holder.itemView.imageMat.setImageResource(R.drawable.ic_seat_available)
            holder.itemView.name_mat.text=myList[position].num
              holder.itemView.date_mat.text=myList[position].num
          //holder.itemView.heuredebut_mat.text=myList[position].seancedata[position].id
            //holder.itemView.heurefin_mat.text=myList[position].numseat











/*
       if (myList[position].disponibilite){

            holder.itemView.imageChaise.setImageResource(R.drawable.ic_seat_available)
           holder.itemView.num_chaise.text=myList[position].numChaise

           holder.itemView.setOnClickListener { v ->
               val intent = Intent(v.context, CheckoutActivity::class.java).apply {
                   putExtra("num", myList[position].numChaise)
                   putExtra("date", datee)


               }
               v.context.startActivity(intent)
           }
       // IMAGE DISPO

        }else{

           holder.itemView.imageChaise.setImageResource(R.drawable.ic_seat_unavailable)
           holder.itemView.num_chaise.text=myList[position].numChaise
           holder.itemView.setOnClickListener { v ->
            Toast(v.context).apply {
                val inflater = LayoutInflater.from(v.context)

                duration=Toast.LENGTH_SHORT
                setGravity(Gravity.CENTER,0,0)
                view=inflater.inflate(R.layout.custom_toast, null)
            }.show()
           }

       }

*/
    }

    fun setData(newList: List<reservationchaiseItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}