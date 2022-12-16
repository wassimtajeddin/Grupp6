package entity;

import jakarta.persistence.*;

@Entity
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
        if (multiplicationQuestion != null ? !multiplicationQuestion.equals(that.multiplicationQuestion) : that.multiplicationQuestion != null)
            return false;
        if (multiplicationAnswer != null ? !multiplicationAnswer.equals(that.multiplicationAnswer) : that.multiplicationAnswer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = multiplicationId;
        result = 31 * result + (multiplicationQuestion != null ? multiplicationQuestion.hashCode() : 0);
        result = 31 * result + (multiplicationAnswer != null ? multiplicationAnswer.hashCode() : 0);
        return result;
    }
}
