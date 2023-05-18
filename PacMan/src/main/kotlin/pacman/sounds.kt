@file:Suppress("unused")

package pacman

import pt.isel.canvas.Canvas
import java.io.BufferedInputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip

private val sounds = mutableMapOf<String, Clip?>()

/**
 * Loads the clip with the given name and returns it.
 */
private fun loadClip(fileName: String): Clip? {
    return try {
        val audio = AudioSystem.getAudioInputStream(BufferedInputStream(getInputStream(fileName)))
        AudioSystem.getClip().also { it.open(audio) }
    } catch (ex: Exception) {
        null
    }
}

/**
 * Loads all the clips with the given names and stores them in the [sounds] map.
 */
fun loadClips(vararg names: String) {
    names.forEach {
        sounds[it] = loadClip(it.toSoundName())
    }
}

private fun String.toSoundName() = if (lastIndexOf('.')> 0) this else "$this.wav"

/**
 * Plays the sound with the given name exactly once. If the sound is already playing, it is stopped and restarted.
 */
fun playSoundOnce(sound: String) {
    val fileName = sound.toSoundName()
    val clip =
        if (!sounds.contains(fileName)) loadClip(fileName).also { sounds[fileName] = it }
        else sounds[fileName]

    if (clip != null) {
        clip.stop()
        clip.framePosition = 0
        clip.start()
    }
}

/**
 * Plays the sound with the given name in a loop. If the sound is already playing, it is stopped and restarted.
 */
fun playSoundLoop(sound: String) {

    val fileName = sound.toSoundName()
    val clip =
        if (!sounds.contains(fileName)) loadClip(fileName).also { sounds[fileName] = it }
        else sounds[fileName]

    if (clip != null) {
        clip.stop()
        clip.framePosition = 0
        clip.loop(Clip.LOOP_CONTINUOUSLY)
    }
}

/**
 * Stops the sound with the given name.
 */
fun stopSoundLoop(sound: String) {
    sounds[sound.toSoundName()]?.stop()
}

/**
 * Stops all the sounds.
 */
fun stopsAllSounds() {
    sounds.values.forEach { it?.stop() }
}

private fun getInputStream(fileName: String): InputStream {
    val file = File(fileName)
    return if (file.canRead()) file.inputStream() else Canvas::class.java.getResourceAsStream("/$fileName")
        ?: throw FileNotFoundException("Cant open $fileName in working directory or in resources")
}
