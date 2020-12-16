package org.springblade.common.tool;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author 呵呵哒
 * @description: TODO json序列化解析问题
 * @projectName SafetyStandards
 */
public class JsonSerializerUtils  extends JsonSerializer<Object> {
	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if (value instanceof Integer) {
			gen.writeString("0");
		}
	}
}
