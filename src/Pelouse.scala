class Pelouse {
  private var _taille_segment_x = 0
  private var _taille_segment_y = 0


  def taille_segment_x = _taille_segment_x
  def taille_segment_x_= (newValue: Int): Unit = {
    _taille_segment_x = newValue
  }

  def taille_segment_y = _taille_segment_y
  def taille_segment_y_= (newValue: Int): Unit = {
    _taille_segment_y = newValue
  }

  override def toString: String = "Taille pelouse : (" + taille_segment_x  +"," + taille_segment_y + ")"
}