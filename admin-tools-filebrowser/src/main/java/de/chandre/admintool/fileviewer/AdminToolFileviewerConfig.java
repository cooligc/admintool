package de.chandre.admintool.fileviewer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import de.chandre.admintool.core.AdminToolConfig;

/**
 * 
 * @author Andre
 * @since 1.0.1
 *
 */
@Component("adminToolFileviewerConfig")
public class AdminToolFileviewerConfig implements AdminToolConfig {
	
	private static final Log LOGGER = LogFactory.getLog(AdminToolFileviewerConfig.class);
	
	@Value("${admintool.fileviewer.enabled:true}")
	private boolean enabled;
	
	@Value("#{'${admintool.fileviewer.encodings:UTF-8;ISO-8859-1}'.split(';')}")
	private List<String> encodings = new ArrayList<>();
	
	@Value("${admintool.fileviewer.defaultEncoding:UTF-8}")
	private String defaultEncoding;

	@Value("${admintool.fileviewer.readOnly:true}")
	private boolean readOnly;
	
	@Value("#{'${admintool.fileviewer.allowedExtensions:txt;sql;properties;xml;xsd;wsdl;htm;html;css;js;ts;json;yml;yaml;log;md;sh;bat;cmd;php;php4;php5;py;lua;java;jsp;jspx;jspf}'.split(';')}")
	private List<String> allowedExtensions = new ArrayList<>();
	
	@Value("${admintool.fileviewer.codeMirrorVersion:5.19.0}")
	private String codeMirrorVersion;
	
	@Value("#{'${admintool.fileviewer.codeMirrorAddLibs:addon/edit/matchbrackets.js}'.split(';')}")
	private List<String> codeMirrorAddLibs = new ArrayList<>();
	
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
	
	/**
	 * @return the encodings
	 */
	public List<String> getEncodings() {
		return encodings;
	}
	
	/**
	 * @return the defaultEncoding
	 */
	public String getDefaultEncoding() {
		return defaultEncoding;
	}

	/**
	 * @return the readOnly
	 */
	public boolean isReadOnly() {
		return readOnly;
	}
	
	/**
	 * @return the allowedExtensions
	 */
	public List<String> getAllowedExtensions() {
		return allowedExtensions;
	}

	/**
	 * @return the codeMirrorVersion
	 */
	public String getCodeMirrorVersion() {
		return codeMirrorVersion;
	}

	/**
	 * @return the codeMirrorAddLibs
	 */
	public List<String> getCodeMirrorAddLibs() {
		return codeMirrorAddLibs;
	}

	@Override
	@PostConstruct
	public void printConfig() {
		LOGGER.debug(toString());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminToolFileviewerConfig [enabled=").append(enabled).append(", encodings=").append(encodings)
				.append(", defaultEncoding=").append(defaultEncoding).append(", readOnly=").append(readOnly)
				.append(", allowedExtensions=").append(allowedExtensions).append(", codeMirrorVersion=")
				.append(codeMirrorVersion).append(", codeMirrorAddLibs=").append(codeMirrorAddLibs).append("]");
		return builder.toString();
	}

}
