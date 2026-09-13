package com.example.util

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import java.util.Locale

/**
 * Encapsulates Android's native TextToSpeech engine with safe initialization,
 * lifecycle management, locale fallback, and main-thread speech state synchronization.
 */
class IChingTextToSpeechHelper(
    context: Context,
    private val onSpeakingStateChanged: (Boolean) -> Unit
) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var isInitialized = false
    private var pendingText: String? = null
    private val mainHandler = Handler(Looper.getMainLooper())

    init {
        try {
            tts = TextToSpeech(context.applicationContext, this)
        } catch (e: Exception) {
            Log.e("IChingTTS", "Failed to initialize TextToSpeech engine", e)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val engine = tts
            if (engine != null) {
                try {
                    val defaultLocale = Locale.getDefault()
                    val langResult = engine.setLanguage(defaultLocale)
                    if (langResult == TextToSpeech.LANG_MISSING_DATA || langResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                        engine.setLanguage(Locale.US)
                    }
                } catch (e: Exception) {
                    Log.w("IChingTTS", "Error configuring TTS language, using default", e)
                }

                engine.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {
                        mainHandler.post { onSpeakingStateChanged(true) }
                    }

                    override fun onDone(utteranceId: String?) {
                        mainHandler.post { onSpeakingStateChanged(false) }
                    }

                    override fun onError(utteranceId: String?) {
                        mainHandler.post { onSpeakingStateChanged(false) }
                    }

                    @Deprecated("Deprecated in Java")
                    override fun onError(utteranceId: String?, errorCode: Int) {
                        mainHandler.post { onSpeakingStateChanged(false) }
                    }
                })

                isInitialized = true

                // If user requested speech before init completed, speak now
                pendingText?.let { text ->
                    pendingText = null
                    speak(text)
                }
            }
        } else {
            Log.w("IChingTTS", "TextToSpeech initialization returned status: $status")
            isInitialized = false
        }
    }

    fun speak(text: String) {
        if (!isInitialized) {
            pendingText = text
            return
        }
        val engine = tts ?: return
        val utteranceId = "iching_reading_${System.currentTimeMillis()}"
        val params = Bundle().apply {
            putInt(TextToSpeech.Engine.KEY_PARAM_STREAM, AudioManager.STREAM_MUSIC)
        }
        try {
            val result = engine.speak(text, TextToSpeech.QUEUE_FLUSH, params, utteranceId)
            if (result == TextToSpeech.SUCCESS) {
                mainHandler.post { onSpeakingStateChanged(true) }
            }
        } catch (e: Exception) {
            Log.e("IChingTTS", "Error during TextToSpeech speak", e)
            mainHandler.post { onSpeakingStateChanged(false) }
        }
    }

    fun stop() {
        pendingText = null
        try {
            tts?.stop()
        } catch (e: Exception) {
            Log.e("IChingTTS", "Error stopping TextToSpeech", e)
        } finally {
            mainHandler.post { onSpeakingStateChanged(false) }
        }
    }

    fun shutdown() {
        stop()
        try {
            tts?.shutdown()
            tts = null
            isInitialized = false
        } catch (e: Exception) {
            Log.e("IChingTTS", "Error shutting down TextToSpeech", e)
        }
    }
}
