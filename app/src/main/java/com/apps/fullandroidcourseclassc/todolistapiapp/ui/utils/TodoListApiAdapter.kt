package com.apps.fullandroidcourseclassc.todolistapiapp.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullandroidcourseclassc.databinding.ItemTodolistapiBinding
import com.apps.fullandroidcourseclassc.todolistapiapp.model.TodoListApiData

class TodoListApiAdapter :RecyclerView.Adapter<TodoListApiAdapter.TodoListApiViewHolder> (){

    inner class TodoListApiViewHolder(val binding: ItemTodolistapiBinding):RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object :DiffUtil.ItemCallback<TodoListApiData>(){
        override fun areItemsTheSame(oldItem: TodoListApiData, newItem: TodoListApiData): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: TodoListApiData, newItem: TodoListApiData): Boolean {
            return oldItem == newItem
        }
    }

    private val differ  = AsyncListDiffer(this,diffCallBack)
    var todos : List<TodoListApiData>
        get() = differ.currentList
        set(value) { differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListApiViewHolder {
        return TodoListApiViewHolder(ItemTodolistapiBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoListApiViewHolder, position: Int) {

        holder.binding.apply {
          val singleTodo =  todos[position]
            txTodoApiTitle.text = singleTodo.title
            cbTodoApiDone.isChecked = singleTodo.completed
        }


    }

    override fun getItemCount() = todos.size

}