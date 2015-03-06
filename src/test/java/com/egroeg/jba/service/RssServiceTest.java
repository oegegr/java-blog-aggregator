package com.egroeg.jba.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.egroeg.jba.entity.Item;
import com.egroeg.jba.exception.RssException;

public class RssServiceTest {
	
	private RssService rssService;

	@Before
	public void setUp() throws Exception {
		rssService = new RssService();
	}

	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items = rssService.getItems(new File("test-rss/javavids.xml"));
		Assert.assertEquals(10, items.size());
		Item firstItem = items.get(0);
		Assert.assertEquals("How to solve Source not found error during debug in Eclipse", firstItem.getTitle());
//		Assert.assertEquals("23 06 2014 20:35:49", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));

	}

}
