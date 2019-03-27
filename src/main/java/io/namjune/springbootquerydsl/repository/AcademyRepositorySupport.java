package io.namjune.springbootquerydsl.repository;


import static io.namjune.springbootquerydsl.domain.QAcademy.academy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.namjune.springbootquerydsl.domain.Academy;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class AcademyRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public AcademyRepositorySupport(JPAQueryFactory queryFactory) {
        super(Academy.class);
        this.queryFactory = queryFactory;
    }

    public List<Academy> findByName(String name) {
        return queryFactory
            .selectFrom(academy)
            .where(academy.name.eq(name))
            .fetch();
    }
}
