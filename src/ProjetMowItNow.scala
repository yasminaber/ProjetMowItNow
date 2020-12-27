import java.io.{File, PrintWriter}

import scala.io.Source
object ProjetMowItNow {

  def main(args: Array[String]): Unit = {

    // on lis le fichier d'entrée dans la variable listLignes
    var listLignes = Source.fromFile("data/entryfile.txt").getLines.toList

    // on vérifie la validité du fichier d'entrée en regardant si on a bien un fichier à nombres de lignes impaires
    if (listLignes.size%2==0){
      Console.err.println("Nombre de lignes dans fichier d'entrée est pair. Le fichier d'entrée doit avoir un nombre de lignes impair ")
      sys.exit(1)
    }

    // On crée le fichier output où on écrira nos sorties de codes
    val pw = new PrintWriter(new File("data/outputfile.txt" ))


    // decomposition du fichier d'entrèe

      // traitmeent de la première ligne : création de la pelouse

    var taillePelouse = listLignes(0)


      // Selection des éléments liés à la taille de la pelouse

      // identification de la position de l'espace dans la première ligne pour determiner la taille x et la taille y de la pelouse
    var positionEspace = taillePelouse.indexOf(" ")

    var tailleSegment_x = taillePelouse.substring(0,positionEspace)
    var tailleSegment_y = taillePelouse.substring(positionEspace+1,taillePelouse.size)


    // création de l'objet pelouse
    var pelouse = new Pelouse
    pelouse.taille_segment_x=tailleSegment_x.toInt
    pelouse.taille_segment_y=tailleSegment_y.toInt

    // création d'une nouvelle liste qui contient que les lignes pour la création des tondeuses et les instructions des tondeuses
    var listLignesTondeuses=listLignes.drop(1)


    // la boucle ci-dessous itère sur les lignes du fichier et prend l'information d'interêt de chaque ligne
    // pour chaque élément dans la liste :
      // si l'index de l'élement est pair alors
          //on crée la tondeuse avec la position et l'orientation

      // si l'index de l'élement est impair alors
          //  On applique l'instruction de la tondeuse_x
          //  On écrit la sortie dans le fichier de sortie OutputFile
    // Fin boucle

    // on crée la variable compteur pour variabiliser le nom des tondeuses
    var compteur = 0
    var tondeuse = new Tondeuse

    for ( i <- 0 until listLignesTondeuses.size) {

      if (i%2==0) {

        compteur = compteur + 1

        var positionEspace1_x = listLignesTondeuses(i).indexOf(" ")
        var positionEspace2_x = listLignesTondeuses(i).lastIndexOf(" ")

        var x = listLignesTondeuses(i).substring(0,positionEspace1_x).toInt
        var y = listLignesTondeuses(i).substring(positionEspace2_x-1,positionEspace2_x).toInt
        var orientation = listLignesTondeuses(i).substring(listLignesTondeuses(i).length() - 1).charAt(0)

        tondeuse.nom = "Tondeuse " + compteur
        tondeuse.x = x
        tondeuse.y = y
        tondeuse.orientation = orientation
        tondeuse.pelouse = pelouse

      }
      else {
        tondeuse.appliquerInstructions(listLignesTondeuses(i).toList)
        pw.write(tondeuse + "\n")

      }
    }
    pw.close

  }
}