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


  def groupM(puts: List[Option[Double]],
             operation: List[Option[Double]] => Double):
  Either[Option[Double], (Option[Double], Option[Double])] = {
    val spanned = puts match {
      case List() => None
      case l: List[Option[Double]] =>
        val r = l partition {
          m => !m.isDefined
        }
        Some(r)
      case _ => None
    }

    spanned match {
      case None => Left(None)
      case Some(x) => x match {
        case (List(), t) => Left(Some(operation(t)))
        case (h, t) =>
          h.size match {
            case 1 => Right(h.head, Some(operation(t)))
            case _ => Left(None)
          }
      }
      case _ => Left(None)
    }
  }

}

object MonoOperation extends MonoOperation
