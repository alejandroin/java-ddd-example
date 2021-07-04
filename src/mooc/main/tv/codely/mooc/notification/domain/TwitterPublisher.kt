package tv.codely.mooc.notification.domain

interface TwitterPublisher {

    fun addTweet(tweet: String)
}