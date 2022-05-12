/**
 * 
 */
package com.sb.test.common.models;

/**
 * @author Venkatesh_Urlana
 *
 */
public class SuccessBody {

	private Object data;
	private String successMsg;
	private String successCode;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	public String getSuccessCode() {
		return successCode;
	}
	public void setSuccessCode(String successCode) {
		this.successCode = successCode;
	}
	public SuccessBody(Object data, String successMsg, String successCode) {
		super();
		this.data = data;
		this.successMsg = successMsg;
		this.successCode = successCode;
	}
	public SuccessBody(Object data) {
		super();
		this.data = data;
	}
	
	
}
