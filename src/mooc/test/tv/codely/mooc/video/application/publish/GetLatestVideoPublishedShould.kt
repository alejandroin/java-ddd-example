package tv.codely.mooc.video.application.publish

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import tv.codely.mooc.video.application.lastpublished.find.LastPublishedVideoFinder
import tv.codely.mooc.video.domain.Video
import tv.codely.mooc.video.domain.VideoDescription
import tv.codely.mooc.video.domain.VideoTitle
import tv.codely.mooc.video.infrastructure.VideoRepositoryInMemoryImpl

class GetLatestVideoPublishedShould {

    @Test
    fun shouldGetLatestVideoPublished() {
        // GIVEN
        val videoRepositoryInMemoryImpl = VideoRepositoryInMemoryImpl()
        val lastPublishedVideoFinder = LastPublishedVideoFinder(videoRepositoryInMemoryImpl)
        val firstVideoPublished: Video = Video.publish(VideoTitle("First Video"), VideoDescription("Description"))
        val latestVideoPublished: Video = Video.publish(VideoTitle("Latest Video"), VideoDescription("Description"))

        videoRepositoryInMemoryImpl.save(firstVideoPublished)
        videoRepositoryInMemoryImpl.save(latestVideoPublished)

        // WHEN
        val lastPublishedVideo = lastPublishedVideoFinder.getLastPublishedVideo()

        // THEN
        assertEquals(lastPublishedVideo, lastPublishedVideo)

    }


}