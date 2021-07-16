package tv.codely.mooc.video.application.infrastructure

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import tv.codely.mooc.video.domain.Video
import tv.codely.mooc.video.domain.VideoDescription
import tv.codely.mooc.video.domain.VideoTitle
import tv.codely.mooc.video.domain.exception.VideoNotFoundException
import tv.codely.mooc.video.infrastructure.VideoRepositoryInMemoryImpl

class VideoRepositoryInMemoryImplTest {

    @Test
    fun wheneverVideoDoesNotExistInRepo_exceptionIsOfClassVideoNotFound() {

        val testSubject = VideoRepositoryInMemoryImpl()
        val videoTitle = VideoTitle("fail")

        testSubject.findVideoByTitle(videoTitle).fold(
                { assertThat(it).isInstanceOf(VideoNotFoundException::class.java) },
                { fail("Something went terribly wrong here") }
        )
    }

    @Test
    fun wheneverVideoExistsInRepo_videoIsReturned() {

        val testSubject = VideoRepositoryInMemoryImpl()
        val videoTitle = VideoTitle("fail")
        testSubject.save(Video.publish(videoTitle, VideoDescription("whatever")))

        testSubject.findVideoByTitle(videoTitle).fold(
                { fail("Something went terribly wrong here") },
                { assertThat(it.title).isEqualTo(videoTitle) },
        )
    }
}