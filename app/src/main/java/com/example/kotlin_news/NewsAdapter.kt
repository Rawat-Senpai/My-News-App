package com.example.kotlin_news

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context,val  articles: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

      val view= LayoutInflater.from(context).inflate(R.layout.new_layout,parent,false)

      return  ArticleViewHolder(view)

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article :Article=  articles[position]
        holder.titleNews.text=article.title
        holder.descriptionText.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.NewsImage)
        holder.itemView.setOnClickListener()
        {

        //Toast.makeText(context, article.urlToImage,Toast.LENGTH_LONG).show();

            val intent:Intent = Intent(context,web_View::class.java)

            intent.putExtra("url",article.url) ;

            context.startActivity(intent)

        // val intent = Intent(context,article.urlToImage)


        }

    }

    override fun getItemCount(): Int {
      return articles.size
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleNews = itemView.findViewById<TextView>(R.id.HeadingText)
        val descriptionText = itemView.findViewById<TextView>(R.id.discriptionText)
        val NewsImage: ImageView =itemView.findViewById<ImageView>(R.id.NewsImage)

    }

}