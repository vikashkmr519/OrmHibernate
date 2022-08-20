package com.mappings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int questionId;

	private String question;

	@OneToOne
	@JoinTable(name="Question_Answer_Mapping", joinColumns = @JoinColumn(name="q_id"),
	inverseJoinColumns = @JoinColumn(name="a_id"))
	private Answer answer;
	/*
	 * @JoinColumn is used to set the customised name for the column created in the
	 * Question table. In Question table a column will be created which will be same
	 * as the answer primary key column ie. answer_id column will be created. But
	 * while saving the data we have to pass the Answer object and while fetching
	 * also answer obejct will be fetched but in table it will be saved or mapped as
	 * answer_id in question table.
	 */
	
	/*
	 * Till now it was uni directional 
	 * i.e only question table was holding the foreign key
	 * but if we want bidirectional 
	 * that is both table mapping each other then we have to create a @oneToOne Mapping column
	 * in the answer class .
	 * for more check answer class.
	 */

	public Question() {
		super();
	}

	public Question(int questionId, String question, Answer answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", answer=> answer" + answer + "]";
	}

}
