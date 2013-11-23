package com.airbnb.scheduler.api

import mesosphere.chaos.http.MustacheServlet
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import scala.collection.JavaConverters._
import com.google.inject.Inject
import com.airbnb.scheduler.config.SchedulerConfiguration

/**
 * @author Florian Leibert (flo@leibert.de)
 */
class IndexPageServlet @Inject()(conf: SchedulerConfiguration)
  extends MustacheServlet("index.mustache") {

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    writeTemplate(resp, Map("jobOwner" -> conf.defaultJobOwner()).asJava)
  }
}


