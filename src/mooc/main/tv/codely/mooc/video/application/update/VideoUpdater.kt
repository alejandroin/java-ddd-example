package tv.codely.mooc.video.application.update

import tv.codely.mooc.video.domain.VideoRepository
import tv.codely.mooc.video.domain.VideoTitle

class VideoUpdater(private val videoRepository: VideoRepository) {
    fun updateVideoName(title: VideoTitle, newTitle: VideoTitle) {

        videoRepository.findVideoByTitle(title).fold(
                { throw it },
                { it.updateTitle(newTitle) }
        )
    }
}