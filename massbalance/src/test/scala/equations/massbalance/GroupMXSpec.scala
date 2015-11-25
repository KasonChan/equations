package equations.massbalance

import equations.massbalance.MassBalance._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/25/15.
 */
class GroupMXSpec extends FlatSpec with Matchers {

  "Test 1" should "pass" in {
    groupMX(List()) shouldBe Left(None)
  }

  "Test 2" should "pass" in {
    groupMX(List(MX(Some(1), Some(2)))) shouldBe Left(Some(2))
  }

  "Test 3" should "pass" in {
    groupMX(List(MX(Some(1), Some(2)), MX(Some(1), None))) shouldBe Right(MX(Some(1), None), Some(2))
  }

  "Test 4" should "pass" in {
    groupMX(List(MX(Some(1), None), MX(Some(1), None))) shouldBe Left(None)
  }

}
