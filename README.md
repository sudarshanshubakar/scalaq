# scalaq

A simple queue implementation in scala. This is mainly aimed at learning scala.


- As a user I should be able to send a message to a new topic. This will create the topic and add the message to it.
- As a user I should be able to subscribe to a topic. Once subscribed I should be able to receive any new messages sent to the topic. Messages to be deleted from the topic after a default timeout.
- As an admin I should be able to set configuration parameters that control the queue.
- The queue shoudl persist messages to storage and should recover after outages.
- As a user I should be able to query the state of a topic.
