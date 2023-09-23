package com.roshan.actuantcamera

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.acuant.acuantcamera.camera.AcuantCameraActivity
import com.acuant.acuantcamera.camera.AcuantCameraOptions
import com.acuant.acuantcamera.constant.ACUANT_EXTRA_CAMERA_OPTIONS
import com.acuant.acuantcamera.initializer.MrzCameraInitializer
import com.acuant.acuantcommon.exception.AcuantException
import com.acuant.acuantcommon.initializer.AcuantInitializer
import com.acuant.acuantcommon.initializer.IAcuantPackageCallback
import com.acuant.acuantcommon.model.AcuantError
import com.roshan.actuantcamera.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.buttonFirst.setOnClickListener {
            startCamera()
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listener = object : IAcuantPackageCallback {
            override fun onInitializeFailed(error: List<AcuantError>) {

            }

            override fun onInitializeSuccess() {

            }
        }
        try {
            AcuantInitializer.initializeWithToken(
                "PATH/TO/CONFIG/FILENAME.XML",
                "token",
                requireContext(),
                listOf(MrzCameraInitializer()),
                listener
            )
        } catch (e: AcuantException) {
            Log.e("Acuant Error", e.toString())
        }
    }

    private fun startCamera() {
        val cameraIntent = Intent(
            requireContext(),
            AcuantCameraActivity::class.java
        )
        cameraIntent.putExtra(
            ACUANT_EXTRA_CAMERA_OPTIONS,
            AcuantCameraOptions
                .DocumentCameraOptionsBuilder()
                .setAutoCapture(false)
                .build()
        )
        startActivityForResult(cameraIntent, 1001)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}