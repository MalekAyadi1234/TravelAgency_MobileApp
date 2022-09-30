package com.example.retrofitdemo.adapter
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.lastreservationchaise.newreservationseatItem
import kotlinx.android.synthetic.main.qibus_softui_item_notification.view.*
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlinx.android.synthetic.main.row_layout.view.userId_txt

class MyfinalReservationAdapter: RecyclerView.Adapter<MyfinalReservationAdapter.MyViewHolder>(){

    private var myList = emptyList<newreservationseatItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.qibus_softui_item_notification, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.tvDate.text =myList[position].seancedata[position].dateSeance
        holder.itemView.tvMonth.text = ""
        holder.itemView.tvDestination.text = "Num Seance: "+myList[position].seancedata[position].numSeance.toString()
        holder.itemView.newid.text ="Seat Number: "+myList[position].numseat
      //  holder.itemView.tvEndTime.text=myList[position].heureFin
    }

    fun setData(newList: List<newreservationseatItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}