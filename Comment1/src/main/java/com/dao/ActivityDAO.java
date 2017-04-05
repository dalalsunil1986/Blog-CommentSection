package com.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.Activity;
import com.test.Author;
import com.test.Elements;
import com.test.Href;
import com.test.Tags;

@Repository
public class ActivityDAO {

	public Activity getUserActivity() {
		Activity act = new Activity();
		Href href = new Href();
		href.setHref("/items/activities?number=10");
		act.setSelf(href);

		href.setHref("/items/activities?start-id=10&number=10");
		act.setNext(href);

		List<Elements> elems = new ArrayList<Elements>();
		Elements elem = new Elements();
		elem.setType("Activity");
		href.setHref("/external-items/c.default.United Motor Group.vyqdYHy4EdwnKQALzQzOTg/activities/23");
		elem.setSelf(href);
		elem.setContent("asdfasdfasdf");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		elem.setCreationDate(dtf.format(now));

		Author author = new Author();
		author.setName("Administrator System");
		href.setHref("/persons/system");
		author.setHref(href);
		elem.setAuthor(author);

		elem.setFlagged(false);
		elem.setSystemGenerated(false);

		Tags tag = new Tags();
		href.setHref(
				"/external-items/c.default.United Motor Group.vyqdYHy4EdwnKQALzQzOTg/activities/23/tag-assignments");
		tag.setSelf(href);

		elem.setTagAssignment(tag);

		// 2
		Elements elem1 = new Elements();
		elem1.setType("Activity");
		href.setHref("/external-items/c.default.United Motor Group.vyqdYHy4EdwnKQALzQzOTg/activities/22");
		elem1.setSelf(href);
		elem1.setContent("asdfasdf");

		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now1 = LocalDateTime.now();
		elem1.setCreationDate(dtf1.format(now1));

		Author author1 = new Author();
		author1.setName("Administrator System");
		href.setHref("/persons/system");
		author1.setHref(href);
		elem1.setAuthor(author1);

		elem1.setFlagged(false);
		elem1.setSystemGenerated(false);

		Tags tag1 = new Tags();
		href.setHref(
				"/external-items/c.default.United Motor Group.vyqdYHy4EdwnKQALzQzOTg/activities/22/tag-assignments");
		tag1.setSelf(href);

		elem.setTagAssignment(tag1);

		elems.add(elem);
		elems.add(elem1);

		act.setElements(elems);

		return act;

	}

}
