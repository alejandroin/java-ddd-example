package tv.codely.mooc.video.domain

import arrow.core.Either

interface VideoRepository {

    fun save(video: Video)

    fun getLastPublishedVideo(): Video
    fun findVideoByTitle(title: VideoTitle): Either<Throwable, Video>
}