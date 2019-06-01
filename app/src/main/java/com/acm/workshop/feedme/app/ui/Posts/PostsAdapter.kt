package com.acm.workshop.feedme.app.ui.Posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acm.workshop.feedme.R
import com.acm.workshop.feedme.data.model.Post

class PostsAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_post_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val postTitle = view.findViewById<TextView>(R.id.title)
        val postBody = view.findViewById<TextView>(R.id.body)

        fun bind(post: Post){
            postTitle.text = post.title
            postBody.text = post.body
        }
    }
}