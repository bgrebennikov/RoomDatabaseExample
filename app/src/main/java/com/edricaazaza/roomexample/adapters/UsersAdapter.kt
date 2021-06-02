package com.edricaazaza.roomexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edricaazaza.roomexample.databinding.UsersItemBinding
import com.edricaazaza.roomexample.db.UserModel

class UsersAdapter(
        private var usersList: List<UserModel>,
        private val onUserItemClickListener: (UserModel) -> Unit
): RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    class ViewHolder(val binding: UsersItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: UserModel){
            binding.idTxt.text = user.uid.toString()
            binding.txtFirstname.text = user.firstName
            binding.txtLastname.text = user.lastName

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = UsersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userRow = usersList[position]
        holder.bind(userRow)
        holder.itemView.setOnClickListener{
            onUserItemClickListener(userRow)
        }
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

}