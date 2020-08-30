package com.example.first.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.first.LoginActivity
import com.example.first.R


class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val next_page = view.findViewById<Button>(R.id.next_page)
        next_page.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ProfileFragment.context, LoginActivity::class.java)
            startActivity(intent)
        })
        return view
    }

}