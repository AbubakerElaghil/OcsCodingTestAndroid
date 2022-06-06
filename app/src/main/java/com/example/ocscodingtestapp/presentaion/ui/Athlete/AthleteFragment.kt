package com.example.ocscodingtestapp.presentaion.ui.Athlete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ocscodingtestapp.presentaion.components.AthleteView
import com.example.ocscodingtestapp.presentaion.components.CircularProgressBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AthleteFragment : Fragment() {

    private val viewModel: AthleteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("athleteId")?.let {
            viewModel.getAthleteDetails(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                SetAthleteDetailView()
            }
        }
    }

    @Preview
    @Composable
    private fun SetAthleteDetailView() {
        val loading = viewModel.loading.value
        val athlete = viewModel.athlete.value
        CircularProgressBar(isLoading = loading)
        athlete?.let {
            AthleteView(  athlete = it,findNavController())
        }

    }
}