package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import Shape.*
import Behaviors.*

class TestHeight extends AnyFunSuite:
  test("height"):
    assert(height(Ellipse(1, 1)) == 1)
    assert(height(Location(0,0, Group(Rectangle(1,1), Ellipse(1,1)))) == 3)
