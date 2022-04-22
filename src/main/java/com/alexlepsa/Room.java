package com.alexlepsa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id")
    private UUID roomId;

    @Column(name = "state")
    private String state;
}
