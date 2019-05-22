package com.sample.dto;

import java.time.LocalDateTime;

public class Component {

	private final String name;
	private final LocalDateTime createDttm;
	private final int depth;
	private final boolean isFrontend;
	private final boolean isBackend;
	private final boolean isModule;
	private final boolean isError;
	private final String errorMessage;
	private final String desc;
	private final String version;
	
	private Component(Builder builder) {
		name = builder.name;
		createDttm = builder.createDttm;
		depth = builder.depth;
		isFrontend = builder.isFrontend;
		isBackend = builder.isBackend;
		isModule = builder.isModule;
		desc = builder.desc;
		version = builder.version;
		isError = builder.isError;
		errorMessage = builder.errorMessage;
	}
	
	public static class Builder {

		// 필수 매개변수
		private final String name;
		private final LocalDateTime createDttm;
		private final int depth;
		
		// 선택 매개변수
		private boolean isFrontend = false;
		private boolean isBackend = false;
		private boolean isModule = false;
		private boolean isError = false;
		private String errorMessage = null;
		private String desc = "none";
		private String version = "";
		
		public Builder(String name, LocalDateTime createDttm, int depth) {
			this.name = name;
			this.createDttm = createDttm;
			this.depth = depth;
		}
		public Builder isError(boolean val) {
			isError = val;
			return this;
		}
		public Builder isFrontend(boolean val) {
			isFrontend = val;
			return this;
		}
		public Builder isBackend(boolean val) {
			isBackend = val;
			return this;
		}
		public Builder isModule(boolean val) {
			isModule = val;
			return this;
		}
		public Builder errorMessage(String val) {
			errorMessage = val;
			return this;
		}
		public Builder desc(String val) {
			desc = val;
			return this;
		}
		public Builder version(String val) {
			version = val;
			return this;
		}
		public Component build() {
			return new Component(this);
		}
	}

	@Override
	public String toString() {
		return "Component [name=" + name + ", createDttm=" + createDttm + ", depth=" + depth + ", isFrontend="
				+ isFrontend + ", isBackend=" + isBackend + ", isModule=" + isModule + ", isError=" + isError
				+ ", errorMessage=" + errorMessage + ", desc=" + desc + ", version=" + version + "]";
	}
}
