package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.Dao.AccountDao;
import com.lti.Dao.GenericDao;
import com.lti.Dao.MusicDao;
import com.lti.entity.Account;
import com.lti.entity.Album;
import com.lti.entity.Customer;
import com.lti.entity.Order;
import com.lti.entity.Song;
import com.lti.service.MusicService;

public class MusicTest {


	@Test
	public void testAddAlbum() {

		Album album = new Album();
		
		album.setName("xyz");
		album.setCopyright("pqr");
		album.setYear(1997);
		
		MusicService ms =new MusicService();
		
		ms.addAlbum(album);
				
	}
		
		@Test
		public void songInsert() {
			
			MusicService musServ=new MusicService();
			
			musServ.addSongstoAlbum();
	
		}
		
		public void testFetchSongs() {
			
			/*MusicDao dao=new MusicDao();
			List<Song> songs= dao.fetchSongByDur(240);*/
			MusicService service = new MusicService();
			
			List<Song> songs = service.fetchSongsByDuration(240);
			
			for(Song a : songs) {
				System.out.println(a.getId());
				System.out.println(a.getDuration());
				System.out.println(a.getTitle());
				System.out.println(a.getSinger());
			
		}
		}
	}


