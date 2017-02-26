package org.scalaq

import scala.collection.mutable.{ArrayBuffer,Map}

/**
  * Created by sudarshan on 2/23/2017.
  */
class Topic {
  def contains(topicName: String): Boolean = {
    if(topicBufferMap.contains(topicName)) {
      return true
    } else {
      return false
    }
  }

  private val topicBufferMap = Map[String, ArrayBuffer[String]]().withDefaultValue(ArrayBuffer.empty[String])
  private val topicSubscriberMap = Map[String, ArrayBuffer[Subscriber]]().withDefaultValue(ArrayBuffer.empty[Subscriber])
  private val subscribers = ArrayBuffer.empty[Any]

  class Subscriber(val timestamp: Long, var callback: (String) => Unit)  {
  }

  def subscribe(topicName: String, callback: (String) => Unit) = {
    val subscriber = new Subscriber(System.currentTimeMillis(), callback)
    var subscribers = topicSubscriberMap(topicName)
    subscribers += subscriber
    topicSubscriberMap += (topicName -> subscribers)
  }

  def publish(topicName: String, message: String) = {
    var topicBuffer = topicBufferMap(topicName)
    topicBuffer += message
    topicBufferMap += (topicName -> topicBuffer)
    var subscribers = topicSubscriberMap(topicName)
    subscribers.foreach {subscriber =>
      subscriber.callback(message)
    }
  }

}
