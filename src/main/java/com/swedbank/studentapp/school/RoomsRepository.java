package com.swedbank.studentapp.school;

import com.swedbank.studentapp.school.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<ClassRoom, Long> {
}
