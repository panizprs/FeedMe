package com.acm.workshop.feedme.app.ui.Posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.acm.workshop.feedme.R
import com.acm.workshop.feedme.app.MyApp
import com.acm.workshop.feedme.data.model.Post
import javax.inject.Inject


class PostsFragment : Fragment() , PostsContract.View {
    // TODO: Rename and change types of parameters


    @Inject
    lateinit var postsPresenter: PostsPresenter

    @Inject
    lateinit var postViewModelFactory : PostsViewModelFactory

    private val postsViewModel by lazy {
        ViewModelProviders.of(this, postViewModelFactory)[PostsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyApp.component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(view.context)


//        postsPresenter.view = this
//        postsPresenter.getPosts()

        postsViewModel.getPosts()
        postsViewModel.apply {
            showPosts.observe(this@PostsFragment, Observer {posts ->
                val loadingBar = view.findViewById<View>(R.id.loadingBar)
                loadingBar?.visibility = View.GONE

//        recyclerView?.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = PostsAdapter(posts)
            })
        }
    }

    override fun showPosts(posts: List<Post>) {
//        println("posts ${posts.size}")
        val loadingBar = view?.findViewById<View>(R.id.loadingBar)
        loadingBar?.visibility = View.GONE

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = PostsAdapter(posts)
    }


    override fun onDestroy() {
        super.onDestroy()

        postsViewModel.onDestroy()
    }

}