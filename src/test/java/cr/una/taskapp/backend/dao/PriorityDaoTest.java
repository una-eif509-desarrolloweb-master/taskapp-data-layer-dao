package cr.una.taskapp.backend.dao;


import cr.una.taskapp.backend.model.Priority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit Test Class
 * Priority DAO
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@Sql({
        "/import-priorities.sql"
})
// TODO: This code is to persist the information in the database
// @Sql(scripts = {"/import-priorities.sql"},
//        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class PriorityDaoTest {

    @Autowired
    private IPriorityDao priorityDao;

    @Test
    public void testFindById() {
        Priority priority = priorityDao.findById(2);

        assertEquals(priority.getLabel().toString(), "Medium");
    }

    @Test
    public void testFindAll() {
        List<Priority> priorityList = priorityDao.findAll();

        assertTrue(priorityList.size() == 3);
    }

    @Test
    public void testCreate() {
        Priority priority = new Priority();

        priority.setIdPriority(new Long(4));
        priority.setLabel("Trivial");

        priorityDao.create(priority);

        assertEquals(priority.getIdPriority(), new Long(4));
    }

    @Test
    public void testUpdate() {
        Priority priorityUpdated = new Priority();

        priorityUpdated.setIdPriority(new Long(2));
        priorityUpdated.setLabel("Medium - Updated");

        priorityDao.update(priorityUpdated);

        Priority priority = priorityDao.findById(2);
        assertEquals(priority.getLabel().toString(), "Medium - Updated");
    }

    @Test
    public void testDelete() {
        Priority priorityDeleted = new Priority();
        priorityDeleted.setIdPriority(new Long(1));

        priorityDao.delete(priorityDeleted);

        Priority priority = priorityDao.findById(1);
        assertTrue(priority == null);
    }

    @Test
    public void testDeleteById() {
        priorityDao.deleteById(new Long(1));

        Priority priority = priorityDao.findById(1);
        assertTrue(priority == null);
    }
}
