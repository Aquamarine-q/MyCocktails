package com.example.mycocktails.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mycocktails.MyCocktailsApplication
import com.example.mycocktails.R
import com.example.mycocktails.databinding.FragmentNewCocktailBinding
import com.example.mycocktails.presentation.viewmodel.NewCocktailViewModel
import com.example.mycocktails.utils.viewmodel.ViewModelFactory
import javax.inject.Inject

class NewCocktailFragment : Fragment() {
    private var _binding: FragmentNewCocktailBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var viewModel: NewCocktailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewCocktailBinding.inflate(inflater, container, false)
        inject()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[NewCocktailViewModel::class.java]
        viewModel.viewState.observe(viewLifecycleOwner) { model -> renderModel(model) }
        viewModel.singleEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_newCocktailFragment_to_myCocktailsFragment)
        }
        setUpListeners()
    }

    private fun renderModel(model: Boolean) {
        with(binding) {
            titleLayout.error = if (model) {
                getString(R.string.add_title)
            } else {
                null
            }
        }
    }

    private fun setUpListeners() {
        with(binding) {
            saveButton.setOnClickListener {
                viewModel.onEditButtonClicked(
                    title = title.text.toString(),
                    description = description.text.toString(),
                    recipe = recipe.text.toString(),
                )
            }

            cancelButton.setOnClickListener {
                findNavController().navigate(R.id.action_newCocktailFragment_to_myCocktailsFragment)
            }
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