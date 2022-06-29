package com.apps.fullandroidcourseclassc.todolistapiapp.service

import com.apps.fullandroidcourseclassc.todolistapiapp.model.TodoListApiData
import retrofit2.Response
import retrofit2.http.GET

interface TodoListApi {

    @GET("/todos")
   suspend fun getTodos() : Response<List<TodoListApiData>>

}