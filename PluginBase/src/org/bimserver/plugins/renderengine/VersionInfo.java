package org.bimserver.plugins.renderengine;

import java.util.GregorianCalendar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class VersionInfo {
	private String branch;
	private String commitsha;
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private GregorianCalendar datetime;
	private String protocolVersion;
	private String platform;
	
	public VersionInfo(String branch, String commitsha, String protocolVersion, GregorianCalendar datetime, String platform) {
		this.branch = branch;
		this.commitsha = commitsha;
		this.protocolVersion = protocolVersion;
		this.datetime = datetime;
		this.platform = platform;
	}

	public JsonNode toJson() {
		ObjectNode result = OBJECT_MAPPER.createObjectNode();
		result.put("branch", branch);
		result.put("commitsha", commitsha);
		result.put("datetime", datetime.getTimeInMillis());
		result.put("protocolVersion", protocolVersion);
		result.put("platform", platform);
		return result;
	}

	public String getBranch() {
		return branch;
	}
	
	public String getCommitsha() {
		return commitsha;
	}

	public GregorianCalendar getDateTime() {
		return datetime;
	}
	
	public String getProtocolVersion() {
		return protocolVersion;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
}