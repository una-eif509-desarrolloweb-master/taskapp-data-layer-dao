package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.Priority;

/**
 * DAO for Priority
 */
public interface IPriorityDao {
    public Priority findById (final long id);
}
