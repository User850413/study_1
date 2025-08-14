package com.study.interfaces;

import com.common.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
	private Result result;
	private T data;
	private CommonResponseMetadata metadata;
	private Object message;
	private Number errorCode;
	private String errorCodeName;
	
	private static final CommonResponseMetadata DEFAULT_METADATA = CommonResponseMetadata.create();
	
	public static <T> CommonResponse<T> success(T data, String message, CommonResponseMetadata metadata){
		if(metadata == null) {
			metadata = DEFAULT_METADATA;
		}
		
		return (CommonResponse<T>) CommonResponse.builder()
				.result(Result.SUCCESS)
				.data(data)
				.metadata(metadata)
				.build();
	}
	
	public static <T> CommonResponse<T> success(T data, CommonResponseMetadata metadata){
		return success(data, null, metadata);
	}
	
	public static <T> CommonResponse<T> success(T data, String message){
		return success(data, message, null);
	}
	
	public static <T> CommonResponse<T> success(T data){
		return success(data, null, null);
	}
	
	public static CommonResponse fail(Object message, String errorCodeName, Number errorCode) {
		CommonResponseMetadata metadata = DEFAULT_METADATA;
		
		return CommonResponse.builder()
				.result(Result.FAILURE)
				.message(message)
				.metadata(metadata)
				.errorCodeName(errorCodeName)
				.errorCode(errorCode)
				.build();
	}
	
	public static CommonResponse fail(ErrorCode errorCodeName, Number errorCode) {
		return fail(errorCodeName.getErrorMsg(), errorCodeName.name(), errorCode);
	}
	
	public CommonResponse<T> addMetaData(String key, Object value){
		if(metadata == null || metadata == DEFAULT_METADATA) {
			metadata = CommonResponseMetadata.create();
		}
		
		metadata.put(key, value);
		return this;
	}
	
   public CommonResponse<T> addPagingMetadata(int page, int totalRecords, int pageSize) {
        addMetaData("page", page);
        addMetaData("totalRecords", totalRecords);
        addMetaData("pageSize", pageSize);

        return this;
    }

	
	public enum Result {
		SUCCESS, FAILURE
	}
}
