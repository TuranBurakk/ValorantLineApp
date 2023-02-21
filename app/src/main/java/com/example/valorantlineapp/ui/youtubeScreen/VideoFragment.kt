package com.example.valorantlineapp.ui.youtubeScreen

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.valorantlineapp.base.BaseFragment
import com.example.valorantlineapp.databinding.FragmentVideoBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment : BaseFragment<FragmentVideoBinding>(FragmentVideoBinding::inflate) {

    private val db by lazy { FirebaseFirestore.getInstance() }
    private val args by navArgs<VideoFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(binding.youtubePlayer)
        binding.btnBack.setOnClickListener {
            findNavController().navigate(VideoFragmentDirections.actionVideoFragmentToTabControllerFragment(args.agentname))

        }

        binding.youtubePlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                if (args.map == "The Range"){
                    db.collection("1").document(args.map).get().addOnSuccessListener {
                        youTubePlayer.loadVideo(it.get("url").toString(),0f)
                    }
                }
                else{
                    db.collection(args.agentname.uuid!!).document(args.map).get().addOnSuccessListener {
                        youTubePlayer.loadVideo( it.get("url").toString(),0f)
                    }
                }
            }
        })
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                 if (isEnabled){
                     findNavController().navigate(VideoFragmentDirections.actionVideoFragmentToTabControllerFragment(args.agentname))
                 }
                }
            })
    }
}