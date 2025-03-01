package io.matoshri.learn.college;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

interface CollegeRepository extends JpaRepository<College, Integer> {

    @Query("FROM College c WHERE c.collegeName = :collegeName")
    Optional<College> findByCollegeName(@Param("collegeName") String collegeName);
}
