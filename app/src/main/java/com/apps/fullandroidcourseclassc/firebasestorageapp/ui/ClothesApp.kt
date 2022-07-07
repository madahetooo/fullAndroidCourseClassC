package com.apps.fullandroidcourseclassc.firebasestorageapp.ui

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.fullandroidcourseclassc.databinding.ActivityClothesAppBinding
import com.apps.fullandroidcourseclassc.firebasestorageapp.utils.ClothesImagesAdapter
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

private const val REQUEST_CODE_IMAGE_PICK = 0

@Suppress("DEPRECATION")
class ClothesApp : AppCompatActivity() {
    var currentImage: Uri? = null
    val imageReference = Firebase.storage.reference
    private lateinit var binding: ActivityClothesAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClothesAppBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ivClothesImage.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            }
        }
        binding.btnUploadImage.setOnClickListener {
            uploadImageToStorage("myImage")
        }
        binding.btnDownloadImage.setOnClickListener {
            downloadImageFromStorage("myImage")
        }
        binding.btnDeleteImage.setOnClickListener {
            deleteImageFromStorage("myImage")
        }
        listAllImagesFromStorage()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            data?.data.let {
                currentImage = it
                binding.ivClothesImage.setImageURI(it)
            }
        }

    }
    //UPLOAD IMAGE TO STORAGE
    private fun uploadImageToStorage(fileName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                currentImage?.let {
                    imageReference.child("images/$fileName").putFile(it).await()
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@ClothesApp,
                            "Image Uploaded Successfully",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ClothesApp, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    //DOWNLOAD IMAGE FROM STORAGE
    private fun downloadImageFromStorage(fileName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val maxDownloadSizeByte = 5L * 1024 * 1024
                val imageByte =
                    imageReference.child("images/$fileName").getBytes(maxDownloadSizeByte).await()
                val imageBitMap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.size)
                withContext(Dispatchers.Main) {
                    binding.ivClothesImage.setImageBitmap(imageBitMap)
                    Toast.makeText(
                        this@ClothesApp,
                        "Download Image Successfully",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ClothesApp, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    //DELETE IMAGE FROm STORAGE
    private fun deleteImageFromStorage(fileName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                imageReference.child("images/$fileName").delete().await()
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ClothesApp, "Image Deleted Successfully", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ClothesApp, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    //GET ALL ITEMS ON RECYCLERVIEW
    private fun listAllImagesFromStorage() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val allImages = imageReference.child("images/").listAll().await()
                val imagesUrls = mutableListOf<String>()
                for (singleImage in allImages.items){
                    val singleImageUrl = singleImage.downloadUrl.await()
                    imagesUrls.add(singleImageUrl.toString())
                }
                withContext(Dispatchers.Main){
                    val clothesImagesAdapter = ClothesImagesAdapter(imagesUrls)
                    binding.rvClothesImages.apply {
                        adapter = clothesImagesAdapter
                        layoutManager = LinearLayoutManager(this@ClothesApp)
                    }
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ClothesApp, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}