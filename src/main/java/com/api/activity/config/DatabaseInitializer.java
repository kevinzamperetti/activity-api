package com.api.activity.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        // Verifica se há registros na tabela "activity"
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM activity", Integer.class);

        if (count == 0) { // Somente insere se não houver registros
            jdbcTemplate.execute(
                    "INSERT INTO activity(title, description, due_date, completed) " +
                        "VALUES ('Activity 1', 'Description Activity 1', '2025-10-01 12:00:00', false), " +
                                "('Activity 2', 'Description Activity 2', '2025-03-02 10:00:00', true), " +
                                "('Activity 3', 'Description Activity 3', '2025-03-03 12:30:00', true), " +
                                "('Activity 4', 'Description Activity 4', '2025-11-01 17:12:00', false), " +
                                "('Activity 5', 'Description Activity 5', '2025-03-05 08:00:00', true), " +
                                "('Activity 6', 'Description Activity 6', '2025-09-01 09:45:00', false), " +
                                "('Activity 7', 'Description Activity 7', '2025-08-07 12:15:00', true), " +
                                "('Activity 8', 'Description Activity 8', '2025-03-02 16:20:00', true), " +
                                "('Activity 9', 'Description Activity 9', '2026-12-02 00:00:00', false), " +
                                "('Activity 10', 'Description Activity 10', '2030-05-01 22:00:00', false);"
            );
            System.out.println("Initial data to use in Activity-api are inserted. Enjoy! :)");
        } else {
            System.out.println("Activity-api database populated, does not necessary insert initial data! :)");
        }
    }
}