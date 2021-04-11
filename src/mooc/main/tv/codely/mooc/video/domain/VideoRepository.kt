package tv.codely.mooc.video.domain

interface VideoRepository {

    fun save(video: Video)

    fun getLastPublishedVideo(): Video
}