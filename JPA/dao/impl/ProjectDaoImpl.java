package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.Dao;
import com.endava.jpa.model.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProjectDaoImpl implements Dao<Project> {

	@PersistenceContext
	private EntityManager entityManager;

	private String QUERY_FIND_PROJECT_BY_NAME = "Select p from Project p where p.name = :proj_name";

	public Project find(int id) {
		return entityManager.find(Project.class, id);
	}

	public List<Project> find(String projectName) {
		return entityManager.createQuery(QUERY_FIND_PROJECT_BY_NAME)
				.setParameter("proj_name", projectName)
				.getResultList();
	}

	public void save(Project toBeSaved) {
		entityManager.persist(toBeSaved);
		entityManager.flush();
	}

	public void update(Project toBeUpdated) {
		Project mergedProject = entityManager.merge(toBeUpdated);
		mergedProject.setName("Forever-Testing");
	}

	public void remove(Project toBeRemoved) {
		entityManager.remove(toBeRemoved);
	}
}
