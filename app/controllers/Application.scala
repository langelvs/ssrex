package controllers

import play.api.mvc.{ Action, Controller }
import plugins.scalate._

object Application extends Controller {
  
  def index = Action {
    Ok("Prueba de templates").as("text/html")
  }

  def frag = Action {
    Ok(fragment("/views/jade/fragment.jade"))
  }

  def jade = Action {
    Ok(template("/views/jade/index.jade"))
  }
  
  def scaml = Action {
    Ok(template("/views/scaml/index.scaml"))
  }
  
}