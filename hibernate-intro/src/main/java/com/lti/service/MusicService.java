package com.lti.service;

import java.util.List;

import com.lti.Dao.MusicDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

public class MusicService {

	
	MusicDao mdao = new MusicDao();
	
	public void addAlbum(Album album) {
		
	mdao.save(album);
		
	}
	
	public void addSongstoAlbum() {
		
	//	MusicDao dao=new MusicDao();
		Album alb= (Album)mdao.fetchById(Album.class,189);
		
		Song a=new Song();
		
		a.setDuration(200);
		a.setSinger("Ed sheeran");
		a.setTitle("shapeOfU");
		a.setAlbum(alb);
		
		mdao.save(a);
	}
	
	
	
	public List<Song> fetchSongsByDuration(int dur){
		MusicDao dao=new MusicDao();
		List<Song> songs= dao.fetchSongByDur(dur);
		return songs;
	}
	
	
}
