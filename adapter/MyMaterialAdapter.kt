package com.example.retrofitdemo.adapter
import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.checkout.CheckoutActivity
import com.example.retrofitdemo.checkout.CheckoutMaterialActivity
import com.example.retrofitdemo.model.MaterialItem
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.row_chaise.view.*
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlinx.android.synthetic.main.row_material.view.*

class MyMaterialAdapter(): RecyclerView.Adapter<MyMaterialAdapter.MyViewHolder>(){

    private var myList = emptyList<MaterialItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_material, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        if (myList[position].type.equals("vip")){
            if (myList[position].disponibilite){
                holder.itemView.imageMat.setImageResource(R.drawable.ic_vipdispo)
                holder.itemView.name_mat.text=myList[position].nomMateriel
                holder.itemView.date_mat.text=myList[position].dateDispo
                holder.itemView.heuredebut_mat.text=myList[position].heureDebut
                holder.itemView.heurefin_mat.text=myList[position].heureFin

                holder.itemView.setOnClickListener { v ->
                    val intent = Intent(v.context, CheckoutMaterialActivity::class.java).apply {
                        putExtra("id", myList[position].id)
                        putExtra("date", myList[position].dateDispo)
                        putExtra("name", myList[position].nomMateriel)



                    }
                    v.context.startActivity(intent)
                }
            }else{
                holder.itemView.imageMat.setImageResource(R.drawable.ic_vipnondispo)
                holder.itemView.name_mat.text=myList[position].nomMateriel
                holder.itemView.date_mat.text=myList[position].dateDispo
                holder.itemView.heuredebut_mat.text=myList[position].heureDebut
                holder.itemView.heurefin_mat.text=myList[position].heureFin


                holder.itemView.setOnClickListener { v ->
                    Toast(v.context).apply {
                        val inflater = LayoutInflater.from(v.context)

                        duration=Toast.LENGTH_SHORT
                        setGravity(Gravity.CENTER,0,0)
                        view=inflater.inflate(R.layout.custom_toast_material, null)
                    }.show()
                }
            }

        }
        if (myList[position].type.equals("food")){
            if (myList[position].disponibilite){
                holder.itemView.imageMat.setImageResource(R.drawable.ic_fooddispo)
                holder.itemView.name_mat.text=myList[position].nomMateriel
                holder.itemView.date_mat.text=myList[position].dateDispo
                holder.itemView.heuredebut_mat.text=myList[position].heureDebut
                holder.itemView.heurefin_mat.text=myList[position].heureFin

                holder.itemView.setOnClickListener { v ->
                    val intent = Intent(v.context, CheckoutMaterialActivity::class.java).apply {
                        putExtra("id", myList[position].id)
                        putExtra("date", myList[position].dateDispo)
                        putExtra("name", myList[position].nomMateriel)



                    }
                    v.context.startActivity(intent)
                }
            }else{
                holder.itemView.imageMat.setImageResource(R.drawable.ic_foodnondispo)
                holder.itemView.name_mat.text=myList[position].nomMateriel
                holder.itemView.date_mat.text=myList[position].dateDispo
                holder.itemView.heuredebut_mat.text=myList[position].heureDebut
                holder.itemView.heurefin_mat.text=myList[position].heureFin

                holder.itemView.setOnClickListener { v ->
                    Toast(v.context).apply {
                        val inflater = LayoutInflater.from(v.context)

                        duration=Toast.LENGTH_SHORT
                        setGravity(Gravity.CENTER,0,0)
                        view=inflater.inflate(R.layout.custom_toast_material, null)
                    }.show()
                }

            }
        }

        if (myList[position].type.equals("transport")){
            if (myList[position].disponibilite){
                holder.itemView.imageMat.setImageResource(R.drawable.ic_busdispo)
                holder.itemView.name_mat.text=myList[position].nomMateriel
                holder.itemView.date_mat.text=myList[position].dateDispo
                holder.itemView.heuredebut_mat.text=myList[position].heureDebut
                holder.itemView.heurefin_mat.text=myList[position].heureFin

                holder.itemView.setOnClickListener { v ->
                    val intent = Intent(v.context, CheckoutMaterialActivity::class.java).apply {
                        putExtra("id", myList[position].id)
                        putExtra("date", myList[position].dateDispo)
                        putExtra("name", myList[position].nomMateriel)



                    }
                    v.context.startActivity(intent)
                }
            }else{
                holder.itemView.imageMat.setImageResource(R.drawable.ic_transportnondispo)
                holder.itemView.name_mat.text=myList[position].nomMateriel
                holder.itemView.date_mat.text=myList[position].dateDispo
                holder.itemView.heuredebut_mat.text=myList[position].heureDebut
                holder.itemView.heurefin_mat.text=myList[position].heureFin

                holder.itemView.setOnClickListener { v ->
                    Toast(v.context).apply {
                        val inflater = LayoutInflater.from(v.context)

                        duration=Toast.LENGTH_SHORT
                        setGravity(Gravity.CENTER,0,0)
                        view=inflater.inflate(R.layout.custom_toast_material, null)
                    }.show()
                }

            }
        }


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

    fun setData(newList: List<MaterialItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}