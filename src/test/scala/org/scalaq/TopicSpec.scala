package org.scalaq

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sudarshan on 2/23/2017.
  */
class TopicSpec extends FlatSpec with Matchers {

  def fixture = new {
    val topic = new Topic()
    val topicName = "test"
  }

  "The Topic object" should "create a new topic when sent a message for the first time." in {
    val fix = fixture
    val topic = fix.topic
    var topicName = fix.topicName
    val message = "message"
    topic.publish(topicName, message)
    topic.contains(topicName) shouldEqual true

    topicName = topicName + "1"
    topic.publish(topicName, message )
    topic.contains(topicName) shouldEqual true

  }

  "The Topic object" should "allow a client to subscribe and specify a callback and the callback should be called when a message is published" in {
    val topic = fixture.topic
    topic.subscribe(fixture.topicName, (message: String) => {
      message shouldEqual "testMessage"
    })
    topic.publish(fixture.topicName, "testMessage")
  }


}
