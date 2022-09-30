package com.example.retrofitdemo.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.PresenceItem


import kotlinx.android.synthetic.main.item_layout.view.*



class MyPresenceAdapter: RecyclerView.Adapter<MyPresenceAdapter.MyViewHolder>(){

    private var myList = emptyList<PresenceItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        if (myList[position].type.equals("trip")) {
          //  holder.itemView.iv_image.setImageResource(R.drawable.ic_seat_white)

            holder.itemView.iv_image.setImageResource(R.drawable.ic_baseline_local_offer_24avai)
            holder.itemView.tv_newtitle.text = myList[position].description
            holder.itemView.tv_title.text = ""
            holder.itemView.tv_description.text = ""

        }

        if (myList[position].type.equals("extra")) {
            holder.itemView.iv_image.setImageResource(R.drawable.ic_extramallek)
            holder.itemView.tv_description.text = myList[position].description
        }





    }

    fun setData(newList: List<PresenceItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}