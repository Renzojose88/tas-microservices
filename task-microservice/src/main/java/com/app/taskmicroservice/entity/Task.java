package com.app.taskmicroservice.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


    @Entity
    @Table(name = "task")

    public class  Task{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String title;

        private String codetask;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCodetask() {
            return codetask;
        }

        public void setCodetask(String codetask) {
            this.codetask = codetask;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public LocalDateTime getCreateDate() {
            return createDate;
        }

        public void setCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        private String description;

        private LocalDateTime createDate;

        private boolean active;


    }

