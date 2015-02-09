import akka.actor._
import akka.event.LoggingReceive

/**
 * Saves key/value pairs to persistent storage when receiving `Store` message.
 * Replies with current value when receiving `Get` message.
 * Will throw StorageException if the underlying data store is out of order.
 */
class Storage extends Actor {

  import Storage._

  val db = DummyDB

  def receive = LoggingReceive {
    case Store(Entry(key, count)) => db.save(key, count)
    case Get(key) => sender() ! Entry(key, db.load(key).getOrElse(0L))
  }
}

object Storage {

  final case class Store(entry: Entry)

  final case class Get(key: String)

  final case class Entry(key: String, value: Long)

  class StorageException(msg: String) extends RuntimeException(msg)

}