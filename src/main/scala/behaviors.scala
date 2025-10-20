package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import scala.math.round

object Behaviors:

  // counts leaf shape
  def size(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _)   => 1
    case Location(_, _, inner) =>
      size(inner)
    case Group(children*) =>
      children.map(size).sum    

  // height
  def height(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _)   => 1
    case Location(_, _, inner) =>
      1 + height(inner)
    case Group(children*) if children.isEmpty =>
      1
    case Group(children*) =>
      1 + children.map(height).foldLeft(0)(Math.max)   

  //recursively scales shape dimensions and locations
  def scale(s: Shape, by: Double): Shape = s match
    case Rectangle(w, h) =>
      Rectangle(round(w * by).toInt, round(h * by).toInt)
    case Ellipse(rx, ry) =>
      Ellipse(round(rx * by).toInt, round(ry * by).toInt)
    case Location(x, y, inner) =>
      Location(round(x * by).toInt, round(y * by).toInt, scale(inner, by))
    case Group(children*) =>
      Group(children.map(scale(_, by))*)
