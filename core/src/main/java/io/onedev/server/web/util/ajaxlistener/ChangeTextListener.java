package io.onedev.server.web.util.ajaxlistener;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;
import org.unbescape.javascript.JavaScriptEscape;

public class ChangeTextListener implements IAjaxCallListener {

	private final String newText;
	
	public ChangeTextListener(String newText) {
		this.newText = newText;
	}
	
	@Override
	public CharSequence getInitHandler(Component component) {
		return null;
	}

	@Override
	public CharSequence getBeforeHandler(Component component) {
		return null;
	}

	@Override
	public CharSequence getPrecondition(Component component) {
		return null;
	}

	@Override
	public CharSequence getBeforeSendHandler(Component component) {
		return String.format(""
				+ "var $element = $('#%s');"
				+ "var newText = '%s';"
				+ "$element.data('prevValue', $element.val());"
				+ "$element.data('prevHtml', $element.html());"
				+ "$element.val(newText);"
				+ "$element.html(newText);", 
				component.getMarkupId(true), JavaScriptEscape.escapeJavaScript(newText));
	}

	@Override
	public CharSequence getAfterHandler(Component component) {
		return null;
	}

	@Override
	public CharSequence getSuccessHandler(Component component) {
		return String.format(""
				+ "var $element = $('#%s');"
				+ "$element.val($element.data('prevValue'));"
				+ "$element.html($element.data('prevHtml'));", 
				component.getMarkupId(true));
	}

	@Override
	public CharSequence getFailureHandler(Component component) {
		return null;
	}

	@Override
	public CharSequence getCompleteHandler(Component component) {
		return null;
	}

	@Override
	public CharSequence getDoneHandler(Component component) {
		return null;
	}

}
