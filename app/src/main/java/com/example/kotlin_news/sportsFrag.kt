package com.example.kotlin_news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_sports.*
import kotlinx.android.synthetic.main.fragment_sports.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class sportsFrag : Fragment() {

    lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_sports, container, false)

        showNews()
        view.bottomNavigation_sports.setOnItemSelectedListener(){

            when(it.itemId) {

                R.id.hospitol_button -> {
                    findNavController().navigate(R.id.action_sportsFrag_to_healthFrag)
                    Toast.makeText(requireContext(),"wait a moment",Toast.LENGTH_SHORT).show()

                }

                R.id.technology_button ->{
                    findNavController().navigate(R.id.action_sportsFrag_to_techFrag)

                    Toast.makeText(requireContext(),"wait a moment",Toast.LENGTH_SHORT).show()

                }
            }
            true

        }

        return view
    }

    private fun showNews() {
        val news= NewsService.newsInstance.getHeadLines("in","Sports",1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news= response.body()
                if (news!=null){
                    adapter= NewsAdapter(requireContext(),news.articles)

                    sportsRecyclerView.adapter=adapter
                    sportsRecyclerView.layoutManager= LinearLayoutManager(requireContext())
                    Log.d("SHOBHIT",news.toString())
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("SHOBHIT","error aa gaya bhai ")
            }

        }

        )

    }


}