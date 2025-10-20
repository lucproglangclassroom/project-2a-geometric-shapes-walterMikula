package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import Shape.*
import Behaviors.*

class TestScale extends AnyFunSuite:
  test("scale"):// 2 test, one that is nested and one that isnt
    assert(scale(Rectangle(2, 3), 2.0) == Rectangle(4, 6))
    assert(scale(Group(Location(2,3, Ellipse(4,5))), 0.5) == Group(Location(1,2, Ellipse(2,3))))
