package com.codefresher.allinone.fragment.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codefresher.allinone.R
import com.codefresher.allinone.adapter.TrendingAdapter
import com.codefresher.allinone.adapter.UsersAdapter
import com.codefresher.allinone.databinding.FragmentFavoriteBinding
import com.codefresher.allinone.databinding.FragmentHomeBinding
import com.codefresher.allinone.model.Trending
import com.codefresher.allinone.model.Users
import com.google.firebase.database.*

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val tdList = ArrayList<Trending>()
    lateinit var tdAdapter: TrendingAdapter

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val reference: DatabaseReference = database.reference.child("Trending")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        getData()

        return binding.root
    }

    fun getData(){
        reference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                tdList.clear()
                for (eachTD in snapshot.children){
                    val td = eachTD.getValue(Trending::class.java)

                    if (td != null){
                        tdList.add(td )
                    }
                    tdAdapter = TrendingAdapter(requireContext(),tdList)
                    binding.recyclerView.adapter = tdAdapter

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
