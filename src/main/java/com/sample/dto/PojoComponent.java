package com.sample.dto;

import java.time.LocalDateTime;

public class PojoComponent {
	private String name;
	private LocalDateTime createDttm;
	private int depth;
	private boolean isFrontend;
	private boolean isBackend;
	private boolean isModule;
	private boolean isError;
	private String errorMessage;
	private String desc;
	private String version;
	
	public PojoComponent(String name, LocalDateTime createDttm, int depth) {
		this.name = name;
		this.createDttm = createDttm;
		this.depth = depth;
	}
	
	public String getName() {
		return name;
	}
	public LocalDateTime getCreateDttm() {
		return createDttm;
	}
	public int getDepth() {
		return depth;
	}
	public boolean isFrontend() {
		return isFrontend;
	}
	public boolean isBackend() {
		return isBackend;
	}
	public boolean isModule() {
		return isModule;
	}
	public boolean isError() {
		return isError;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public String getDesc() {
		return desc;
	}
	public String getVersion() {
		return version;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCreateDttm(LocalDateTime createDttm) {
		this.createDttm = createDttm;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public void setFrontend(boolean isFrontend) {
		this.isFrontend = isFrontend;
	}
	public void setBackend(boolean isBackend) {
		this.isBackend = isBackend;
	}
	public void setModule(boolean isModule) {
		this.isModule = isModule;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "PojoComponent [name=" + name + ", createDttm=" + createDttm + ", depth=" + depth + ", isFrontend="
				+ isFrontend + ", isBackend=" + isBackend + ", isModule=" + isModule + ", isError=" + isError
				+ ", errorMessage=" + errorMessage + ", desc=" + desc + ", version=" + version + "]";
	}
}
