package quiz10;

public class EnglishToMetricConverter implements ScaleConverter {

	public EnglishToMetricConverter() {
		
	}

	@Override
	public double convertTemperature(double tempIn) {

		return ((tempIn - 32.0) * 5.0) / 9.0;
	}

	@Override
	public double convertDistance(double distanceIn) {

		return distanceIn * 1.609;
	}

	@Override
	public double convertWeight(double weightIn) {
		
		return weightIn / 2.2;
	}
}
