package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subtraction", schema = "grupp6", catalog = "")
public class SubtractionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subtractionId")
    private int subtractionId;
    @Basic
    @Column(name = "subtractionQuestion")
    private String subtractionQuestion;
    @Basic
    @Column(name = "subtractionAnswer")
    private Integer subtractionAnswer;

    public int getSubtractionId() {
        return subtractionId;
    }

    public void setSubtractionId(int subtractionId) {
        this.subtractionId = subtractionId;
    }

    public String getSubtractionQuestion() {
        return subtractionQuestion;
    }

    public void setSubtractionQuestion(String subtractionQuestion) {
        this.subtractionQuestion = subtractionQuestion;
    }

    public Integer getSubtractionAnswer() {
        return subtractionAnswer;
    }

    public void setSubtractionAnswer(Integer subtractionAnswer) {
        this.subtractionAnswer = subtractionAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubtractionEntity that = (SubtractionEntity) o;

        if (subtractionId != that.subtractionId) return false;
        if (subtractionQuestion != null ? !subtractionQuestion.equals(that.subtractionQuestion) : that.subtractionQuestion != null)
            return false;
        if (subtractionAnswer != null ? !subtractionAnswer.equals(that.subtractionAnswer) : that.subtractionAnswer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subtractionId;
        result = 31 * result + (subtractionQuestion != null ? subtractionQuestion.hashCode() : 0);
        result = 31 * result + (subtractionAnswer != null ? subtractionAnswer.hashCode() : 0);
        return result;
    }
}
