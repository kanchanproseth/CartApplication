package com.cs473.mda.cartapplication.factory

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.core.graphics.drawable.toBitmap
import java.io.ByteArrayOutputStream


class ImageFactory {
    companion object {
        fun bitmapFromResource(context: Context, id: Int): Bitmap? {
            return BitmapFactory.decodeResource(context.resources,
            id);
        }

        fun bitmapFromFile(context: Context, resourceId: Int): Bitmap? {
            return context.resources.getDrawable(resourceId).toBitmap()
        }


        fun compressBitmap(bitmap: Bitmap, quality: Int): Bitmap {

            val stream = ByteArrayOutputStream()

            bitmap.compress(Bitmap.CompressFormat.WEBP,quality,stream)

            val byteArray = stream.toByteArray()

            var arrayByte = byteArray

            return BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)

        }
    }
}