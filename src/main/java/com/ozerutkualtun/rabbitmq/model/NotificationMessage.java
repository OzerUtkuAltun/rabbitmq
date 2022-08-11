package com.ozerutkualtun.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class NotificationMessage implements Serializable {

    private String id;
    private Date createdAt;
    private Boolean seen;
    private String message;

    @Override
    public String toString() {
        return "NotificationMessage{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", seen=" + seen +
                ", message='" + message + '\'' +
                '}';
    }
}
