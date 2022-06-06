package com.example.ocscodingtestapp.presentaion.ui.games_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ocscodingtestapp.presentaion.components.GameList
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GameListFragment : Fragment() {

    private val viewModel: GameListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                SetGamesListView()
            }
        }
    }

    @Composable
    private fun SetGamesListView() {
        val loading = viewModel.loading.value
        val games = viewModel.games.value

        GameList(loading = loading, games =games,findNavController())

    }
}