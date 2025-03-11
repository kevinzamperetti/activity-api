package com.api.activity.service;

import com.api.activity.model.Activity;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface ActivityService {

    List<Activity> getActivities();

    Optional<Activity> getAcitivityById(Long id);

    Activity saveActivity(Activity activity) throws BadRequestException;

    void deleteActivity(Long id);

}
