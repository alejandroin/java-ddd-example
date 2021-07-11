package tv.codely.mooc.video.application.update

import tv.codely.mooc.video.domain.VideoRepository
import tv.codely.mooc.video.domain.VideoTitle

class VideoUpdater(private val videoRepository: VideoRepository) {


    fun updateVideoName(title: String) {

        videoRepository.findVideoByTitle(title).fold(
                { throw IllegalArgumentException("asdf") },
                { it.updateTitle(VideoTitle(title)) }
        )


    }
}