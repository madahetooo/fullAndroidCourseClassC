package com.apps.fullandroidcourseclassc.shoppingitemlistapp.repository

import com.apps.fullandroidcourseclassc.shoppingitemlistapp.db.ShoppingDatabase
import com.apps.fullandroidcourseclassc.shoppingitemlistapp.model.ShoppingItem

class ShoppingRepository(private val db:ShoppingDatabase) {

    fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    fun delete (item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItem()

}