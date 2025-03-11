package com.api.activity.controller;

import com.api.activity.service.impl.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class DatabaseAdminController {

    private final DatabaseService databaseService;

    @Autowired
    public DatabaseAdminController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @PostMapping("/reset-database")
    public ResponseEntity<String> resetDatabase() {
        databaseService.resetDatabase();
        return new ResponseEntity<>("Banco de dados resetado com sucesso!", HttpStatus.OK);
    }


}
