package ca.com.skip.api.handler;

public class ErrorDetails {
	
	private String title;
	private int status;
	private String detail;
	private long timestamp;
	private String devMessage;
	
	public String getTitle() {
		
		return title;
	}
	
	public void setTitle(final String title) {
		
		this.title = title;
	}
	
	public int getStatus() {
		
		return status;
	}
	
	public void setStatus(final int status) {
		
		this.status = status;
	}
	
	public String getDetail() {
		
		return detail;
	}
	
	public void setDetail(final String detail) {
		
		this.detail = detail;
	}
	
	public long getTimestamp() {
		
		return timestamp;
	}
	
	public void setTimestamp(final long timestamp) {
		
		this.timestamp = timestamp;
	}
	
	public String getDevMessage() {
		
		return devMessage;
	}
	
	public void setDevMessage(final String devMessage) {
		
		this.devMessage = devMessage;
	}
	
	public static final class Builder {
		
		private String title;
		private int status;
		private String detail;
		private long timestamp;
		private String devMessage;
		
		private Builder() {
			
		}
		
		public static Builder newBuilder() {
			
			return new Builder();
		}
		
		public Builder title(final String title) {
			
			this.title = title;
			return this;
		}
		
		public Builder status(final int status) {
			
			this.status = status;
			return this;
		}
		
		public Builder detail(final String detail) {
			
			this.detail = detail;
			return this;
		}
		
		public Builder timestamp(final long timestamp) {
			
			this.timestamp = timestamp;
			return this;
		}
		
		public Builder devMessage(final String devMessage) {
			
			this.devMessage = devMessage;
			return this;
		}
		
		public ErrorDetails build() {
			
			final ErrorDetails rnfDetails = new ErrorDetails();
			
			rnfDetails.setTitle(this.title);
			rnfDetails.setStatus(this.status);
			rnfDetails.setDetail(this.detail);
			rnfDetails.setTimestamp(this.timestamp);
			rnfDetails.setDevMessage(this.devMessage);
			
			return rnfDetails;
		}
	}
	
}
