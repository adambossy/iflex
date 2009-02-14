package com.healthySoftware.client.main;

import com.google.gwt.user.client.ui.TabPanel;
import com.healthySoftware.client.FUIContainer;
import com.healthySoftware.client.main.build.BuildTab;
import com.healthySoftware.client.main.schedule.ScheduleTab;
import com.healthySoftware.client.main.share.ShareTab;

public class TabContainer extends TabPanel {
	
	BuildTab buildTab = null;
	
	ScheduleTab scheduleTab = null;
	
	ShareTab shareTab = null;	
	
	public TabContainer(FUIContainer container) {
		add((buildTab = new BuildTab(container)), "Build");
//		this.add((scheduleTab = new ScheduleTab()), "Schedule");
//		this.add((shareTab = new ShareTab()), "Share");
		selectTab(0);
		setSize("100%", "500px");
		addStyleName("tab-container");
	}

	public BuildTab getBuildTab() {
		return buildTab;
	}

	public void setBuildTab(BuildTab buildTab) {
		this.buildTab = buildTab;
	}

	public ScheduleTab getScheduleTab() {
		return scheduleTab;
	}

	public void setScheduleTab(ScheduleTab scheduleTab) {
		this.scheduleTab = scheduleTab;
	}

	public ShareTab getShareTab() {
		return shareTab;
	}

	public void setShareTab(ShareTab shareTab) {
		this.shareTab = shareTab;
	}
}
