package com.app.gif.apicall;


import com.app.gif.apicall.Domains.Gif;
import com.app.gif.apicall.services.GifService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiCallApplicationTests {

	@Autowired
	GifService gifService;

	@Test
	public void testGettrendinggifs(){
		Gif gifs=gifService.gettrendinggifs();
		assertTrue(gifs.getData().size()==50);
	}

	@Test
	public void testGetGif(){
		Gif gif=gifService.getGif("Season 2 Cry GIF by Amazon Prime Video");
		assertTrue(gif.getData().size()==50);
	}
}