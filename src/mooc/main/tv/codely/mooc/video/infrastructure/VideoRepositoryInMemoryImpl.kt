package tv.codely.mooc.video.infrastructure

import arrow.core.Either
import tv.codely.mooc.video.domain.Video
import tv.codely.mooc.video.domain.VideoRepository
import tv.codely.mooc.video.domain.VideoTitle
import tv.codely.mooc.video.domain.exception.VideoNotFoundException
import java.util.*

class VideoRepositoryInMemoryImpl : VideoRepository {

    private var videoList = ArrayList<Video>()


    override fun save(video: Video) {
        videoList.add(video)
    }

    override fun getLastPublishedVideo() = videoList[videoList.size - 1]

    override fun findVideoByTitle(title: VideoTitle): Either<Throwable, Video> {
        videoList.forEach {
            if (it.title == title) return Either.Right(it)
        }
        return Either.Left(VideoNotFoundException("This video could not be found."))
    }
}