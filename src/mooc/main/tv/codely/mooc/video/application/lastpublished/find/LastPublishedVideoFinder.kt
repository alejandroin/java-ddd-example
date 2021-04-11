package tv.codely.mooc.video.application.lastpublished.find

import tv.codely.mooc.video.domain.VideoRepository

class LastPublishedVideoFinder constructor(private val videoRepository: VideoRepository) {

    // how to treat exceptions here??
    fun getLastPublishedVideo() = videoRepository.getLastPublishedVideo()
}