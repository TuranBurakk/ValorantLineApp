package com.example.valorantlineapp.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.valorantlineapp.R
import com.example.valorantlineapp.base.BaseFragment
import com.example.valorantlineapp.data.entity.Agent
import com.example.valorantlineapp.databinding.FragmentLineUpBinding
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment
import com.google.android.youtube.player.YouTubePlayerView


class LineUpFragment(private val agent: Agent) : BaseFragment<FragmentLineUpBinding>(FragmentLineUpBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}