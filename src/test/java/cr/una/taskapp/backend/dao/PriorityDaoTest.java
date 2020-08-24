package cr.una.taskapp.backend.dao;


import cr.una.taskapp.backend.model.Priority;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@Sql({
        "/import-priorities.sql"
})
public class PriorityDaoTest {

    @Autowired
    private IPriorityDao priorityDao;

    @Test
    public void testFindById() {
        Priority priority = priorityDao.findById(2);

        assertEquals(priority.getLabel().toString(), "Medium");
    }
}
