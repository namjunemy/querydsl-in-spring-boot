package io.namjune.springbootquerydsl.repository;


import io.namjune.springbootquerydsl.domain.Academy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<Academy, Long> {

}
