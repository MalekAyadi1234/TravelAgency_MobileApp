package com.example.retrofitdemo.adapter.admin
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.ChooseSeatActivity
import com.example.retrofitdemo.MainActivity2
import com.example.retrofitdemo.R
import com.example.retrofitdemo.admin.MainActivity2Admin
import com.example.retrofitdemo.model.SeanceItem
import kotlinx.android.synthetic.main.row_layout.view.*
class MySeatAdminAdapter: RecyclerView.Adapter<MySeatAdminAdapter.MyViewHolder>(){

    private var myList = emptyList<SeanceItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, MainActivity2Admin::class.java).apply {
                putExtra("id", myList[position].id)
                putExtra("date", myList[position].dateSeance)
            }
            v.context.startActivity(intent)
        }

        holder.itemView.userId_txt.text ="Num: "+myList[position].numSeance.toString()
        holder.itemView.id_txt.text = myList[position].id.toString()
        holder.itemView.title_txt.text = myList[position].duree.toString()
        holder.itemView.body_txt.text =myList[position].heureDebut
        holder.itemView.tvEndTime.text=myList[position].heureFin
    }

    fun setData(newList: List<SeanceItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}