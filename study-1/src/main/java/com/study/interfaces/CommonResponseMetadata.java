package com.study.interfaces;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@JsonSerialize(using = CommonResponseMetadata.CommonResponseMetadataSerializer.class)
public class CommonResponseMetadata {
	private Map<String, Object> metadata;
	
	private CommonResponseMetadata() {
		metadata = new HashMap<>();
	}
	
	public CommonResponseMetadata put(String key, Object value) {
		metadata.put(key, value);
		return this;
	}
	
	public Object get(String key) {
		return metadata.get(key);
	}
	
	public Set<String> keySet(){
		return metadata.keySet();
	}
	
	public static CommonResponseMetadata ofPaging(int page, long totalRecords, long pageSize) {
		CommonResponseMetadata commonResponseMetadata = new CommonResponseMetadata();
		commonResponseMetadata.put("page", page);
		commonResponseMetadata.put("totalRecords", totalRecords);
		commonResponseMetadata.put("pageSize", pageSize);
		return commonResponseMetadata;
	}
	
	public static CommonResponseMetadata create() {
		return new CommonResponseMetadata();
	}

	public static class CommonResponseMetadataSerializer extends StdSerializer<CommonResponseMetadata>{
		public CommonResponseMetadataSerializer() {
			this(null);
		}
		
		public CommonResponseMetadataSerializer(Class<CommonResponseMetadata> t) {
			super(t);
		}
		
		@Override
		public void serialize(CommonResponseMetadata value, JsonGenerator gen, SerializerProvider provider) throws IOException {
			gen.writeStartObject();
			
			if(!value.keySet().contains("timestamp")) {
				//timestamp 필드 없을 시 현재 시각 기록
				gen.writeObjectField("timestamp", OffsetDateTime.now());
			}
			
			for(String key : value.keySet()) {
				gen.writeObjectField(key, value.get(key));
			}
			
			gen.writeEndObject();
		}
	}
	
	
}
