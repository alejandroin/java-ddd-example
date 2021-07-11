package tv.codely.mooc.notification.infrastructure.publishers.twitter

import tv.codely.mooc.notification.domain.MessagePublisher
import twitter4j.TwitterFactory

class Twitter4JPublisher : MessagePublisher {
    override fun addMessage(message: String) {
        val singleton = TwitterFactory.getSingleton()

        singleton.updateStatus(message)

        // send some kind of notification?
    }
}