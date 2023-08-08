package com.example.mycocktails.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.mycocktails.MyCocktailsApplication
import com.example.mycocktails.R
import com.example.mycocktails.databinding.FragmentMyCocktailsBinding
import com.example.mycocktails.presentation.viewState.MyCocktailsViewState
import com.example.mycocktails.presentation.viewmodel.MyCocktailsViewModel
import com.example.mycocktails.utils.adapter.CocktailAdapter
import com.example.mycocktails.utils.viewmodel.ViewModelFactory
import javax.inject.Inject

class MyCocktailsFragment : Fragment() {
    private var _binding: FragmentMyCocktailsBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var factory: ViewModelFactory
    private lateinit var viewModel: MyCocktailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyCocktailsBinding.inflate(inflater, container, false)
        inject()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[MyCocktailsViewModel::class.java]
        viewModel.viewState.observe(viewLifecycleOwner) { model -> renderModel(model) }
        viewModel.onScreenOpened()
        setUpListener()
    }

    private fun renderModel(model: MyCocktailsViewState) {
        with(binding) {
            splashScreen.splashScreen.isVisible = model.isLoading

            val allCocktails = model.cocktails
            val cocktailAdapter = CocktailAdapter(allCocktails)
            cocktails.adapter = cocktailAdapter
            cocktailAdapter.setOnItemClickListener(object : CocktailAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val navHostFragment = requireActivity()
                        .supportFragmentManager
                        .findFragmentById(R.id.fragment_container) as NavHostFragment
                    val navController = navHostFragment.navController
                    val bundle = bundleOf("cocktail" to allCocktails[position])
                    navController.navigate(
                        R.id.action_myCocktailsFragment_to_detailCocktailFragment,
                        bundle
                    )
                }
            })
        }
    }

    private fun setUpListener() {
        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_myCocktailsFragment_to_newCocktailFragment)
        }
    }

    fun inject() {
        MyCocktailsApplication.appComponent.inject(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}