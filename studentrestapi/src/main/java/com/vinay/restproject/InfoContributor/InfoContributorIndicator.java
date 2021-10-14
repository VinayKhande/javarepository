package com.vinay.restproject.InfoContributor;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
@Component
public class InfoContributorIndicator implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("Type", "Learning Experiment");
		builder.withDetail("Time Spent", "2.5 hrs");
	}

}
