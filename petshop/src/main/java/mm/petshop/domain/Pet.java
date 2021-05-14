package mm.petshop.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id", name="type_id")
    private PetType petType;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id", name="worker_id")
    private Worker worker;

    private Integer age;

    private Character gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id.equals(pet.id) &&
                petType.equals(pet.petType) &&
                Objects.equals(worker, pet.worker) &&
                Objects.equals(age, pet.age) &&
                Objects.equals(gender, pet.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, petType, worker, age, gender);
    }
}