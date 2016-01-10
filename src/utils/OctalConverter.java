package utils;

public class OctalConverter {

	private OctalConverter() {

	}

	private static OctalConverter converter;

	public static OctalConverter getConverter() {
		if (converter == null) {
			converter = new OctalConverter();
		}
		return converter;
	}

	public String convertToOctal(String value) {
		StringBuilder builder = new StringBuilder();
		long l = Long.parseLong(value);
		while (l > 8) {
			long mod = l % 8;
			builder.append(String.valueOf(mod));
			l = (int) l / 8;
		}
		builder.append(String.valueOf(l));
		return builder.reverse().toString();
	}
}