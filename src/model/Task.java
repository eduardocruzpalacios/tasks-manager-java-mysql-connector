package model;

import java.time.LocalDateTime;

public class Task {

	private int id;
	private String title;
	private String content;
	private boolean isCompleted;
	private LocalDateTime dateCreated;

	public Task() {
	}

	public Task(String title, String content, boolean isCompleted, LocalDateTime dateCreated) {
		this.title = title;
		this.content = content;
		this.isCompleted = isCompleted;
		this.dateCreated = dateCreated;
	}

	public Task(int id, String title, String content, boolean isCompleted, LocalDateTime dateCreated) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.isCompleted = isCompleted;
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", content=" + content + ", isCompleted=" + isCompleted
				+ ", dateCreated=" + dateCreated + "]";
	}

}
