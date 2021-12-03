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
import kotlinx.android.synthetic.main.fragment_sports.view.*
import kotlinx.android.synthetic.main.fragment_tech.*
import kotlinx.android.synthetic.main.fragment_tech.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class techFrag : Fragment() {


    lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_tech, container, false)

        showNews()

        view.bottomNavigation_tech.setOnItemSelectedListener(){

            when(it.itemId) {

                R.id.hospitol_button -> {
                    findNavController().navigate(R.id.action_techFrag_to_healthFrag)
                    Toast.makeText(requireContext(),"wait a moment", Toast.LENGTH_SHORT).show()

                }

                R.id.sports_button ->{
                    findNavController().navigate(R.id.action_techFrag_to_sportsFrag)

                    Toast.makeText(requireContext(),"wait a moment", Toast.LENGTH_SHORT).show()

                }
            }
            true

        }

        return  view
    }

    private fun showNews() {

            val news= NewsService.newsInstance.getHeadLines("in","Technology",1)
            news.enqueue(object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    val news= response.body()
                    if (news!=null){
                        adapter= NewsAdapter(requireContext(),news.articles)

                        techRecyclerView.adapter=adapter
                        techRecyclerView.layoutManager= LinearLayoutManager(requireContext())
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


