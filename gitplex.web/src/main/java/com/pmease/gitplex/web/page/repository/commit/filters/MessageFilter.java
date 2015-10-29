package com.pmease.gitplex.web.page.repository.commit.filters;

import com.pmease.commons.git.command.LogCommand;

public class MessageFilter extends CommitFilter {

	private static final long serialVersionUID = 1L;

	@Override
	public String getName() {
		return "message";
	}

	@Override
	public boolean isMultiple() {
		return true;
	}

	@Override
	public FilterEditor<?> newEditor(String id, FilterCallback callback) {
		return new MessageEditor(id, this);
	}

	@Override
	public void applyTo(LogCommand logCommand) {
		String value = getValue();
		if (value != null)
			logCommand.messages().add(value);
	}

}