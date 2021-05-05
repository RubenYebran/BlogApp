package com.example.blogapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.blogapp.R
import com.example.blogapp.data.model.Post
import com.example.blogapp.databinding.FragmentHomeScreenBinding
import com.example.blogapp.ui.home.adapter.HomeScreenAdapter
import com.google.firebase.Timestamp


class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
    private lateinit var binding: FragmentHomeScreenBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding = FragmentHomeScreenBinding.bind(view)

        val postList = listOf(
            Post(
                "https://scontent.fasu6-1.fna.fbcdn.net/v/t1.6435-9/51569574_10218050080434172_8158649644176375808_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=174925&_nc_eui2=AeH4-aNtlyPpqa113U7ud5orA9hxGIhIpRAD2HEYiEilEKXaxGuAh7OZHZHwA6WOXdo&_nc_ohc=Py534_ato_sAX_lPKAM&_nc_ht=scontent.fasu6-1.fna&oh=dd0723f8258874a271f1b36694df9aa7&oe=60BA5A69",
                "Ruben Yebran",
                Timestamp.now(),
                "https://scontent.fasu6-1.fna.fbcdn.net/v/t1.18169-9/10369919_10205852284656901_3758308846855777465_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=09cbfe&_nc_eui2=AeHXg3gIfzvj9_l4iBl8SLesIfISfImaQ4wh8hJ8iZpDjDUP6VOlaP6uDj-jbKJHKW4&_nc_ohc=Fn3L3w40yiMAX-_-Qq0&_nc_ht=scontent.fasu6-1.fna&oh=12312961fd1ad69b2fc8547380f6ed17&oe=60BA2378"
            ),
            Post(
                "https://scontent.fasu6-1.fna.fbcdn.net/v/t1.6435-9/51569574_10218050080434172_8158649644176375808_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=174925&_nc_eui2=AeH4-aNtlyPpqa113U7ud5orA9hxGIhIpRAD2HEYiEilEKXaxGuAh7OZHZHwA6WOXdo&_nc_ohc=Py534_ato_sAX_lPKAM&_nc_ht=scontent.fasu6-1.fna&oh=dd0723f8258874a271f1b36694df9aa7&oe=60BA5A69",
                "Ruben Yebran",
                Timestamp.now(),
                "https://scontent.fasu6-1.fna.fbcdn.net/v/t1.18169-9/10369919_10205852284656901_3758308846855777465_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=09cbfe&_nc_eui2=AeHXg3gIfzvj9_l4iBl8SLesIfISfImaQ4wh8hJ8iZpDjDUP6VOlaP6uDj-jbKJHKW4&_nc_ohc=Fn3L3w40yiMAX-_-Qq0&_nc_ht=scontent.fasu6-1.fna&oh=12312961fd1ad69b2fc8547380f6ed17&oe=60BA2378"
            ),
            Post(
                "https://scontent.fasu6-1.fna.fbcdn.net/v/t1.6435-9/51569574_10218050080434172_8158649644176375808_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=174925&_nc_eui2=AeH4-aNtlyPpqa113U7ud5orA9hxGIhIpRAD2HEYiEilEKXaxGuAh7OZHZHwA6WOXdo&_nc_ohc=Py534_ato_sAX_lPKAM&_nc_ht=scontent.fasu6-1.fna&oh=dd0723f8258874a271f1b36694df9aa7&oe=60BA5A69",
                "Ruben Yebran",
                Timestamp.now(),
                "https://scontent.fasu6-1.fna.fbcdn.net/v/t1.18169-9/10369919_10205852284656901_3758308846855777465_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=09cbfe&_nc_eui2=AeHXg3gIfzvj9_l4iBl8SLesIfISfImaQ4wh8hJ8iZpDjDUP6VOlaP6uDj-jbKJHKW4&_nc_ohc=Fn3L3w40yiMAX-_-Qq0&_nc_ht=scontent.fasu6-1.fna&oh=12312961fd1ad69b2fc8547380f6ed17&oe=60BA2378"
            )
        )
        binding.rvHome.adapter = HomeScreenAdapter(postList)
    }

}