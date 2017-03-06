package com.handytec.repository;

import java.util.ArrayList;
import java.util.List;

import com.handytec.model.Activity;
import com.handytec.model.ActivitySearch;
import com.handytec.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	@Override
	public List<Activity> findByConstraints(ActivitySearch search) {

		System.out.println(search.getDurationFrom());
		System.out.println(search.getSearchType());

		List<Activity> activities = new ArrayList<Activity>();
		Activity activity = new Activity();
		activity.setId(2345);
		activity.setDescription("running");
		activity.setDuration(69);
		activities.add(activity);
		return activities;
	}

	@Override
	public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {
		// select * from activities where description in (?,?,?) and duration >
		// ? and duration < ?
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity = new Activity();
		activity.setId(2345);
		activity.setDescription("running");
		activity.setDuration(69);
		activities.add(activity);
		return activities;
	}

	@Override
	public void create(Activity activity) {
		// TODO insert to db

	}

	@Override
	public void delete(String activityId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Activity update(Activity activity) {
		// TODO search to database to see if we have activity with that id
		// already
		// Select * from activity where id = ?
		// if rs size == 0
		// insert into activity table
		// else
		// update the activity

		return activity;

	}

	public List<Activity> findAllActivities() {

		List<Activity> activities = new ArrayList<Activity>();

		Activity activity1 = new Activity();

		activity1.setDescription("Swimming");
		activity1.setDuration(55);

		activities.add(activity1);

		Activity activity2 = new Activity();

		activity2.setDescription("football");

		activity2.setDuration(90);

		activities.add(activity2);

		return activities;

	}

	@Override
	public Activity findActivity(String activityId) {
		// TODO Auto-generated method stub
		// queries DATABASE
		Activity activity1 = new Activity();

		activity1.setId(1234);
		activity1.setDescription("Another Activity");
		activity1.setDuration(25);

		User user = new User();
		user.setId("1");
		user.setName("Christian");

		activity1.setUser(user);

		return activity1;
	}

}
