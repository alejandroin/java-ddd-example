package tv.codely.mooc.notification.infrastructure.twitter

import tv.codely.mooc.notification.domain.TwitterPublisher
import twitter4j.TwitterFactory

class Twitter4JPublisher : TwitterPublisher {
    override fun addTweet(tweet: String) {
        val singleton = TwitterFactory.getSingleton()

        singleton.updateStatus(tweet)

        // send some kind of notification?
    }
}