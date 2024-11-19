package com.swp_group4.back_end.repositories;

import com.swp_group4.back_end.entities.ConstructionTaskStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConstructionTaskStaffRepository extends JpaRepository<ConstructionTaskStaff, String> {



}
