package com.dvlima.ponto.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dvlima.ponto.model.Registro;

public class RegistroRepositoryImpl implements RegistroRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void removerRegistrosPontoPorData(LocalDate data) {
		String hql = "delete from Registro where data = :data ";

		Query query = em.createQuery(hql);
		query.setParameter("data", data);
		query.executeUpdate();
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Registro> obterRegistrosPelaData(LocalDate data) {
		Query query = em.createQuery("from Registro where data = :data ");
		query.setParameter("data", data);
		return query.getResultList();
	}
}
