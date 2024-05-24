import java.awt.Desktop
import java.net.URI

def openEksciForService(service: String): Unit = {
  val uri = new URI(s"https://eksci.infraprd.oasvc.itv.com/job/services/job/$service/job/code/job/oasvc-$service/")
  if (Desktop.isDesktopSupported && Desktop.getDesktop.isSupported(Desktop.Action.BROWSE)) {
    Desktop.getDesktop.browse(uri)
  } else {
    println("Opening the default web browser is not supported on this platform.")
  }
}

//openEksciForService("octopus")


def openTerraformForService(service: String): Unit = {
  val uri = new URI(s"https://eksci.infraprd.oasvc.itv.com/job/services/job/$service/job/infra/job/terraform/job/$service-tf-pipeline/")
  if (Desktop.isDesktopSupported && Desktop.getDesktop.isSupported(Desktop.Action.BROWSE)) {
    Desktop.getDesktop.browse(uri)
  } else {
    println("Opening the default web browser is not supported on this platform.")
  }
}

openEksciForService("octopus")