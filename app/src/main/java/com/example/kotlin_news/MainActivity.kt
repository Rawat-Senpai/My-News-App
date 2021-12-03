package com.example.kotlin_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    lateinit var adapter: NewsAdapter
    lateinit var newsList: RecyclerView
    lateinit var editText: EditText
    lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


/*
//        editText=findViewById(R.id.editText)
//        button=findViewById(R.id.button)
//       // val myWebView: WebView = findViewById(R.id.webview)
//        button.setOnClickListener(){
//            getNews();
//        }
//    getNews();
//        newsList= findViewById(R.id.newsList)

 */

    }

//    private fun makeCurrentFragment(fragment:Fragment) =
//        supportFragmentManager.beginTransaction().apply{
//            replace(R.id.hello,fragment)
//            commit()
//
//    }
//
/*
/    private fun getNews() {
//        val type=editText.text.toString()
//        val news= NewsService.newsInstance.getHeadLines("in",type,1)
//            news.enqueue(object : Callback<News> {
//                override fun onResponse(call: Call<News>, response: Response<News>) {
//                    val news= response.body()
//                    if (news!=null){
//                        adapter= NewsAdapter(this@MainActivity,news.articles)
//                        newsList.adapter=adapter
//                        newsList.layoutManager=LinearLayoutManager(this@MainActivity)
//                        Log.d("SHOBHIT",news.toString())
//                    }
//                }
//
//                override fun onFailure(call: Call<News>, t: Throwable) {
//                    Log.d("SHOBHIT","error aa gaya bhai ")
//                }
//
//            }
//
//            )
//
//    }
//
 */


}