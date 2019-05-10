package com.aldana.ejemplo14

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var equipo = Equipos("0","0")

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main)
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        equipo.EquipoA = scoreViewModel.scoreTeamA.toString()
        equipo.EquipoB = scoreViewModel.scoreTeamB.toString()
        binding.team = equipo

        bt_reset.setOnClickListener {
            scoreViewModel.scoreTeamA = 0
            scoreViewModel.scoreTeamB = 0
            equipo.EquipoA = scoreViewModel.scoreTeamA.toString()
            equipo.EquipoB = scoreViewModel.scoreTeamB.toString()
            binding.team = equipo
        }
        bt_team_a_3_p.setOnClickListener {
            scoreViewModel.scoreTeamA += 3
            equipo.EquipoA = scoreViewModel.scoreTeamA.toString()
            binding.team = equipo
        }
        bt_team_a_2_p.setOnClickListener {
            scoreViewModel.scoreTeamA += 2
            equipo.EquipoA = scoreViewModel.scoreTeamA.toString()
            binding.team = equipo
        }

        bt_team_a_free_throw.setOnClickListener {
            scoreViewModel.scoreTeamA ++
            equipo.EquipoA = scoreViewModel.scoreTeamA.toString()
            binding.team = equipo
        }
        bt_team_b_3_p.setOnClickListener {
            scoreViewModel.scoreTeamB += 3
            equipo.EquipoB = scoreViewModel.scoreTeamB.toString()
            binding.team = equipo
        }
        bt_team_b_2_p.setOnClickListener {
            scoreViewModel.scoreTeamB += 2
            equipo.EquipoB = scoreViewModel.scoreTeamB.toString()
            binding.team = equipo
        }

        bt_team_b_free_throw.setOnClickListener {
            scoreViewModel.scoreTeamB ++
            equipo.EquipoB = scoreViewModel.scoreTeamB.toString()
            binding.team = equipo
        }

    }
}
