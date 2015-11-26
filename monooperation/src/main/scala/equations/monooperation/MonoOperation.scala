package equations.monooperation

/**
 * A trait to represent a ''monooperation equation''.
 *
 * Specify the `variable` and `constant` when calling the solveM function like this:
 *
 * {{{
 * x = 3 + 4
 * scala> solveM(List(None), List(Some(3), Some(4)), 'add)
 * Some(7.0)
 *
 * 25 = x * 5
 * scala> solveM(List(Some(25)), List(None, Some(5)), 'multiple)
 * Some(5.0)
 * }}}
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

  /**
   * Returns the Right with tuple of the unknown and operated result.
   * Returns the Left with operated result.
   * Otherwise, returns Left None.
   * @param puts the list of inputs.
   * @param operation the operation is performed to the list of inputs.
   */
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

  /**
   * Returns Some of result after valid operation.
   * Otherwise returns None.
   * @param tuple the tuple of grouped input and grouped output.
   * @param operation the operation is performed to the grouped tuple.
   */
  def solveMHelper(tuple: (Either[Option[Double], (Option[Double], Option[Double])],
    Either[Option[Double], (Option[Double], Option[Double])]),
                   operation: (Double, Double) => Double): Option[Double] = {
    tuple match {
      case (Left(l), Left(r)) => None
      case (Left(l), Right(r)) => r match {
        case (mx, grouped) =>
          mx match {
            case Some(x) =>
              val result = operation(l.getOrElse(0.0), grouped.getOrElse(0.0))
              Some(result)
            case None =>
              val result = operation(l.getOrElse(0.0), grouped.getOrElse(0.0))
              Some(result)
            case _ => None
          }
      }
      case (Right(l), Left(r)) => l match {
        case (mx, grouped) =>
          mx match {
            case Some(x) =>
              val result = operation(r.getOrElse(0.0), grouped.getOrElse(0.0))
              Some(result)
            case None =>
              val result = operation(r.getOrElse(0.0), grouped.getOrElse(0.0))
              Some(result)
            case _ => None
          }
      }
      case (Right(l), Right(r)) => None
      case _ => None
    }
  }

  /**
   * Returns Some result if the equation is valid.
   * Otherwise returns None.
   * @param inputs the left hand side of the equation.
   * @param outputs the right hand side of the equation.
   * @param operator the operation is performed to the inputs and outputs.
   */
  def solveM(inputs: List[Option[Double]],
             outputs: List[Option[Double]],
             operator: Symbol): Option[Double] = {
    operator match {
      case 'add =>
        val i = groupM(inputs, sumList)
        val o = groupM(outputs, sumList)
        solveMHelper((i, o), subtract)
      case 'multiple =>
        val i = groupM(inputs, productList)
        val o = groupM(outputs, productList)
        solveMHelper((i, o), divide)
      case _ => None
    }
  }

}

/**
 * A companion object of trait MonoOperation to represent a ''monooperation equation''.
 *
 * Specify the `variable` and `constant` when calling the solveM function like this:
 *
 * {{{
 * x = 3 + 4
 * scala> solveM(List(None), List(Some(3), Some(4)), 'add)
 * Some(7.0)
 *
 * 25 = x * 5
 * scala> solveM(List(Some(25)), List(None, Some(5)), 'multiple)
 * Some(5.0)
 * }}}
 */
object MonoOperation extends MonoOperation
