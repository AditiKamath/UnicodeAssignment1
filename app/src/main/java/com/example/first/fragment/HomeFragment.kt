package com.example.first.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.first.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    companion object{
        fun newRow() : HomeFragment{
            return HomeFragment()
        }
    }
    // creating a recycle adapter to convert the data into a view
    class RecycleAdapter (private val avengerList: Array<String>, private val clickListener : (TextView)->Unit)
        :RecyclerView.Adapter<RecycleAdapter.RecyclerViewHolder>(){

        //The view holder for the recycler view
        class RecyclerViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView);


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            val view : TextView = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_list_item
                ,parent,false) as TextView
            /// inflating the certain layout as individual recycler view items
            return RecyclerViewHolder(view)
        }
        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            holder.textView.setText(avengerList[position])
            holder.textView.setOnClickListener{clickListener(holder.textView)}
        }

        // getting size of the list visible on the screen
        override fun getItemCount(): Int {
            return avengerList.size
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        // dummy list for recycler view
        val avengerList :Array<String> = arrayOf("Iron Man","Captain America","Scarlet Witch","Black Widow",
            "Spiderman","Winter Soldier","Vision","Wasp")
        val recyclerView : RecyclerView = view.findViewById(R.id.recycle_view)
        recyclerView.adapter= RecycleAdapter(avengerList
        ) { textView : TextView -> Toast.makeText(context, textView.text, Toast.LENGTH_SHORT).show()}
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL)); //Adding divider lines
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view



    }



}