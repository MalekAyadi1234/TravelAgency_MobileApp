package com.example.retrofitdemo.adapter.admin
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.admin.model.whoreschaiseItem
import com.example.retrofitdemo.model.passageCle.passagecleItem
import kotlinx.android.synthetic.main.guess_item_layout.view.*

import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.item_layout.view.tv_title
import kotlinx.android.synthetic.main.row_chaise.view.*

import kotlinx.android.synthetic.main.row_layout.view.*
class GuessAdapter: RecyclerView.Adapter<GuessAdapter.MyViewHolder>(){

    private var myList = emptyList<whoreschaiseItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.guess_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.itemView.imageChaise.setImageResource(R.drawable.ic_seat_available)
        holder.itemView.textViewuserrr.text=myList[position].userdatas
        holder.itemView.textViewseeeeat.text=myList[position].numseat

        // holder.itemView.tv_description.text = "Date: "+myList[position].datePassage
       // holder.itemView.num_chaise.text =myList[position].userdatas

    }

    fun setData(newList: List<whoreschaiseItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}