-- Start creation of schema and User table

CREATE SCHEMA IF NOT EXISTS todolist;

CREATE TABLE IF NOT EXISTS todolist.users (
    `id`       bigint       NOT NULL AUTO_INCREMENT,
    `login`    varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS todolist.roles (
                                              `id` bigint NOT NULL AUTO_INCREMENT,
                                              `role_name` varchar(20) DEFAULT NULL,
                                              PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS todolist.users_roles (
                                                    `user_id` bigint NOT NULL,
                                                    `role_id` bigint NOT NULL,
                                                    PRIMARY KEY (`user_id`,`role_id`),
                                                    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
                                                    FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`));
