package entity;

import jakarta.persistence.*;

@Entity
@NamedQuery(query = "SELECT b from AdditionEntity b WHERE b.additionAnswer = :answer", name = "additionAnswerQuery")
@NamedQuery(query = "SELECT b from AdditionEntity b", name = "additionQuery")
@Table(name = "addition", schema = "grupp6", catalog = "")
public class AdditionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "additionId")
    private int additionId;
    @Basic
    @Column(name = "additionQuestion")
    private String additionQuestion;
    @Basic
    @Column(name = "additionAnswer")
    private Integer additionAnswer;

    public int getAdditionId() {
        return additionId;
    }

    public void setAdditionId(int additionId) {
        this.additionId = additionId;
    }

    public String getAdditionQuestion() {
        return additionQuestion;
    }

    public void setAdditionQuestion(String additionQuestion) {
        this.additionQuestion = additionQuestion;
    }

    public Integer getAdditionAnswer() {
        return additionAnswer;
    }

    public void setAdditionAnswer(Integer additionAnswer) {
        this.additionAnswer = additionAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdditionEntity that = (AdditionEntity) o;

        if (additionId != that.additionId) return false;
        if (additionQuestion != null ? !additionQuestion.equals(that.additionQuestion) : that.additionQuestion != null)
            return false;
        if (additionAnswer != null ? !additionAnswer.equals(that.additionAnswer) : that.additionAnswer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = additionId;
        result = 31 * result + (additionQuestion != null ? additionQuestion.hashCode() : 0);
        result = 31 * result + (additionAnswer != null ? additionAnswer.hashCode() : 0);
        return result;
    }
}
