/*
 * Universidad Nacional de Costa Rica  2020
 *
 * mike@guzmanalan.com
 */

package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit Test Class
 * Task DAO
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@Sql({
        "/import-priorities.sql",
        "/import-status.sql",
        "/import-tasks.sql",
        "/import-reminders.sql"
})
public class TaskDaoTest {

    @Autowired
    private ITaskDao taskDao;

    @Test
    public void testFindById() {
        Task task = taskDao.findById(1);

        assertEquals(task.getTitle().toString(), "Evaluate Students");
    }
}
