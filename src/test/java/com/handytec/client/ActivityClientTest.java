package com.handytec.client;

import java.util.ArrayList;
import java.util.List;

import com.handytec.model.Activity;
import com.handytec.model.ActivitySearch;
import com.handytec.model.ActivitySearchType;

import junit.framework.TestCase;

public class ActivityClientTest extends TestCase {

	public void testSearchObject() {
		ActivitySearchClient client = new ActivitySearchClient();
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("biking");
		searchValues.add("running");

		ActivitySearch search = new ActivitySearch();
		search.setDescriptions(searchValues);
		search.setDurationFrom(30);
		search.setDurationTo(55);
		search.setSearchType(ActivitySearchType.SEARCH_BY_DESCRIPTION);
		List<Activity> activities = client.search(search);

		System.out.println(activities);

		assertNotNull(activities);

	}

	public void testSearch() {
		ActivitySearchClient client = new ActivitySearchClient();
		String param = "description";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("swimming");
		searchValues.add("running");

		String secondParam = "durationFrom";
		int durationFrom = 30;

		String thirdParam = "durationTo";
		int durationTo = 55;

		List<Activity> activities = client.search(param, searchValues, secondParam, durationFrom, thirdParam,
				durationTo);
		// System.out.println(activities);
		assertNotNull(activities);
	}

	public void testDelete() {

		// Activity activity = new Activity();
		// activity.setId(1235);
		ActivityClient client = new ActivityClient();

		client.delete("1235");

	}

	public void testPut() {
		Activity activity = new Activity();
		activity.setId(1235);
		activity.setDuration(65);
		activity.setDescription("Yoga");

		ActivityClient client = new ActivityClient();
		activity = client.update(activity);

		assertNotNull(activity);
	}

	public void testCreate() {
		ActivityClient client = new ActivityClient();
		Activity activity = new Activity();
		activity.setDescription("Swimming");
		activity.setDuration(90);
		activity = client.create(activity);

		assertNotNull(activity);
	}

	public void testGet() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("1431");
		System.out.println(activity);
		assertNotNull(activity);
	}

	public void testGetList() {
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.get();
		System.out.println(activities);
		assertNotNull(activities);
	}

}
