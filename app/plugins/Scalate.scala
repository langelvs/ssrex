package plugins

import org.jsoup.Jsoup
import org.jsoup.nodes.Node
import play.api.mvc.Codec
import play.api.http.{ ContentTypeOf, Writeable }
import play.api.Play.current

object scalate {

  implicit def contentTypeOfNode(implicit codec: Codec): ContentTypeOf[Node] = {
    ContentTypeOf[Node](Some("text/html"))
  }

  implicit def writableNode[T <: Node](implicit codec: Codec): Writeable[T] = Writeable[T]((e : T) => codec.encode(e.outerHtml))

  def template(name: String) =
    Jsoup.parse(engine.layout(name))

  def fragment(name: String) =
    Jsoup.parseBodyFragment(engine.layout(name)).body.html
  
  private[this] val engine =
    current.plugin[ScalatePlugin].head.engine

}