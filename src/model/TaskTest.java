package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void testConstructorsAndGetters() {
		// given
		int id = 1;
		String title = "washing";
		String content = "0% of dust";
		boolean isCompleted = false;
		LocalDateTime dateCreated = LocalDateTime.now();

		// when
		Task taskUsingId = new Task(id, title, content, isCompleted, dateCreated);
		Task taskNotUsingId = new Task(title, content, isCompleted, dateCreated);

		// then
		assertAll("task constructor using id",
				() -> assertEquals(id, taskUsingId.getId()),
				() -> assertEquals(title, taskUsingId.getTitle()),
				() -> assertEquals(content, taskUsingId.getContent()),
				() -> assertEquals(isCompleted, taskUsingId.isCompleted()),
				() -> assertEquals(dateCreated, taskUsingId.getDateCreated())
		);

		assertAll("task constructor not using id",
				() -> assertEquals(title, taskNotUsingId.getTitle()),
				() -> assertEquals(content, taskNotUsingId.getContent()),
				() -> assertEquals(isCompleted, taskNotUsingId.isCompleted()),
				() -> assertEquals(dateCreated, taskNotUsingId.getDateCreated())
		);
	}

	@Test
	void testSetters() {
		// given
		int id = 1;
		String title = "washing";
		String content = "0% of dust";
		boolean isCompleted = false;
		LocalDateTime dateCreated = LocalDateTime.now();

		// when
		Task task = new Task();
		task.setId(id);
		task.setTitle(title);
		task.setContent(content);
		task.setCompleted(isCompleted);
		task.setDateCreated(dateCreated);

		// then
		assertAll("task",
				() -> assertEquals(id, task.getId()),
				() -> assertEquals(title, task.getTitle()),
				() -> assertEquals(content, task.getContent()),
				() -> assertEquals(isCompleted, task.isCompleted()),
				() -> assertEquals(dateCreated, task.getDateCreated())
		);
	}

	@Test
	void shouldHaveToStringMethodOverride() {
		// given
		Task task = new Task();

		// when
		String toString = task.toString();

		// then
		assertNotEquals(task.hashCode(), toString);
	}

}
