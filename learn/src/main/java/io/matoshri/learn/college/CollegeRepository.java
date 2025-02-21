package io.matoshri.learn.college;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {

    @Query("FROM College c WHERE c.collegeName = :collegeName")
    Optional<College> findByCollegeName(@Param("collegeName") String collegeName);
}
