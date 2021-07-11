package tv.codely.mooc.notification

import org.junit.jupiter.api.Test
import tv.codely.mooc.notification.infrastructure.publishers.twitter.Twitter4JPublisher

class Twitter4JPublisherShouldAddMessage {


    private val testSubject = Twitter4JPublisher()

    @Test
    fun shouldPublishTweetWhenAccountIsSetUp() {

        testSubject.addMessage("Ser malos colegas!")


    }
}