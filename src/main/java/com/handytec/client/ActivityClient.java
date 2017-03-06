package com.handytec.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.handytec.model.Activity;

public class ActivityClient {
	private Client client;

	public ActivityClient() {
		client = ClientBuilder.newClient();

	};

	public Activity get(String id) {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
		System.out.println("response: " + response);
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : there was an error on the server.");
		}
		return response.readEntity(Activity.class);
	};

	public List<Activity> get() {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Activity>>() {
				});

		return response;
	}

	public Activity create(Activity activity) {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		// TODO Auto-generated method stub
		Response response = target.path("activities/activity").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		System.out.println("response: " + response);
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : there was an error on the server.");
		}
		return response.readEntity(Activity.class);
	}

	public Activity update(Activity activity) {
		// TODO Auto-generated method stub
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		Response response = target.path("activities/" + activity.getId()).request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(activity, MediaType.APPLICATION_JSON));
		System.out.println("response: " + response);
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : there was an error on the server.");
		}
		return response.readEntity(Activity.class);
	}

	public void delete(String activityId) {
		// TODO Auto-generated method stub
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");

		Response response = target.path("activities/" + activityId).request(MediaType.APPLICATION_JSON).delete();
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : there was an error on the server.");
		}
		;
	};

}
