package com.alexlepsa;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface RoomRepository extends CrudRepository<Room, UUID> {

}
