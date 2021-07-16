package tv.codely.mooc.video.application.update

import arrow.core.Either
import io.mockk.*
import org.junit.jupiter.api.Test
import tv.codely.mooc.video.domain.Video
import tv.codely.mooc.video.domain.VideoRepository
import tv.codely.mooc.video.domain.VideoTitle

class VideoUpdaterShouldUpdateName {

    @Test
    fun test() {
        val mockRepository = mockk<VideoRepository>()
        val videoUpdater = VideoUpdater(mockRepository)

        val mockVideo = mockk<Video>()
        val videoTitle = VideoTitle("Video1")
        val newTitle = VideoTitle("Updated name")

        every {
            mockRepository.findVideoByTitle(videoTitle)
        }.returns(Either.Right(mockVideo))

        every {
            mockVideo.updateTitle(newTitle)
        } just runs

        videoUpdater.updateVideoName(videoTitle, newTitle)

        verify { mockVideo.updateTitle(newTitle) }
    }
}