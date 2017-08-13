/*
 * Copyright (c) 2016 Jacob Rachiele
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to
 * do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
 * USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Contributors:
 *
 * Jacob Rachiele
 */
package timeseries.model;

import timeseries.TimeSeries;
import timeseries.forecast.Forecast;

/**
 * A representation of a time series model. A time series model is an attempt to capture the essential
 * characteristics of the process or processes underlying the time series.
 *
 * @author Jacob Rachiele
 */
public interface Model {

    Forecast forecast(int steps, double alpha);

    /**
     * Produce a forecast from this model up to the given number of steps ahead.
     *
     * @param steps the number of time periods ahead to forecast.
     * @return a forecast from this model up to the given number of steps ahead.
     */
    default Forecast forecast(int steps) {
        return forecast(steps, 0.05);
    }

    /**
     * Get the series of observations.
     *
     * @return the series of observations.
     */
    TimeSeries timeSeries();

    /**
     * Get the model fitted values, which are in-sample one-step ahead forecasts.
     *
     * @return the model fitted values.
     */
    TimeSeries fittedSeries();

    /**
     * Get the model prediction errors, the difference between the observed values and the model fitted values.
     *
     * @return the model prediction errors.
     */
    default TimeSeries predictionErrors() {
        return this.timeSeries().minus(this.fittedSeries());
    }

//    /**
//     * Plot the model fit, which often displays the model fitted values and the observations in the same plot area.
//     */
//    default void plotFit() {
//        Plots.plot(fittedSeries(), "Model Fitted Values", "fitted values");
//    }
//
//    /**
//     * Plot the model residuals.
//     */
//    default void plotResiduals() {
//        Plots.plot(residuals(), "Model Residuals", "residuals");
//    }

}