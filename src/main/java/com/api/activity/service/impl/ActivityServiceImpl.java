package com.api.activity.service.impl;

import com.api.activity.exception.BadRequestException;
import com.api.activity.model.Activity;
import com.api.activity.repository.ActivityRepository;
import com.api.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository repository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.repository = activityRepository;
    }

    @Override
    public List<Activity> getActivities() {
        return repository.findAll();
    }

    @Override
    public Optional<Activity> getAcitivityById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Activity saveActivity(Activity activity) throws BadRequestException {
        if (activity.getTitle() == null) {
            throw new BadRequestException("Title can't be null");
        }
        if (activity.getDescription() == null) {
            throw new BadRequestException("Description can't be null");
        }
        if (activity.getDueDate() == null) {
            throw new BadRequestException("Due Date can't be null");
        }
        if (activity.getCompleted() == null) {
            throw new BadRequestException("Completed can't be null");
        }
        //todo: bug, mesmo que insira o description vazia, forço o null para gerar um bug
        activity.setDescription(null);
        return repository.save(activity);
    }

    @Override
    public void deleteActivity(Long id) {
        //todo: bug, mesmo que chame o delete e diga que foi deleted with success, o registro permanece na base de dados
//        repository.deleteById(id);
    }

}
