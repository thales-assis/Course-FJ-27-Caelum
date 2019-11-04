package br.com.caelum.course.fj27.domain;

public interface TopicState {

    void registerNewReply(Topic topic, Answer newReply);
	void markAsSolved(Topic topic);
	void close(Topic topic);
}
