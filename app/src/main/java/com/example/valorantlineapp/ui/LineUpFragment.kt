package com.example.valorantlineapp.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.get
import androidx.fragment.app.FragmentTransaction
import com.example.valorantlineapp.base.BaseFragment
import com.example.valorantlineapp.data.entity.Agent
import com.example.valorantlineapp.databinding.FragmentLineUpBinding
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
import com.google.android.youtube.player.YouTubePlayerFragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener


class LineUpFragment(private val agent: Agent) : BaseFragment<FragmentLineUpBinding>(FragmentLineUpBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(binding.videoView)
        var videoId : String = ""
        binding.videoView.toggleFullScreen()
        binding.videoView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                when(agent.name){
                    "Fade" -> videoId = "YTEbBGQMD0Y"
                    "Raze" -> videoId = "XfKhkcIu28g"
                    "Chamber" -> videoId = "9oUMQ5az9Pg"
                    "KAY/O" -> videoId = "pJKjcCuR0Ok"
                    "Skye" -> videoId = "YplGXDQbUOQ"
                    "Sova" -> videoId = "lR8TxCvqQL8"
                    "Killjoy" -> videoId = "8bXAmdx_0cg"
                    "Harbor" -> videoId = "vkasGfs3IGI"
                    "Viper" -> videoId = "SVAlz63IUx8"
                    "Phoenix" -> videoId = "lWjFelKps4w"
                    "Astra" -> videoId = "M5xlSZ2dT4Y"
                    "Brimstone" -> videoId = "3ygHQuRCEjk"
                    "Neon" -> videoId = "d1ErdgTpq9A"
                    "Yoru" -> videoId = "bI09HGoSb84"
                    "Sage" -> videoId = "-AA6BpD0nBs"
                    "Reyna" -> videoId = "HYaxIHwoIUI"
                    "Omen" -> videoId = "sr9utDvA0qU"
                    "Jett" -> videoId = "HGUMd2HQFaA"
                }
                youTubePlayer.loadVideo(videoId,0f)


            }
        })

    }

}