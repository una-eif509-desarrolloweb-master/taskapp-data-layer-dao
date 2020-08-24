package cr.una.taskapp.backend.dao;


import cr.una.taskapp.backend.model.Priority;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
public class PriorityDaoTest {

    @Autowired
    private IPriorityDao priorityDao;

    public void testFindById() {
        Priority priority = priorityDao.findById(0);

        assertTrue(priority.getLabel() == "High");
    }
}
