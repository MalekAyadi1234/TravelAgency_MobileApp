package com.example.retrofitdemo.adapter
import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.MainActivity2
import com.example.retrofitdemo.R
import com.example.retrofitdemo.checkout.CheckoutActivity
import com.example.retrofitdemo.model.Chaise
import com.example.retrofitdemo.model.Seat.SeatItem
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.row_chaise.view.*
import kotlinx.android.synthetic.main.row_layout.view.*

class MySeatAdapter(iddd:String,dated:String): RecyclerView.Adapter<MySeatAdapter.MyViewHolder>(){
    var idd=iddd
    var datee=dated

    
    private var myList = emptyList<SeatItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_chaise, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {








        if (myList[position].disponibility){

            holder.itemView.imageChaise.setImageResource(R.drawable.ic_baseline_local_offer_24avai)
            holder.itemView.num_chaise.text=myList[position].chaise.numChaise
            holder.itemView.setOnClickListener { v ->
                val intent = Intent(v.context, CheckoutActivity::class.java).apply {
                    putExtra("id", myList[position].id)
                    putExtra("num", myList[position].chaise.numChaise.toString())
                    putExtra("idd", idd.toString())
                    putExtra("dateed", datee.toString())
                }
                v.context.startActivity(intent)
            }

            // IMAGE DISPO

        }else{

            holder.itemView.imageChaise.setImageResource(R.drawable.ic_baseline_local_offer_24)
            holder.itemView.num_chaise.text=myList[position].chaise.numChaise
            holder.itemView.setOnClickListener { v ->
                Toast(v.context).apply {
                    val inflater = LayoutInflater.from(v.context)

                    duration=Toast.LENGTH_SHORT
                    setGravity(Gravity.CENTER,0,0)
                    view=inflater.inflate(R.layout.custom_toast, null)
                }.show()
            }

        }





    }

    fun setData(newList: List<SeatItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}