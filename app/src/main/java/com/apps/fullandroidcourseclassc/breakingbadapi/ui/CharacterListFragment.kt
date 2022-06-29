package com.apps.fullandroidcourseclassc.breakingbadapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.apps.fullandroidcourseclassc.R
import com.apps.fullandroidcourseclassc.breakingbadapi.BreakingBadApplication
import com.apps.fullandroidcourseclassc.breakingbadapi.ui.utils.CharacterListAdapter

@Suppress("DEPRECATION")
class CharacterListFragment : Fragment() {

    private val characterListViewModel: CharacterListViewModel by viewModels {
        CharacterListViewModelFactory((requireActivity().application as BreakingBadApplication).characterRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }

    @Deprecated(
        "Deprecated in Java", ReplaceWith(
            "super.onActivityCreated(savedInstanceState)",
            "androidx.fragment.app.Fragment"
        )
    )
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val rvCharacterList = requireActivity().findViewById<RecyclerView>(R.id.rvCharacterList)
        val characterListAdapter = CharacterListAdapter { breakingbadCharacter ->
            if (breakingbadCharacter.img != null) {
                findNavController().navigate(
                    CharacterListFragmentDirections.showCharacterImageFragment(
                        breakingbadCharacter.img
                    )
                )
            }
        }
        rvCharacterList.adapter = characterListAdapter
        characterListViewModel.characterList.observe(viewLifecycleOwner, { breakingBadCharacter ->
            characterListAdapter.submitList(breakingBadCharacter)
        })


        val refreshLayout = requireActivity().findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        refreshLayout.setOnRefreshListener {
            characterListViewModel.refreshDataFromRepository() // Refresh Data
            Toast.makeText(requireContext(), " Data Updated ", Toast.LENGTH_LONG).show()
            refreshLayout.isRefreshing = false
        }
    }
}