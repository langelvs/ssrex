package plugins

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import play.api.mvc.Codec
import play.api.http.{ ContentTypeOf, Writeable }
import play.api.Play.current

object scalate {

  implicit def contentTypeOfElement(implicit codec: Codec): ContentTypeOf[Element] = {
    ContentTypeOf[Element](Some("text/html"))
  }

  implicit def writableElement[T <: Element](implicit codec: Codec): Writeable[T] = Writeable[T]((e : T) => codec.encode(e.html))

  def template(name: String) =
    Jsoup.parse(engine.layout(name))

  def fragment(name: String) =
    Jsoup.parseBodyFragment(engine.layout(name)).body
  
  private[this] val engine =
    current.plugin[ScalatePlugin].head.engine

}