package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.Priority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * DAO for Priority
 */
@Repository
public class PriorityDao implements IPriorityDao {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public Priority findById(final long id) {
        return getCurrentSession().get(Priority.class, id);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
