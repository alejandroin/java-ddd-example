package tv.codely.mooc.notification.domain

interface MessagePublisher {

    fun addMessage(message: String)
}