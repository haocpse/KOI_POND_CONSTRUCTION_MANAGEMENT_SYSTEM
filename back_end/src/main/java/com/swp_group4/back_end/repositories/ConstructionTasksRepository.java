package com.swp_group4.back_end.repositories;

import com.swp_group4.back_end.entities.ConstructionTasks;
import com.swp_group4.back_end.enums.ConstructStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConstructionTasksRepository extends JpaRepository<ConstructionTasks, String> {



}
