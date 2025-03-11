package com.api.activity.controller;

import com.api.activity.exception.ResourceNotFoundException;
import com.api.activity.model.Activity;
import com.api.activity.model.dto.ActivityDTO;
import com.api.activity.service.ActivityService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    public ResponseEntity<List<Activity>> getActivities() {
        return new ResponseEntity<>(activityService.getActivities(), HttpStatus.OK);
    }

    @GetMapping("/activities/{id}")
    public ResponseEntity<?> getActivities(@PathVariable Long id) {

        if (activityService.getAcitivityById(id).isPresent()) {
            return new ResponseEntity<>(activityService.getAcitivityById(id).get(), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Activity " + id + " not found");

    }

    @PostMapping("/activities")
    public ResponseEntity<Activity> createActivity(@RequestBody ActivityDTO activityDTO) throws BadRequestException {
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityDTO, activity);
        return new ResponseEntity<>(activityService.saveActivity(activity), HttpStatus.CREATED);
    }

    @PutMapping("/activities/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody ActivityDTO activityDTO) throws BadRequestException {
        if (activityService.getAcitivityById(id).isPresent()) {
            Activity activity = activityService.getAcitivityById(id).get();
            BeanUtils.copyProperties(activityDTO, activity);
            //todo: bug, mesom bug do save, que por mais que informe o description, como usa o saveActivity o desccription é forçado para nulo
            return new ResponseEntity<>(activityService.saveActivity(activity), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Activity " + id + " not found");
    }

    @DeleteMapping("/activities/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Long id) {
        if (activityService.getAcitivityById(id).isPresent()) {
            activityService.deleteActivity(id);
            return new ResponseEntity<>("Activity " + id + " deleted.", HttpStatus.OK);
        }
        //todo: bug, mesmo que o id não exista ele está informando que foi excluído com sucesso
        return new ResponseEntity<>("Activity " + id + " deleted.", HttpStatus.OK);
//        throw new ResourceNotFoundException("Activity " + id + " not found.");
    }

}
