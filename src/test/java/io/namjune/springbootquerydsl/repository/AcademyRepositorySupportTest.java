package io.namjune.springbootquerydsl.repository;


import static org.assertj.core.api.Assertions.assertThat;

import io.namjune.springbootquerydsl.domain.Academy;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcademyRepositorySupportTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyRepositorySupport academyRepositorySupport;

    @After
    public void tearDown() throws Exception {
        academyRepository.deleteAllInBatch();

    }

    @Test
    public void 이름으로_찾기() {
        //given
        String name = "njkim";
        String address = "namjunemy@gmail.com";
        academyRepository.save(new Academy(name, address));

        //when
        List<Academy> result = academyRepositorySupport.findByName(name);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getAddress()).isEqualTo(address);
    }
}
