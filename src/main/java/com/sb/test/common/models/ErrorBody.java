/**
 * 
 */
package com.sb.test.common.models;

/**
 * @author Venkatesh_Urlana
 *
 */
public class ErrorBody {
	private String errorMsg;
	private String errorCode;
	private String errorDescription;
	private Object errorData;
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public Object getErrorData() {
		return errorData;
	}
	public void setErrorData(Object errorData) {
		this.errorData = errorData;
	}
	public ErrorBody(String errorMsg, String errorCode, String errorDescription, Object errorData) {
		super();
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.errorData = errorData;
	}
	public ErrorBody(String errorMsg, String errorCode) {
		super();
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}
	public ErrorBody() {
		super();
	}
	
	
}
