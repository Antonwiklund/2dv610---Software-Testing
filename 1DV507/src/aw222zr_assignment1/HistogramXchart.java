package aw222zr_assignment1;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler.LegendPosition;

@SuppressWarnings("rawtypes")
public class HistogramXchart implements ExampleChart {

	private static int[] occurenceArray = new int[10];
	private static int others = 0;
	@SuppressWarnings("unused")
	private static int inSpan = 0;

	public static void main(String[] args) {
		File histogramFile = new File(
				"C:\\Users\\Ej Admin\\Dropbox\\Eclipse Windows\\1DV507\\src\\aw222zr_assignment1\\HistogramXcount.txt");
		try {
			Scanner in = new Scanner(histogramFile);
			while (in.hasNext()) {
				String currentNumber = in.nextLine();
				addOccurence(currentNumber);
			}
			in.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// Barchart:
		@SuppressWarnings("unchecked")
		ExampleChart<CategoryChart> barChart = new HistogramXchart();
		CategoryChart chart1 = ((HistogramXchart) barChart).getBarChart();
		new SwingWrapper<CategoryChart>(chart1).displayChart();

		// Piechart:
		@SuppressWarnings("unchecked")
		ExampleChart<PieChart> pieChart = new HistogramXchart();
		PieChart chart2 = pieChart.getChart();
		new SwingWrapper<PieChart>(chart2).displayChart();
	}

	public PieChart getChart() {
		// This code is mainly copied from the xChart examples. Minor modifications.

		// Create Chart
		PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

		// Customize Chart
		Color[] sliceColors = new Color[] { new Color(200, 68, 13), new Color(1, 48, 1), new Color(100, 68, 14),
				new Color(224, 28, 14), new Color(74, 18, 84), new Color(22, 68, 14), new Color(156, 68, 14),
				new Color(174, 28, 14), new Color(224, 6, 1), new Color(250, 68, 14), new Color(50, 98, 14) };
		chart.getStyler().setSeriesColors(sliceColors);

		// Series
		chart.addSeries("Integers outside span[1,100]", others);
		chart.addSeries("Integers within span[1,10]", occurenceArray[0]);
		chart.addSeries("Integers within span[11,20]", occurenceArray[1]);
		chart.addSeries("Integers within span[21,30]", occurenceArray[2]);
		chart.addSeries("Integers within span[31,40]", occurenceArray[3]);
		chart.addSeries("Integers within span[41,50]", occurenceArray[4]);
		chart.addSeries("Integers within span[51,60]", occurenceArray[5]);
		chart.addSeries("Integers within span[61,70]", occurenceArray[6]);
		chart.addSeries("Integers within span[71,80]", occurenceArray[7]);
		chart.addSeries("Integers within span[81,90]", occurenceArray[8]);
		chart.addSeries("Integers within span[91,100]", occurenceArray[9]);

		return chart;
	}

	public CategoryChart getBarChart() {
		// This code is mainly copied from the xChart examples. Minor modifications.

		// Create Chart
		CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Histogram")
				.xAxisTitle("Different Values in Spans[X,X0] (outside = outOfSpan)")
				.yAxisTitle("Amount of Various Values").build();

		// Customize Chart
		chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
		chart.getStyler().setHasAnnotations(true);

		// Series
		chart.addSeries("Counting integers within spans.",
				Arrays.asList(new String[] { "outside", "0-10", "11-20", "21-30", "31-40", "41-50", "51-60", "61-70",
						"71-80", "81-90", "91-100" }),
				Arrays.asList(new Integer[] { others, occurenceArray[0], occurenceArray[1], occurenceArray[2],
						occurenceArray[3], occurenceArray[4], occurenceArray[5], occurenceArray[6], occurenceArray[7],
						occurenceArray[8], occurenceArray[9] }));

		return chart;
	}

	public static void addOccurence(String currentNumber) {
		int numberParsed = Integer.parseInt(currentNumber);

		if (numberParsed > 0 && numberParsed < 11) {
			occurenceArray[0] += 1;
			inSpan += 1;
		} else if (numberParsed > 10 && numberParsed < 21) {
			occurenceArray[1] += 1;
			inSpan += 1;
		} else if (numberParsed > 20 && numberParsed < 31) {
			occurenceArray[2] += 1;
			inSpan += 1;
		} else if (numberParsed > 30 && numberParsed < 41) {
			occurenceArray[3] += 1;
			inSpan += 1;
		} else if (numberParsed > 40 && numberParsed < 51) {
			occurenceArray[4] += 1;
			inSpan += 1;
		} else if (numberParsed > 50 && numberParsed < 61) {
			occurenceArray[5] += 1;
			inSpan += 1;
		} else if (numberParsed > 60 && numberParsed < 71) {
			occurenceArray[6] += 1;
			inSpan += 1;
		} else if (numberParsed > 70 && numberParsed < 81) {
			occurenceArray[7] += 1;
			inSpan += 1;
		} else if (numberParsed > 80 && numberParsed < 91) {
			occurenceArray[8] += 1;
			inSpan += 1;
		} else if (numberParsed > 90 && numberParsed < 101) {
			occurenceArray[9] += 1;
			inSpan += 1;
		} else {
			others += 1;
		}
	}

	public static void countOccurence() throws IOException {
		System.out.println("\nHistogram: ");

		for (int i = 0; i < occurenceArray.length; i++) {
			if (i == 0) {
				System.out.println("1 - 10   | " + swapNumbersToStars(occurenceArray[i]));
			} else if (i > 0 && i < 9) {
				System.out.println(i + "1 - " + (i + 1) + "0  | " + swapNumbersToStars(occurenceArray[i]));
			} else if (i == 9) {
				System.out.println(i + "1 - " + "100 | " + swapNumbersToStars(occurenceArray[i]));
			}
		}
	}

	public static String swapNumbersToStars(int occurenceArrayNumber) {
		int occurences = occurenceArrayNumber;
		String one = "";
		for (int i = 0; i < occurences; i++) {
			one += "*";
		}
		return one;
	}
}
