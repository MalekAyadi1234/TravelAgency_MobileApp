package com.example.retrofitdemo.adapter.admin
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.Chaise
import com.example.retrofitdemo.model.SeanceItem
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.row_layout.view.*
class MyChaiseAdminAdapter: RecyclerView.Adapter<MyChaiseAdminAdapter.MyViewHolder>(){

    private var myList = emptyList<com.example.retrofitdemo.model.Seat.Chaise>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.iv_image.setImageResource(R.drawable.ic_seat_available)
        holder.itemView.tv_title.text ="Num: "+myList[position].numChaise


    }

    fun setData(newList: List<com.example.retrofitdemo.model.Seat.Chaise>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}