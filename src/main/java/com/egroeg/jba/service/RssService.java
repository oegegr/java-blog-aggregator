package com.egroeg.jba.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import org.springframework.stereotype.Service;

import com.egroeg.jba.entity.Item;
import com.egroeg.jba.exception.RssException;
import com.egroeg.jba.rss.ObjectFactory;
import com.egroeg.jba.rss.TRss;
import com.egroeg.jba.rss.TRssChannel;
import com.egroeg.jba.rss.TRssItem;

@Service
public class RssService {

	public List<Item> getItems(Source source) throws RssException {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source, TRss.class);
			TRss rss = jaxbElement.getValue();
			List<TRssChannel> channels = rss.getChannel();
			for (TRssChannel channel : channels) {
				List<TRssItem> items = channel.getItem();
				for (TRssItem rssItem : items) {
					Item item = new Item();
					item.setTitle(rssItem.getTitle());
					item.setDescription(rssItem.getDescription());
					item.setLink(rssItem.getLink());
					new SimpleDateFormat("EEE, dd MMMM yyyy	HH:mm:ss Z",Locale.ENGLISH).parse(rssItem.getPubDate());
					
				}
				
			}
		} catch (JAXBException e) {
			throw new RssException(e);
		} catch (ParseException e) {
			throe new RssException(e);
		}
	}
}
