package aw222zr_assignment1;

import java.util.ArrayList;
import java.util.List;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;

public class SinMain {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// A lot of this code is copied straight from the xChart website.

		// Create and Customize Chart
		XYChart chart = new XYChartBuilder().width(800).height(600).build();
		chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
		chart.getStyler().setChartTitleVisible(false);
		chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
		chart.getStyler().setMarkerSize(5);

		double pi = 3.14;
		double x = 2 * pi;
		double y = (1 + x / pi) * Math.cos(x) * Math.cos(40 * x);

		// Generate data
		List xData = new ArrayList();
		List yData = new ArrayList();

		for (double i = 0; i <= x; i += 0.01) {
			y = (1 + i / pi) * Math.cos(i) * Math.cos(40 * i);
			xData.add(i);
			yData.add(y);
		}

		chart.addSeries("Sin Curve", xData, yData);
		new SwingWrapper(chart).displayChart();
	}
}
