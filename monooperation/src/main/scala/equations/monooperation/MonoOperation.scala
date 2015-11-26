package equations.monooperation

/**
 * Created by kasonchan on 11/26/15.
 */
trait MonoOperation {

  /**
   * Returns the sum of the list.
   * @param inputs the list of inputs.
   */
  def sumList(inputs: List[Option[Double]]): Double = {
    inputs.foldLeft(0.0) {
      (m, n) => m + n.getOrElse(0.0)
    }
  }

  /**
   * Returns the product of the list.
   * @param inputs the list of inputs.
   */
  def productList(inputs: List[Option[Double]]): Double = {
    inputs.foldLeft(1.0) {
      (m, n) => m * n.getOrElse(1.0)
    }
  }

  /**
   * Returns the result of subtraction of x and y.
   * @param x the value of x.
   * @param y the value of y.
   */
  def subtract(x: Double, y: Double): Double = x - y

  /**
   * Returns the result of division of x and y.
   * y is required to be > 0.
   * @param x the value of x.
   * @param y the value of y.
   */
  def divide(x: Double, y: Double): Double = {
    require(y != 0)
    x / y
  }

}

object MonoOperation extends MonoOperation
