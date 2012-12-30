package controllers

import play.api.mvc.{ Action, Controller }
import plugins.Scalate.engine

object Application extends Controller {
  
  def index = Action {
    Ok(engine.layout("/views/scaml/index.scaml")).as("text/html")
  }
  
}