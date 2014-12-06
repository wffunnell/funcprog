package datastructures

import org.scalatest.prop.PropertyChecks
import org.scalatest.prop.Tables.Table
import org.scalatest.{PropSpecLike, Matchers, FlatSpec}

class ListSpec extends FlatSpec with Matchers {

  "list" should "return 3 for pattern patch example" in {

    List2.x should be(3)
  }

  it should "return tail" in new PropertyChecks {

    val validCombos =
      Table(
        ("head", "tail"),
        (List2(1), List2()),
        (List2(1,2), List2(2)),
        (List2(1,2,3), List2(2,3))
      )

    forAll(validCombos) { (full: List2[Int], tail: List2[Int]) =>
      List2.tail(full) should be(tail)
    }
  }

  it should "set head" in new PropertyChecks {

    val validCombos =
      Table(
        ("previous", "replace", "expected"),
        (List2(1), 2, List2(2)),
        (List2(1,2), 3, List2(3,2)),
        (List2(1,2,3), 4, List2(4,2,3))
      )

    forAll(validCombos) { (l: List2[Int], h: Int, expected: List2[Int]) =>
      List2.setHead(l, h) should be(expected)
    }
  }

}