package io.namjune.springbootquerydsl.repository;

import static io.namjune.springbootquerydsl.domain.QAcademy.academy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.namjune.springbootquerydsl.domain.Academy;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AcademyRepositoryImpl implements AcademyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Academy> findByName(String name) {
        return queryFactory.selectFrom(academy)
            .where(academy.name.eq(name))
            .fetch();
    }
}