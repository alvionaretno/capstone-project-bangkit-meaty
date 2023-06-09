package com.damar.meaty.profil

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.damar.meaty.R
import com.damar.meaty.login.LoginActivity
import com.damar.meaty.setting.SettingActivity

class ProfilFragment : Fragment() {
    private lateinit var profilViewModel: ProfilViewModel
    private lateinit var myNameTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }
}