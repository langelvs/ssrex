package plugins

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import play.api.mvc.Codec
import play.api.http.{ ContentTypeOf, Writeable }
import play.api.Play.current

object scalate {

  implicit def Document(implicit codec: Codec): ContentTypeOf[Document] = {
    ContentTypeOf[Document](Some("text/html"))
  }

  implicit def wDocument(implicit codec: Codec): Writeable[Document] = Writeable[Document]((doc: Document) => codec.encode(doc.outerHtml()))

  def template(name: String) = {
    Jsoup.parse(engine.layout(name))
  }

  private[this] val engine =
    current.plugin[ScalatePlugin].head.engine

}