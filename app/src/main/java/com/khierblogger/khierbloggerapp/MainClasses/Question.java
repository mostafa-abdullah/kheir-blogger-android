package com.khierblogger.khierbloggerapp.MainClasses;

import java.util.Date;

public class Question {

    private long id;
    private long user_id;
    private long event_id;
    private String question ;
    private String question_body;
    private String answer ;
    private Date answered_at;
    private Date created_at;
    private Date updated_at;

    private Question(long id, long userId, long eventId, String question, String questionBody, String answer, Date answeredAt, Date createdAt, Date updatedAt) {
        this.id = id;
        this.user_id = userId;
        this.event_id = eventId;
        this.question = question;
        this.question_body = questionBody;
        this.answer = answer;
        this.answered_at = answeredAt;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
    }


    public long getId() {
        return id;
    }

    public long getUserId() {
        return user_id;
    }

    public long getEventId() {
        return event_id;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestionBody() {
        return question_body;
    }

    public String getAnswer() {
        return answer;
    }

    public Date getAnsweredAt() {
        return answered_at;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }
}
