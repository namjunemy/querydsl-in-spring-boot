package io.namjune.springbootquerydsl.repository;

import io.namjune.springbootquerydsl.domain.Academy;
import java.util.List;

public interface AcademyRepositoryCustom {

    List<Academy> findByName(String name);
}
