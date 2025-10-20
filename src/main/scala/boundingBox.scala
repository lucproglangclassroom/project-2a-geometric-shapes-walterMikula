package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    
    case Rectangle(w, h) =>
      Location(0, 0, Rectangle(w, h))
    
    case Ellipse(rx, ry) =>
      // ellipse centered at (0,0): bbox from (-rx,-ry) size (2rx, 2ry)
      Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))

    case Location(x, y, inner) =>
      // child box, then shift by (x,y)
      val Location(ix, iy, Rectangle(w, h)) = apply(inner): @unchecked
      Location(ix + x, iy + y, Rectangle(w, h))

    case Group(children*) if children.isEmpty =>
      Location(0, 0, Rectangle(0, 0))

    case Group(children*) =>
      val boxes = children.map(apply)
      val minX = boxes.map { 
        case Location(x, _, Rectangle(w, _)) => x }.min
      val maxX = boxes.map { 
        case Location(x, _, Rectangle(w, _)) => x + w }.max
      val minY = boxes.map { 
        case Location(_, y, Rectangle(_, h)) => y }.min
      val maxY = boxes.map { 
        case Location(_, y, Rectangle(_, h)) => y + h }.max
      Location(minX, minY, Rectangle(maxX - minX, maxY - minY))

end boundingBox