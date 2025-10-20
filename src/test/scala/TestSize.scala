package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import Shape.*
import Behaviors.*

class TestSize extends AnyFunSuite:
  test("size"):
  // 2 tests for each one that isnt nestsed, and one that is nested
    assert(size(Rectangle(1, 1)) == 1)
    assert(size(Group(Rectangle(1,1), Location(0,0, Ellipse(2,2)))) == 2)