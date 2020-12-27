class Tondeuse {
  private var _nom = "Tondeuse"
  private var _x = 0
  private var _y = 0
  private var _orientation = 'N'
  private var _pelouse = new Pelouse

  def nom = _nom
  def nom_= (newValue: String): Unit = {
    _nom = newValue
  }


  def x = _x
  def x_= (newValue: Int): Unit = {
     _x = newValue
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
     _y = newValue
  }

  def orientation = _orientation
  def orientation_= (newValue: Char): Unit = {
    if (newValue == 'N' || newValue == 'E' || newValue == 'W' || newValue == 'S') _orientation = newValue
    else println("Warning")
  }

  def pelouse: Pelouse = _pelouse
  def pelouse_= (newValue: Pelouse): Unit = {
    _pelouse = newValue
  }

  // var tondeuse1 = new Tondeuse

  def appliquerInstructions(instructions: List[Char]): Unit ={

    for( i <- instructions ){
      if (i == 'G') {
        tournerGauche()
      }
      else if (i == 'D') {
        tournerDroite()
      }
      else if (i == 'A') {
        avancer()
      }
      else { println("Vous n'avez pas mis la bonne lettre d'instruction")
      }
    }
  }

  def avancer(): Unit = {

    if(orientation == 'W' && x-1>=0){
      x=x-1
    }
    else if(orientation == 'N' && y+1 <=pelouse.taille_segment_y){
      y=y+1
    }
    else if(orientation == 'E' && x+1 <= pelouse.taille_segment_x) {
      x=x+1
    }
    else if(orientation == 'S' && y-1>=0) {
      y=y-1
    }
    else {
      println("Ne peut pas appliquer instrcution avancer. Vérifier surface pelouse")
    }

   // si Orientation = W et si x-1 >= 0 alors x=x-1 sinon warning
   // si Orientation = N et si y+1 <=pelouse.largeur alors y=y+1 sinon warning
   // si Orientation = E et si x+1 <=pelouse.longueur alors x=x+1 sinon warning
   // si Orientation = S et si y-1 >=0 alors y=y-1 sinon warning
  }

  private def printWarning = println("Orientation non valide")

  def tournerGauche() {

    if(orientation == 'N'){
      orientation = 'W'
    }
    else if(orientation == 'S'){
      orientation = 'E'
    }
    else if(orientation == 'E') {
      orientation = 'N'
    }
    else if (orientation == 'W') {
      orientation = 'S'
    }
    else {
      println("Instruction pour changement d'orientation (à gauche) de la tondeuse non appliquée. Vérifier orientation donnée en entrée")
    }
  }
    def tournerDroite() {


      if(orientation == 'N'){
        orientation = 'E'
      } else if(orientation == 'S'){
        orientation = 'W'
      }
      else if(orientation == 'E') {
        orientation = 'S'
      }
      else if (orientation == 'W') {
        orientation = 'N'
      }
      else {
        println("Instruction pour changement d'orientation (à droite) de la tondeuse non appliquée. Vérifier orientation donnée en entrée")
      }
    }

  override def toString: String = nom + " : " + x  +" " + y + " " + orientation

}