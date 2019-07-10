package com.lti.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Album;
import com.lti.entity.Song;



public class MusicDao  extends GenericDao{
	
	public List<Song> fetchSongByDur(double duration){
		
		EntityManagerFactory emf= null;
		EntityManager em =  null;
		try {
			
				emf = Persistence.createEntityManagerFactory("oracle-pu");
				em = emf.createEntityManager();
				
				String ql="Select t from Song t "
								+ "where t.duration = :dur";
				
				//Introducing JP-QL
				Query q = em.createQuery(ql);
				q.setParameter("dur",duration);
				//q.setFirstResult(10);
				//q.setMaxResults(5);
				List<Song> list= q.getResultList();
				return  list;
		}
		
		finally {
			
		em.close();
		emf.close();
		}

	}

}
