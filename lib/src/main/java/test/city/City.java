package test.city;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City implements Serializable {
    @Id
    @Column(name = "city_code", length = 32, nullable = false)
    private String code;

    @Column(name = "city_name", length = 255, nullable = false)
    private String name;

    @Column(name = "state_code", length = 3, nullable = false)
    private String state;

    @Column(name = "country_code", length = 3, nullable = false)
    private String country;

    @Column(name = "zip_code", length = 12, nullable = false)
    private String zip;

    public City() {
    }

    public City(String code, String name, String state, String country, String zip) {
        this.code = code;
        this.name = name;
        this.state = state;
        this.country = country;
        this.zip = zip;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        City city = (City) o;
        return Objects.equals(code, city.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "City{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
