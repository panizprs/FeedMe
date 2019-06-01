package com.acm.workshop.feedme.app.ui.Posts

import com.acm.workshop.feedme.data.model.Post

interface PostsContract{
    interface View{
        fun showPosts(posts: List<Post>)
    }

    interface Presenter{
        fun getPosts()
        fun onDestroy()
    }
}