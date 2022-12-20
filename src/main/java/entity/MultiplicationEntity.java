package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQuery(query = "SELECT b from MultiplicationEntity b WHERE b.multiplicationAnswer = :answer", name = "multiplicationAnswerQuery")
@NamedQuery(query = "SELECT b from MultiplicationEntity b", name = "multiplicationQuery")

@Table(name = "multiplication", schema = "grupp6", catalog = "")
public class MultiplicationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "multiplicationId")
    private int multiplicationId;
    @Basic
    @Column(name = "multiplicationQuestion")
    private String multiplicationQuestion;
    @Basic
    @Column(name = "multiplicationAnswer")
    private Integer multiplicationAnswer;

    public int getMultiplicationId() {
        return multiplicationId;
    }

    public void setMultiplicationId(int multiplicationId) {
        this.multiplicationId = multiplicationId;
    }

    public String getMultiplicationQuestion() {
        return multiplicationQuestion;
    }

    public void setMultiplicationQuestion(String multiplicationQuestion) {
        this.multiplicationQuestion = multiplicationQuestion;
    }

    public Integer getMultiplicationAnswer() {
        return multiplicationAnswer;
    }

    public void setMultiplicationAnswer(Integer multiplicationAnswer) {
        this.multiplicationAnswer = multiplicationAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MultiplicationEntity that = (MultiplicationEntity) o;

        if (multiplicationId != that.multiplicationId) return false;
        if (!Objects.equals(multiplicationQuestion, that.multiplicationQuestion))
            return false;
        return Objects.equals(multiplicationAnswer, that.multiplicationAnswer);
    }

    @Override
    public int hashCode() {
        int result = multiplicationId;
        result = 31 * result + (multiplicationQuestion != null ? multiplicationQuestion.hashCode() : 0);
        result = 31 * result + (multiplicationAnswer != null ? multiplicationAnswer.hashCode() : 0);
        return result;
    }
}
