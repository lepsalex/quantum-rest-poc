package com.alexlepsa.repository;

import com.alexlepsa.repository.model.RoomSession;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface RoomSessionRepository extends CrudRepository<RoomSession, String> {

}
