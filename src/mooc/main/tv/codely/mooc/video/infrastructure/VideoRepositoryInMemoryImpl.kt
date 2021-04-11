package tv.codely.mooc.video.infrastructure

import tv.codely.mooc.video.domain.Video
import tv.codely.mooc.video.domain.VideoRepository
import java.util.*

class VideoRepositoryInMemoryImpl : VideoRepository {

    private var videoList = ArrayList<Video>()


    override fun save(video: Video) {
        videoList.add(video)
    }

    override fun getLastPublishedVideo() = videoList[videoList.size - 1]
}