package mm.petshop.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Sales {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id",name = "pet_id")
    private Pet pet;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id",name = "worker_id")
    private Worker worker;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id",name = "client_id")
    private Client client;

    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return id.equals(sales.id) &&
                pet.equals(sales.pet) &&
                Objects.equals(worker, sales.worker) &&
                Objects.equals(client, sales.client) &&
                price.equals(sales.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pet, worker, client, price);
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", pet=" + pet +
                ", worker=" + worker +
                ", client=" + client +
                ", price=" + price +
                '}';
    }
}