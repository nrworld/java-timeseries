/*
 * Copyright (c) 2016 Jacob Rachiele
 *
 */

package optim;

import math.function.AbstractFunction;

/**
 * @author Jacob Rachiele
 */
public class TestFunctionExpSin extends AbstractFunction {

  @Override
  public final double at(final double point) {
    functionEvaluations++;
    return -Math.exp(-point) * Math.sin(point);
  }
}
