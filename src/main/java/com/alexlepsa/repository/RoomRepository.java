package com.alexlepsa.repository;

import com.alexlepsa.repository.model.Room;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {

}
