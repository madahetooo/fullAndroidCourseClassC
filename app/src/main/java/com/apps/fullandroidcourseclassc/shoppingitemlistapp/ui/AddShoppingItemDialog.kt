package com.apps.fullandroidcourseclassc.shoppingitemlistapp.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.apps.fullandroidcourseclassc.databinding.DialogAddShoppingItemBinding
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.model.ShoppingItem

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {
    private lateinit var binding: DialogAddShoppingItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnShoppingDialogAdd.setOnClickListener {
            var shoppingItemName = binding.etShoppingItemDialogName.text.toString()
            var shoppingItemAmount = binding.etShoppingItemDialogAmount.text.toString()

            if (shoppingItemName.isEmpty() || shoppingItemAmount.isEmpty()){
                Toast.makeText(context,"Please enter item name and amount",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

           var item = ShoppingItem(shoppingItemName,shoppingItemAmount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }



        binding.btnShoppingDialogCancel.setOnClickListener {
            cancel()
        }
    }
}