package com.github.jbrasileiro.primso.api.json;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public final class BigDecimalSerialize
	extends
	JsonSerializer<BigDecimal> {

	@Override
	public void serialize(
		BigDecimal value,
		JsonGenerator generator,
		SerializerProvider serializers)
		throws IOException {
		generator.writeString(value.setScale(2).toString());
	}

}
