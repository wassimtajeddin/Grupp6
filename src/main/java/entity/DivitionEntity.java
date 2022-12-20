package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@NamedQuery(query = "SELECT b from DivitionEntity b WHERE b.divitionAnswer = :answer", name = "divitionAnswerQuery")
@NamedQuery(query = "SELECT b from DivitionEntity b", name = "divitionQuery")
@Table(name = "divition", schema = "grupp6", catalog = "")
public class DivitionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "divitionId")
    private int divitionId;
    @Basic
    @Column(name = "divitionQuestion")
    private String divitionQuestion;
    @Basic
    @Column(name = "divitionAnswer")
    private Integer divitionAnswer;

    public int getDivitionId() {
        return divitionId;
    }

    public void setDivitionId(int divitionId) {
        this.divitionId = divitionId;
    }

    public String getDivitionQuestion() {
        return divitionQuestion;
    }

    public void setDivitionQuestion(String divitionQuestion) {
        this.divitionQuestion = divitionQuestion;
    }

    public Integer getDivitionAnswer() {
        return divitionAnswer;
    }

    public void setDivitionAnswer(Integer divitionAnswer) {
        this.divitionAnswer = divitionAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DivitionEntity that = (DivitionEntity) o;

        if (divitionId != that.divitionId) return false;
        if (!Objects.equals(divitionQuestion, that.divitionQuestion))
            return false;
        return Objects.equals(divitionAnswer, that.divitionAnswer);
    }

    @Override
    public int hashCode() {
        int result = divitionId;
        result = 31 * result + (divitionQuestion != null ? divitionQuestion.hashCode() : 0);
        result = 31 * result + (divitionAnswer != null ? divitionAnswer.hashCode() : 0);
        return result;
    }
}
